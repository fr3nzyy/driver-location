package com.alekseyzhukov.driverlocation.service;

import com.alekseyzhukov.driverlocation.model.CoordinatesDTO;
import com.alekseyzhukov.driverlocation.model.CoordinatesKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class KafkaListeners {

    @Value(value = "${spring.kafka.coordinates-topic}")
    private String coordinatesTopic = "";

    private final CoordinatesService coordinatesService;

    Logger LOG = LoggerFactory.getLogger(KafkaListeners.class);

    public KafkaListeners(CoordinatesService coordinatesService) {
        this.coordinatesService = coordinatesService;
    }

    @KafkaListener(topics = "coordinates", groupId = "group")
    void listener(CoordinatesKafka coordinatesKafka) {
        LOG.info(String.valueOf(coordinatesKafka));
        coordinatesService.saveCoordiantes(
                CoordinatesDTO.builder()
                        .driverId(coordinatesKafka.getDriverId())
                        .latitude(coordinatesKafka.getLatitude())
                        .longitude(coordinatesKafka.getLongitude())
                        .time(coordinatesKafka.getTime())
                        .build()
        );
    }

}