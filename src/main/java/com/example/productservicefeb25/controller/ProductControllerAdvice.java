package com.example.productservicefeb25.controller;

import com.example.productservicefeb25.dto.ExceptionDTO;
import com.example.productservicefeb25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//@ControllerAdvice(assignableTypes = {ProductController.class})

public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)//it changes the status in postman from 200ok to 404 not found
    @ResponseBody

    private ExceptionDTO handleProductNotFoundException(ProductNotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(e.getMessage());
        exceptionDTO.setStatus("Failure");
        return exceptionDTO;
    }
}
