package com.example.spring_rest.exeption_handling;

public class NoSuchEmployeeExeption extends RuntimeException{
    public NoSuchEmployeeExeption(String message) {
        super(message);
    }
}
