package com.myproperty.propertymanagement.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice 
public class CustomExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException){
        System.out.println("Business Exception is Thrown....");
        return  new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
