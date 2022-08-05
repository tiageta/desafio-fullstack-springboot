package com.ford.api.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ford.api.springboot.domains.Vehicle;
import com.ford.api.springboot.repositories.VehicleRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public List<Vehicle> listAll() {
        return vehicleRepository.findAll();
    }
}
