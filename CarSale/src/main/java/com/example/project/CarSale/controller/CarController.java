package com.example.project.CarSale.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.project.CarSale.model.Car;

public interface CarController {

    public List<Car> fetchAllCars();

    public ResponseEntity<Car> saveCar(Car car);

    public Car getCarById(Integer id);

    public Car updateCar(Car car);

    public String delelteCar(Car car);
}
