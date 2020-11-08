package com.nitish.tdd.service;

import com.nitish.tdd.entity.Car;
import com.nitish.tdd.exception.CarNotFoundException;
import com.nitish.tdd.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

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
        given(carRepository.findAllByName(("tesla")))
                .willReturn(Arrays.asList(new Car("tesla", "electric")));

        List<Car> cars = carService.getCarDetails("tesla");

        assertThat(cars.get(0).getName()).isEqualTo("tesla");
        assertThat(cars.get(0).getType()).isEqualTo("electric");
    }

    @Test (expected = CarNotFoundException.class)
    public void test_getCarDetails_notFound() {
        given(carRepository.findAllByName("tesla")).willReturn(null);

        carService.getCarDetails("tesla");
    }
}