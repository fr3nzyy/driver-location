package com.alekseyzhukov.driverlocation.controller;

import com.alekseyzhukov.driverlocation.dao.CoordinatesEntity;
import com.alekseyzhukov.driverlocation.model.CoordinatesDTO;
import com.alekseyzhukov.driverlocation.service.CoordinatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("drivers")
@RequiredArgsConstructor
public class DriverLocationController {

    private final CoordinatesService coordinatesService;

    @GetMapping(path = "{id}", consumes = "application/json")
    public CoordinatesDTO getLocation(@PathVariable Integer id) throws Exception {
        return coordinatesService.getById(id);
    }

    @GetMapping(path = "/all/all", consumes = "application/json")
    public List<CoordinatesEntity> getAll() throws Exception {
        return coordinatesService.getAll();
    }

}
