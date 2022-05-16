package com.audensiel.kata.service;

import com.audensiel.kata.domain.account.Account;
import com.audensiel.kata.domain.operation.Operation;

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
