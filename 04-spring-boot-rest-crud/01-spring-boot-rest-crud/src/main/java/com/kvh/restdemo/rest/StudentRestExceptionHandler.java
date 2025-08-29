package com.kvh.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
        
    // Adding Exception Handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create StudentErrorResponse.
        StudentErrorResponse error = new StudentErrorResponse(0, null, 0);
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        // return ResponseEntity.
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
    }

    // Catch all Generic Exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        // create StudentErrorResponse.
        StudentErrorResponse error = new StudentErrorResponse(0, null, 0);
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        // return ResponseEntity.
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
    }
    
}
