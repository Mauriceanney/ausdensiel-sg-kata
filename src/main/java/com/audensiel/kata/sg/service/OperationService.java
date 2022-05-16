package com.audensiel.kata.sg.service;

import com.audensiel.kata.sg.domain.account.Account;
import com.audensiel.kata.sg.domain.operation.Operation;

import java.util.List;

/**
 * @author Maurice Aney
 */
public interface OperationService {
    /**
     * Retrieve account operations histoty.
     *
     * @param account operations account
     * @return account operations history as list
     */
    List<Operation> getAccountOperationsHistory(Account account);
}
