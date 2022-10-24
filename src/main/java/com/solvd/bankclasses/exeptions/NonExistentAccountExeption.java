package com.solvd.bankclasses.exeptions;

public class NonExistentAccountExeption extends Exception {
    public NonExistentAccountExeption(String message) {
        super(message);
    }
}