package services;

import com.audensiel.kata.domain.account.Account;
import com.audensiel.kata.domain.operation.Operation;
import com.audensiel.kata.exceptions.OverdrawnBalanceException;
import com.audensiel.kata.service.AccountService;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Maurice Aney
 */
public class AccountServiceTest {
    private Account account;

    private AccountService accountService;

    @Before
    public void init() {
        account = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.ZERO)
                .operations(new ArrayList<Operation>()).build();
    }

    @Before
    public void setup(){
        accountService = mock(AccountService.class);
    }

    @Test
    public void should_return_account_with_expected_balance_after_deposit() throws OverdrawnBalanceException {
        Account accountBeforeDeposit = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.valueOf(5000))
                .operations(new ArrayList<Operation>()).build();

        when(accountService.deposit(any(), any())).thenReturn(
                account.deposit(BigDecimal.valueOf(5000)));
        Account accountAfterDeposit = accountService.deposit(account,BigDecimal.valueOf(5000));

        assertThat(accountAfterDeposit.getBalance()).isEqualTo(accountBeforeDeposit.getBalance());
    }

    @Test
    public void should_return_account_with_expected_balance_after_withdraw() throws OverdrawnBalanceException {
        Account accountBeforeDeposit = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.valueOf(1000))
                .operations(new ArrayList<Operation>()).build();
        account.deposit(BigDecimal.valueOf(2000));

        when(accountService.withdraw(any(), any())).thenReturn(
                account.withdraw(BigDecimal.valueOf(1000)));
        Account accountAfterDeposit = accountService.withdraw(account,BigDecimal.valueOf(1000));

        assertThat(accountAfterDeposit.getBalance()).isEqualTo(accountBeforeDeposit.getBalance());
    }
}
