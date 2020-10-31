package com.nitish.tdd.service;

import com.nitish.tdd.entity.Car;
import com.nitish.tdd.exception.CarNotFoundException;
import com.nitish.tdd.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    public void test_getCarDetails() {
        given(carRepository.findByName("tesla")).willReturn(new Car("tesla", "electric"));

        Car car = carService.getCarDetails("tesla");

        assertThat(car.getName()).isEqualTo("tesla");
        assertThat(car.getType()).isEqualTo("electric");
    }

    @Test (expected = CarNotFoundException.class)
    public void test_getCarDetails_notFound() {
        given(carRepository.findByName("tesla")).willReturn(null);

        carService.getCarDetails("tesla");
    }
}