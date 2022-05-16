package com.audensiel.kata.exceptions;

import com.audensiel.kata.exceptions.main.ApplicationbaseException;

/**
 * @author Maurice Aney
 */
public class OverdrawnBalanceException extends ApplicationbaseException {
    public OverdrawnBalanceException(){super("Account Overdrawn");}
}
