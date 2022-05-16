package com.audensiel.kata.domain.operation;

import com.audensiel.kata.domain.account.Account;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Maurice Aney
 * @date 16/05/2022 03:49
 */
public class OperationTest {
    private Account account;

    @Before
    public void init() {
        account = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.ZERO)
                .operations(new ArrayList<Operation>()).build();
    }

    @Test
    public void should_return_account_operations_history() {
        Operation operation1 = account.deposit(BigDecimal.valueOf(5000)).getOperations().get(0);
        Operation operation2 = account.withdraw(BigDecimal.valueOf(1000)).getOperations().get(1);

        List<Operation> accountOperations = account.getOperations();
        List<Operation> operationList = new ArrayList<>();
        operationList.add(operation1);
        operationList.add(operation2);

        assertThat(operationList).isEqualTo(accountOperations);
        assertThat(operation1.getBalance()).isEqualTo(accountOperations.get(0).getBalance());
        assertThat(operation1.getAmount()).isEqualTo(accountOperations.get(0).getAmount());
        assertThat(operation1.getOperationsTypes()).isEqualTo(accountOperations.get(0).getOperationsTypes());
        assertThat(operation1.getDate()).isEqualTo(accountOperations.get(0).getDate());
        assertThat(operation1).isEqualTo(accountOperations.get(0));
        assertThat(operation2).isEqualTo(accountOperations.get(1));
        assertNotEquals(operation1, operation2);
        assertNotEquals(account.getOperations().get(1), operation1);
    }
}
