package com.ford.api.springboot.domains;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    private Integer id;
    private String model;
    private Integer totalSales;
    private Integer connected;
    private Integer softwareUpdated;
}
