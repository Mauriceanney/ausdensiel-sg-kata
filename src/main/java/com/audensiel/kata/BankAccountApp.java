package com.audensiel.kata;

import com.audensiel.kata.domain.account.Account;
import com.audensiel.kata.service.AccountService;
import com.audensiel.kata.service.AccountServiceImpl;
import com.audensiel.kata.service.OperationService;
import com.audensiel.kata.service.OperationServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankAccountApp {

    public static void main(String[] args) {
        Account account = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.ZERO)
                .operations(new ArrayList<>()).build();

        AccountService accountService = new AccountServiceImpl();
        OperationService operationService = new OperationServiceImpl();

        accountService.deposit(account, BigDecimal.valueOf(1000));
        accountService.withdraw(account, BigDecimal.valueOf(100));
        accountService.deposit(account, BigDecimal.valueOf(1230));
        accountService.withdraw(account, BigDecimal.valueOf(830));

        operationService.getAccountOperationsHistory(account).forEach(operation -> System.out.println(operation.toString()));
    }
}
