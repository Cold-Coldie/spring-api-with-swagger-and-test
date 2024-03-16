package com.coldie.roommateswithswaggerandtest.exception;

public class RoommateNotFoundException extends RuntimeException {
    public RoommateNotFoundException(String message) {
        super(message);
    }
}
