package com.ford.api.springboot.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public VehicleData findById(int id) {
        return vehicleDataRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vehicle data not found"));
    }

    public VehicleData save(VehicleData vehicleData) {
        vehicleData.setId(null);
        if(vehicleData.getOdometer() == null) vehicleData.setOdometer("");
        if(vehicleData.getFuelLevel() == null) vehicleData.setFuelLevel("");
        if(vehicleData.getVehicleStatus() == null) vehicleData.setVehicleStatus("");
        if(vehicleData.getLatitude() == null) vehicleData.setLatitude("");
        if(vehicleData.getLongitude() == null) vehicleData.setLongitude("");
        return vehicleDataRepository.save(vehicleData);
    }

    public void delete(int id) {
        vehicleDataRepository.delete(findById(id));
    }

    public void replace(int id, VehicleData vehicleData) {
        VehicleData updatedVehicleData = findById(id); // will throw error if not found
        if(vehicleData.getOdometer() != null)
            updatedVehicleData.setOdometer(vehicleData.getOdometer());
        if(vehicleData.getFuelLevel() != null)
            updatedVehicleData.setFuelLevel(vehicleData.getFuelLevel());
        if(vehicleData.getVehicleStatus() != null)
            updatedVehicleData.setVehicleStatus(vehicleData.getVehicleStatus());
        if(vehicleData.getLatitude() != null)
            updatedVehicleData.setLatitude(vehicleData.getLatitude());
        if(vehicleData.getLongitude() != null)
            updatedVehicleData.setLongitude(vehicleData.getLongitude());
        System.out.println(updatedVehicleData);
        vehicleDataRepository.save(updatedVehicleData);
    }
}
