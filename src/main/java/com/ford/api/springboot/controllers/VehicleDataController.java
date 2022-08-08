package com.ford.api.springboot.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.api.springboot.domains.VehicleData;
import com.ford.api.springboot.services.VehicleDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("vehiclesData")
@RequiredArgsConstructor
public class VehicleDataController {
    private final VehicleDataService vehicleDataService;

    @GetMapping
    public ResponseEntity<Map<String,List<VehicleData>>> list() {
        return ResponseEntity.ok(Map.of("data",vehicleDataService.listAll()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Map<String,VehicleData>> findById(@PathVariable int id) {
        return ResponseEntity.ok(Map.of("data",vehicleDataService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Map<String,VehicleData>> save(@RequestBody VehicleData vehicleData) {
        return new ResponseEntity<>(Map.of("data", vehicleDataService.save(vehicleData)), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        vehicleDataService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replace(@PathVariable int id, @RequestBody VehicleData vehicleData) {
        vehicleDataService.replace(id, vehicleData);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
