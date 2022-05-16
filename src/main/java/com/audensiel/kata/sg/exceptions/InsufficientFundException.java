package com.audensiel.kata.sg.exceptions;

import com.audensiel.kata.sg.exceptions.main.ApplicationbaseException;

/**
 * @author Maurice Aney
 */
public class InsufficientFundException extends ApplicationbaseException {
    public InsufficientFundException(){super("Insufficient funds");}
}
