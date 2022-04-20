package com.alekseyzhukov.driverlocation;

import com.alekseyzhukov.driverlocation.service.DistanceCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DistanceCalculatorTest {

    @Test
    void distanceTest() {
        double distance = DistanceCalculator.distance(
                BigDecimal.valueOf(32.9697), BigDecimal.valueOf(-96.80322),
                BigDecimal.valueOf(29.46786), BigDecimal.valueOf(-98.53506));
        Assertions.assertEquals(422.73893139401383, distance);
        Assertions.assertTrue(distance > 0.5);
    }
}
