package com.ravan.starter.exception;

public class InvalidSmsTypeException extends RuntimeException {
    private final String type;

    public InvalidSmsTypeException(String message, String type) {
        super(message);
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
