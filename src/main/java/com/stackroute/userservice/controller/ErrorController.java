package com.stackroute.userservice.controller;

import com.stackroute.userservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.userservice.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//throws exception for track already exists and track not found exception
@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(value= TrackAlreadyExistsException.class)
    public ResponseEntity<Object> exception1()
    {
       return new ResponseEntity<>("Track already exists", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= TrackNotFoundException.class)
    public ResponseEntity<Object> exception2()
    {
        return new ResponseEntity<>("Track not found", HttpStatus.NOT_FOUND);
    }

}
