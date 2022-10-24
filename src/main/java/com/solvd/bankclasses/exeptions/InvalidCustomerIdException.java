package com.solvd.bankclasses.exeptions;

public class InvalidCustomerIdException extends Exception {
    public InvalidCustomerIdException(String message) {
        super(message);
    }
}