package com.example.SpringSecurityCifrado.domain;

//import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fabricante")
    private String manufacturer;
    private String model; // CONTAINS
    private Double cc;
    private Integer doors;

    private Integer cyear; // IN
    private LocalDate releaseDate; // BETWEEN
    private Boolean available; // True or False

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Double getCc() {
        return cc;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getCyear() {
        return cyear;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setCyear(Integer cyear) {
        this.cyear = cyear;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", cc=" + cc + ", doors="
                + doors + ", c_year=" + cyear + ", releaseDate=" + releaseDate + ", available=" + available + "]";
    }

}