package com.example.shop.Controller;

import com.example.shop.Service.exceptions.AlreadyExistException;
import com.example.shop.Service.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExcepionalHandler {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<String> handlerAlreadyExistException(AlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlerNotFoundException(NotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handlerNullPointerException(NullPointerException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
