package com.ford.api.springboot.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.api.springboot.domains.Vehicle;
import com.ford.api.springboot.services.VehicleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<Map<String,List<Vehicle>>> list() {
        return ResponseEntity.ok(Map.of("data",vehicleService.listAll()));
    }

}
