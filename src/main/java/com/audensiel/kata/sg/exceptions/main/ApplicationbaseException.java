package com.audensiel.kata.sg.exceptions.main;

/**
 * @author Maurice Aney
 * @date 15/05/2022 23:57
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
