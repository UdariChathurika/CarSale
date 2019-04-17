package com.example.project.CarSale.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.CarSale.model.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {

}
