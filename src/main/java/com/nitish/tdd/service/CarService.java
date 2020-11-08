package com.nitish.tdd.service;

import com.nitish.tdd.entity.Car;
import com.nitish.tdd.exception.CarNotFoundException;
import com.nitish.tdd.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCarDetails(String name) {
        List<Car> cars = carRepository.findAllByName(name);
        if (cars == null) {
            throw new CarNotFoundException();
        }
        return cars;
    }
}
