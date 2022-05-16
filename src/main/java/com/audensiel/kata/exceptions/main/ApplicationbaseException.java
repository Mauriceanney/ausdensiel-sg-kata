package com.audensiel.kata.exceptions.main;

/**
 * @author Maurice Aney
 */
public class ApplicationbaseException extends RuntimeException{
    private final String message;

    protected ApplicationbaseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
