package com.ford.api.springboot.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.api.springboot.domains.VehicleData;
import com.ford.api.springboot.services.VehicleDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("vehiclesData")
@RequiredArgsConstructor
public class VehicleDataController {
    private final VehicleDataService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleData>> list() {
        return ResponseEntity.ok(vehicleService.listAll());
    }

}
