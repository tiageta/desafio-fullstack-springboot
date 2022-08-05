package com.ford.api.springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ford.api.springboot.domains.VehicleData;
import com.ford.api.springboot.repositories.VehicleDataRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleDataService {
    private final VehicleDataRepository vehicleDataRepository;

    public List<VehicleData> listAll() {
        return vehicleDataRepository.findAll();
    }
}
