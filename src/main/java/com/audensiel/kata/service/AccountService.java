package com.audensiel.kata.service;

import com.audensiel.kata.domain.account.Account;
import com.audensiel.kata.exceptions.InsufficientFundException;
import com.audensiel.kata.exceptions.OverdrawnBalanceException;

import java.math.BigDecimal;

/**
 * @author Maurice Aney
 */
public interface  AccountService {
    /**
     * Make a Deposits to account.
     *
     * @param account account
     * @param depositAmount deposit operation amount
     *
     * @return operation account
     * @throws OverdrawnBalanceException if deposit amount  is negative
     */
    Account deposit(Account account, BigDecimal depositAmount) throws OverdrawnBalanceException;

    /**
     * Withdraws from account.
     *
     * @param account the account for which the operation is requested
     * @param amount the amount of money to withdraw
     *
     * @return the account of the current operation
     * @throws OverdrawnBalanceException    if the amount to withdraw is negative
     * @throws InsufficientFundException if the account doesn't have enough funds for the operation
     */
    Account withdraw(Account account, BigDecimal amount) throws OverdrawnBalanceException, InsufficientFundException;
}
