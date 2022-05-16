package com.audensiel.kata.exceptions;

import com.audensiel.kata.exceptions.main.ApplicationbaseException;

/**
 * @author Maurice Aney
 */
public class InsufficientFundException extends ApplicationbaseException {
    public InsufficientFundException(){super("Insufficient funds");}
}
