package com.neutar.cloudauth.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CloudAuthControllerAdvice {

    @ExceptionHandler(value = { ConstraintViolationException.class})
    protected ResponseEntity<String> handleConflict(ConstraintViolationException ex, WebRequest request) {
        return new ResponseEntity<String>( "Constraint Violation!!", HttpStatus.CONFLICT);
    }
}
