package com.audensiel.kata.sg.exceptions;

import com.audensiel.kata.sg.exceptions.main.ApplicationbaseException;

/**
 * @author Maurice Aney
 * @date 16/05/2022 00:04
 */
public class InsufficientFundException extends ApplicationbaseException {
    public InsufficientFundException(){super("Insufficient funds");}
}
