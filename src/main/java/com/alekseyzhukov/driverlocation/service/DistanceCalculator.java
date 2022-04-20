package com.alekseyzhukov.driverlocation.service;

import java.math.BigDecimal;

public class DistanceCalculator {

    public static double distance(BigDecimal lat1bg, BigDecimal lon1bg, BigDecimal lat2bg, BigDecimal lon2bg) {
        double lat1 = lat1bg.doubleValue();
        double lat2 = lat2bg.doubleValue();
        double lon1 = lon1bg.doubleValue();
        double lon2 = lon2bg.doubleValue();
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
            return (dist);
        }
    }
}
