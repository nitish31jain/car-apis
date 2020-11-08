package com.nitish.tdd.controller;

import com.nitish.tdd.entity.Car;
import com.nitish.tdd.exception.CarNotFoundException;
import com.nitish.tdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void test_getCar_shouldReturnDetails() throws Exception {
        given(carService.getCarDetails(anyString()))
                .willReturn(Arrays.asList(new Car("tesla", "electric")));
        mockMvc.perform(MockMvcRequestBuilders.get("/car/tesla"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("tesla"))
                .andExpect(jsonPath("type").value("electric"));
    }

    @Test
    public void test_getCar_notFound() throws Exception {
        given(carService.getCarDetails(anyString())).willReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.get("/car/tesla"))
                .andExpect(status().isNotFound());
    }
}