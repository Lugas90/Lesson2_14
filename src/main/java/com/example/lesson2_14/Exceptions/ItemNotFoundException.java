package com.example.lesson2_14.Exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException (String message) {
        super(message);
    }
}
