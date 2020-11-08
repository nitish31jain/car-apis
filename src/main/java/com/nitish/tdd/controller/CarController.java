package com.nitish.tdd.controller;

import com.nitish.tdd.entity.Car;
import com.nitish.tdd.exception.CarNotFoundException;
import com.nitish.tdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{name}")
    private ResponseEntity<Car> gerCar(@PathVariable String name) {
        return new ResponseEntity<Car>(
                carService.getCarDetails(name), HttpStatus.OK);
    }
}