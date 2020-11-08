package com.nitish.tdd.repository;

import com.nitish.tdd.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
    List<Car> findAllByName(String name);
}
