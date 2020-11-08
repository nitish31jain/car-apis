package com.nitish.tdd.repository;

import com.nitish.tdd.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test_getCar_returnsCarDetails() {
        // Car savedCar = entityManager.persistAndFlush(new Car("tesla", "electric"));
        Car savedCar = carRepository.save(new Car("tesla", "electric"));
        List<Car> cars = carRepository.findAllByName("tesla");

        assertThat(cars.get(0).getName()).isEqualTo(savedCar.getName());
        assertThat(cars.get(0).getType()).isEqualTo(savedCar.getType());
    }
}