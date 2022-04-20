package com.alekseyzhukov.driverlocation.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CoordinatesDTO {
    private Integer driverId;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime time;
    private boolean zombie;
}
