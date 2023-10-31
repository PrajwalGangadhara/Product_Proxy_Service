package com.project.productservice_proxy.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class ExceptionAdvices {

    //@ExceptionHandler
    public ResponseEntity<String> ExceptionHandler(Exception e)
    {
        return new ResponseEntity<>("printing this using exception handler in controller advice", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
