package com.nitish.tdd.integration;

import com.nitish.tdd.entity.Car;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CarIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void test_getCarDetails_success() {
        //arrange

        // act
        ResponseEntity<Car> responseEntity = restTemplate.getForEntity("/car/tesla", Car.class);

        // assert
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getName()).isEqualTo("tesla");
        assertThat(responseEntity.getBody().getType()).isEqualTo("electric");
    }
}
