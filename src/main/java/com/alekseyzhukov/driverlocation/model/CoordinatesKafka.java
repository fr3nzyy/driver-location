package com.alekseyzhukov.driverlocation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesKafka {
    private Integer driverId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime time;
}
