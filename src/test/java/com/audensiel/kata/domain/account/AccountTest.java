package com.audensiel.kata.domain.account;

import com.audensiel.kata.exceptions.InsufficientFundException;
import com.audensiel.kata.exceptions.OverdrawnBalanceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Maurice Aney
 */
public class AccountTest {
    private Account account;

    @Before
    public void init() {
        account = Account.builder()
                .accountId(1L)
                .balance(BigDecimal.ZERO)
                .operations(new ArrayList<>()).build();
    }

    @Test
    public void should_have_deposit_amount_as_balance() throws OverdrawnBalanceException {
        BigDecimal currentAccountBalance = account.getBalance();

        account.deposit(BigDecimal.valueOf(5000));

        Assert.assertEquals(account.getBalance().subtract(currentAccountBalance), new BigDecimal(5000));
    }

    @Test
    public void should_have_exact_balance_after_withdraw() throws OverdrawnBalanceException {
        account.deposit(new BigDecimal(5000));

        account.withdraw(BigDecimal.valueOf(2000));

        Assert.assertEquals(account.getBalance(), new BigDecimal(3000));
    }

    @Test(expected = OverdrawnBalanceException.class)
    public void should_throw_OverdrawnBalanceException_if_amount_to_deposit_is_negative() throws OverdrawnBalanceException {
        account.deposit(BigDecimal.valueOf(-300));
    }

    @Test(expected = OverdrawnBalanceException.class)
    public void should_throw_OverdrawnBalanceException_if_amount_to_withdraw_is_negative() throws OverdrawnBalanceException {
        account.withdraw(BigDecimal.valueOf(-100));
    }

    @Test(expected = InsufficientFundException.class)
    public void should_throw_InsufficientFundException_if_insufficient_fund_on_withdraw() throws InsufficientFundException, OverdrawnBalanceException {
        account.withdraw(BigDecimal.valueOf(100));
    }

}
