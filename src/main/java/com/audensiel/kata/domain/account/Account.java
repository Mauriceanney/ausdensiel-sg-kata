package com.audensiel.kata.domain.account;

import com.audensiel.kata.domain.operation.Operation;
import com.audensiel.kata.domain.operation.OperationsTypes;

import com.audensiel.kata.exceptions.InsufficientFundException;
import com.audensiel.kata.exceptions.OverdrawnBalanceException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * @author Maurice Aney
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Account {
    private final Long accountId;
    private BigDecimal balance;
    private List<Operation> operations;

    public Account(AccountBuilder accountBuilder) {
        this.accountId = requireNonNull(accountBuilder.accountId, "accountId is required");
        this.balance = requireNonNull(accountBuilder.balance, "balance must have a value");
        this.operations = accountBuilder.operations;
    }

    /**
     * Make a deposit and log com.audensiel.kata.domain.operation.
     *
     * @param amount the amount to be deposited
     * @return current account
     * @throws OverdrawnBalanceException if the amount to withdraw is negative
     */
    public Account deposit(BigDecimal amount) throws OverdrawnBalanceException {
        AccountUtils.checkTransactionAmountNegativity(amount);
        balance = balance.add(amount);
        AccountUtils.addOperation(OperationsTypes.DEPOSIT, amount, balance, this.operations);
        return this;
    }

    /**
     * Withdraws funds from account if it has enough funds, and the supplied amount is positive.
     * Saves com.audensiel.kata.domain.operation in the account operations.
     *
     * @param amount the amount of money to withdraw
     * @return the current account
     * @throws OverdrawnBalanceException    if the amount to withdraw is negative
     * @throws InsufficientFundException if the account doesn't have enough funds for operation
     */
    public Account withdraw(BigDecimal amount) throws OverdrawnBalanceException, InsufficientFundException {
        AccountUtils.checkTransactionAmountNegativity(amount);
        AccountUtils.checkFund(amount, balance);
        balance = balance.subtract(amount);
        AccountUtils.addOperation(OperationsTypes.WITHDRAW, amount, balance, this.operations);

        return this;
    }


    private static class AccountUtils {

        /**
         * Check if current transaction amount is positive or not.
         *
         * @param transactionAmount transaction amount to be checked
         * @throws InsufficientFundException if account have insufficient fund
         */
        private static void checkFund(BigDecimal transactionAmount, BigDecimal balance) {
            if (balance.compareTo(transactionAmount) < 0) throw new InsufficientFundException();
        }

        /**
         * Check if current transaction amount is negative or not.
         *
         * @param transactionAmount transaction amount to be checked
         * @throws OverdrawnBalanceException if withdraw  transactionAmount is negative
         */
        private static void checkTransactionAmountNegativity(BigDecimal transactionAmount) {
            if (transactionAmount.compareTo(BigDecimal.ZERO) <= 0) throw new OverdrawnBalanceException();
        }

        /**
         * Adds the requested com.audensiel.kata.domain.operation with the amount to the operations history.
         *
         * @param transactionAmount the amount of money to validate
         * @param balance account balance
         * @param operationsTypes type of com.audensiel.kata.domain.operation to be added
         * @param operations account operations list
         */
        private static void addOperation(OperationsTypes operationsTypes,BigDecimal transactionAmount, BigDecimal balance, List<Operation> operations) {
            Operation operation = Operation.builder()
                    .operationsTypes(operationsTypes)
                    .amount(transactionAmount)
                    .balance(balance)
                    .date(LocalDateTime.now())
                    .build();
            operations.add(operation);
        }

    }
}


