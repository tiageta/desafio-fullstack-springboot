package com.ford.api.springboot.domains;

import javax.persistence.Entity;
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
    private Integer id;
    private String vin;
    private String odometer;
    private String tirePressure;
    private String vehicleStatus;
    private String batteryStatus;
    private String fuelLevel;
    private String latitude;
    private String longitude;

}
