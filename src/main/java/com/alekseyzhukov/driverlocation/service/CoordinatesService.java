package com.alekseyzhukov.driverlocation.service;

import com.alekseyzhukov.driverlocation.dao.CoordinatesEntity;
import com.alekseyzhukov.driverlocation.dao.CoordinatesRepository;
import com.alekseyzhukov.driverlocation.model.CoordinatesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "customerCache")
public class CoordinatesService {

    @Value(value = "${app.zombie.distance}")
    private double zombieDistance;
    @Value(value = "${app.zombie.minutes}")
    private Long zombieMinutes;

    private final CoordinatesRepository coordinatesRepository;

    Logger LOG = LoggerFactory.getLogger(CoordinatesService.class);

    public CoordinatesService(CoordinatesRepository coordinatesRepository) {
        this.coordinatesRepository = coordinatesRepository;
    }

    public void saveCoordiantes(CoordinatesDTO dto) {
        LOG.info("Saving new coordinates for id {}", dto.getDriverId());
        coordinatesRepository.save(
                CoordinatesEntity.builder()
                        .driverId(dto.getDriverId())
                        .latitude(dto.getLatitude())
                        .longitude(dto.getLongitude())
                        .time(dto.getTime())
                        .build()
        );
    }

    public CoordinatesDTO getById(Integer id) throws Exception {
        CoordinatesEntity currentCoordinatesEntity = coordinatesRepository.findFirstByDriverIdOrderByTimeDesc(id)
                .orElseThrow(() -> new Exception("No id found"));
        CoordinatesDTO coordinatesDTO = CoordinatesDTO.builder()
                .driverId(currentCoordinatesEntity.getDriverId())
                .build();
        LocalDateTime minusMinutes = LocalDateTime.now(ZoneId.of("Turkey")).minusMinutes(zombieMinutes);
        Optional<CoordinatesEntity> previousCoordinatesEntityOptional =
                coordinatesRepository.findFirstByDriverIdAndTimeBefore(
                        id, minusMinutes);
        previousCoordinatesEntityOptional.ifPresent(
                previousCoordinatesEntity -> {
                    double distance = DistanceCalculator.distance(
                            previousCoordinatesEntity.getLatitude(), previousCoordinatesEntity.getLongitude(),
                            currentCoordinatesEntity.getLatitude(), currentCoordinatesEntity.getLongitude());
                    if (distance < zombieDistance) {
                        coordinatesDTO.setZombie(true);
                    }
                });
        LOG.info("Found id: {}, zombie: {} ", currentCoordinatesEntity.getId(), coordinatesDTO.isZombie());
        return coordinatesDTO;
    }

    public List<CoordinatesEntity> getAll() {
        List<CoordinatesEntity> coordinatesEntities = new ArrayList<>();
        Iterable<CoordinatesEntity> all = coordinatesRepository.findAll();
        all.forEach(coordinatesEntities::add);
        return coordinatesEntities;
    }

}
