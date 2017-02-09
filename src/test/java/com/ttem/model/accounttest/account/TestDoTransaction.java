package com.ttem.model.accounttest.account;

import com.ttem.model.account.Account;
import com.ttem.model.exception.account.AccountException;
import com.ttem.model.exception.account.AccountNumberException;
import com.ttem.model.exception.transaction.TransactionException;
import com.ttem.model.transaction.accounttransaction.Check;
import com.ttem.model.transaction.accounttransaction.Deposit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Check correctCheck;
    private static Deposit correctDeposit;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctCheck = new Check(2.3, correctAccount, "correct check");
        correctDeposit = new Deposit(2.3, correctAccount, "correct deposi");
    }

    @Test
    public void correctAccountWhenInputCorrectCheck() throws AccountException, TransactionException {
        Assert.assertTrue(correctAccount.doTransaction(correctCheck));
    }

    @Test
    public void correctAccountWhenInputCorrectDeposit() throws AccountException, TransactionException {
        Assert.assertTrue(correctAccount.doTransaction(correctDeposit));
    }

    @Test(expected = AccountNumberException.class)
    public void incorrectAccountWhenInputCorrectCheck() throws AccountException, TransactionException {
        incorrectAccountNumber.doTransaction(correctCheck);
    }

    @Test(expected = AccountNumberException.class)
    public void incorrectAccountWhenInputCorrectDeposit() throws AccountException, TransactionException {
        incorrectAccountNumber.doTransaction(correctDeposit);
    }
}
