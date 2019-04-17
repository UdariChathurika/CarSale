package com.example.project.CarSale.services;

import java.util.Date;
import java.util.List;

import com.example.project.CarSale.exception.ServiceException;
import com.example.project.CarSale.model.Car;

public interface CarService {

    Car validateRequiredFields(Car car);

    List<Car> findAllCars();

    Car saveCar(Car car);

    Car updateCar(Car car);

    Car findById(Integer id);

    String deleteCar (Car car);
}
