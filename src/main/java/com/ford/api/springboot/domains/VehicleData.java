package com.ford.api.springboot.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VehiclesData")
public class VehicleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vin;
    private String odometer;
    private String vehicleStatus;
    private String fuelLevel;
    private String latitude;
    private String longitude;

}
