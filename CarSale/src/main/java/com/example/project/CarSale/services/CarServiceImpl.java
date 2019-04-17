package com.example.project.CarSale.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.CarSale.exception.ServiceException;
import com.example.project.CarSale.model.Car;
import com.example.project.CarSale.repo.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    //Validate the required field - In here validate the Model and Number of the Car
    @Override
    public Car validateRequiredFields(Car car){
        if (car.getModel().isEmpty() || car.getNumber().isEmpty()){
            throw new ServiceException("Required field / fields are empty");
        }
        return car;
    }

    //Return all the Cars in Car repository
    @Override
    public List<Car> findAllCars() {
        List<Car>  allcars = carRepository.findAll();
        return allcars;
    }

    //Save Car object and return that Car object
    public Car saveCar(Car car){
            carRepository.save(car);
            return car;
    }

    //Update rhe existing Car object
    @Override
    public Car updateCar(Car newCar) {
        Car updatedCar = null;
        if(newCar.getId() != null){
            carRepository.save(newCar);
            updatedCar = newCar ;
        }
        return updatedCar;
    }

    /*
    Return a Car according to the given id.
    If Car does not exist for the given id, this method return null
     */
    @Override
    public Car findById(Integer id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()) {
            return car.get();
        }else {
            return null;
        }
    }

    /*
    Delete the given Car and return a message with deleted Car - number
     */
    @Override
    public String deleteCar(Car car) {
        String number = car.getNumber();
        carRepository.delete(car);
        return "Number:"+number+" - car deleted";
    }


}
