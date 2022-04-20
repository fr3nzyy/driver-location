package com.alekseyzhukov.driverlocation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CoordinatesRepository extends JpaRepository<CoordinatesEntity, Integer> {
    Optional<CoordinatesEntity> findFirstByDriverIdOrderByTimeDesc(Integer id);

    Optional<CoordinatesEntity> findFirstByDriverIdAndTimeBefore(Integer id, LocalDateTime time);

    Optional<CoordinatesEntity> findByDriverId(Integer id);

    Optional<CoordinatesEntity> findLastByDriverIdOrderByTime(Integer id);

    Optional<CoordinatesEntity> findFirstByDriverIdAndTimeIsLessThan(Integer id, LocalDateTime time);

    Optional<CoordinatesEntity> findFirstByDriverIdAndTimeIsGreaterThan(Integer id, LocalDateTime time);

    Optional<CoordinatesEntity> findCoordinatesEntityByIdAndTimeIsLessThan(Integer id, LocalDateTime time);
}
