package com.example.MeetSync.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateException(DuplicateEventException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        response.put("Message", "Please, insert a valid hash Id for your event and try again!.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
