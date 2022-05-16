package services;

import com.audensiel.kata.domain.account.Account;
import com.audensiel.kata.domain.operation.Operation;
import com.audensiel.kata.exceptions.OverdrawnBalanceException;
import com.audensiel.kata.service.OperationService;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Maurice Aney
 */
public class OperationServiceTest {
    private Account account;

    private OperationService operationService;

    @Before
    public void init() {

        account = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.ZERO)
                .operations(new ArrayList<>()).build();
    }

    @Before
    public void setup() {
        operationService = mock(OperationService.class);
    }

    @Test
    public void should_return_complete_account_operations_history() throws OverdrawnBalanceException {
        Operation operation1 = account.deposit(BigDecimal.valueOf(100)).getOperations().get(0);
        Operation operation2 = account.deposit(BigDecimal.valueOf(100)).getOperations().get(1);
        Operation operation3 = account.withdraw(BigDecimal.valueOf(100)).getOperations().get(2);
        List<Operation> accountOperations = account.getOperations();

        when(operationService.getAccountOperationsHistory(any())).thenReturn(
                account.getOperations());
        List<Operation> accountOperationsAfterinitial = operationService.getAccountOperationsHistory(account);

        assertThat(accountOperationsAfterinitial).isEqualTo(accountOperations);
        assertThat(operation1).isEqualTo(accountOperations.get(0));
        assertThat(operation2).isEqualTo(accountOperations.get(1));
        assertThat(operation3).isEqualTo(accountOperations.get(2));

    }
}
