package com.ford.api.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ford.api.springboot.domains.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {    
}
