package com.nitish.tdd.controller;

import com.nitish.tdd.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CarNotFoundException.class)
    private void carNotFoundHandler(CarNotFoundException exception) {

    }
}
