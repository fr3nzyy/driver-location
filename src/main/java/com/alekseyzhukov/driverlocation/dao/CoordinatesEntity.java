package com.alekseyzhukov.driverlocation.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "myschema", name = "coordinates_entity")
public class CoordinatesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "driver_id", nullable = false)
    private Integer driverId;
    @Column(name = "latitude", nullable = false, scale = 2, precision = 20)
    private BigDecimal latitude;
    @Column(name = "longitude", nullable = false, scale = 2, precision = 20)
    private BigDecimal longitude;
    @Column(name = "time", nullable = false)
    private LocalDateTime time;
}
