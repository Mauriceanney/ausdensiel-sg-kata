package com.audensiel.kata.sg.exceptions;

import com.audensiel.kata.sg.exceptions.main.ApplicationbaseException;

/**
 * @author Maurice Aney
 * @date 16/05/2022 00:53
 */
public class OverdrawnBalanceException extends ApplicationbaseException {
    public OverdrawnBalanceException(){super("Account Overdrawn");}
}
