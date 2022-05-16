package com.audensiel.kata.sg.exceptions;

import com.audensiel.kata.sg.exceptions.main.ApplicationbaseException;

/**
 * @author Maurice Aney
 */
public class OverdrawnBalanceException extends ApplicationbaseException {
    public OverdrawnBalanceException(){super("Account Overdrawn");}
}
