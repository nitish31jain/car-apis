package com.nitish.tdd.repository;

import com.nitish.tdd.entity.Car;
import com.nitish.tdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
public class CachingTest {
    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @Test
    public void test_caching() {
        given(carRepository.findAllByName(anyString()))
                .willReturn(Arrays.asList(new Car("tesla", "electric")));

        carService.getCarDetails("tesla");
        carService.getCarDetails("tesla");

        verify(carRepository, times(2))
                .findAllByName("tesla");
    }
}