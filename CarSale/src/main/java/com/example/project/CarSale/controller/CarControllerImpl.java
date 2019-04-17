package com.example.project.CarSale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.CarSale.exception.ServiceException;
import com.example.project.CarSale.model.Car;
import com.example.project.CarSale.services.CarService;

@RestController
@RequestMapping(value = "/api")
public class CarControllerImpl implements CarController{

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public List<Car> fetchAllCars() {
        return carService.findAllCars();
    }

    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        try {
            carService.saveCar(carService.validateRequiredFields(car));
            return ResponseEntity.ok(car);
        }catch(ServiceException se) {
            se.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/car/{id}", method = RequestMethod.GET)
    public Car getCarById(@PathVariable Integer id) {
        return carService.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delelteCar(@RequestBody Car car) {
        return carService.deleteCar(car);
    }

}