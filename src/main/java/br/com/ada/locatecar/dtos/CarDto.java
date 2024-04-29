package br.com.ada.locatecar.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.lang.reflect.Array;
import java.math.BigDecimal;

@Entity
@Data
public class CarDto {
    @Id
    private long id;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private long year;
    @Column(name = "color")
    private String color;
    @Column(name = "mileage")
    private long mileage;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "fuelType")
    private String fuelType;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "engine")
    private String engine;
    @Column(name = "horsepower")
    private int horsepower;
//    private Array features;
    @Column(name = "owners")
    private int owners;
    @Column(name = "image")
    private String image;
}
