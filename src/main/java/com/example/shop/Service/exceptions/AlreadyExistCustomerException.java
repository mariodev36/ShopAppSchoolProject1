package com.example.shop.Service.exceptions;

public class AlreadyExistCustomerException extends RuntimeException {
    public AlreadyExistCustomerException(String message) {
        super(message);
    }
}
