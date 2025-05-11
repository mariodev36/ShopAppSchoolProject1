package com.example.shop.Service.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message) {
        super(message);
    }
}
