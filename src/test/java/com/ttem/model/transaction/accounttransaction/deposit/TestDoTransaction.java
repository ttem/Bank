package com.ttem.model.transaction.accounttransaction.deposit;

import com.ttem.model.account.Account;
import com.ttem.model.exception.transaction.TransactionException;
import com.ttem.model.exception.transaction.accounttransaction.deposit.valid.DepositAccountException;
import com.ttem.model.exception.transaction.accounttransaction.deposit.valid.DepositAmountException;
import com.ttem.model.transaction.accounttransaction.Deposit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Deposit correctDeposit;
    private static Deposit incorrectDepositAmount;
    private static Deposit incorrectDepositAccountNumber;
    private static Deposit incorrectDepositAccountNull;

    @BeforeClass
    public static void setUp() throws Exception {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctDeposit = new Deposit(2.3, correctAccount, "correct deposit");
        incorrectDepositAmount = new Deposit(-3.4, correctAccount, "incorrect amount");
        incorrectDepositAccountNumber = new Deposit(3.4, incorrectAccountNumber, "incorrect account number");
        incorrectDepositAccountNull = new Deposit(3.4, null, "incorrect account null");
    }

    @Test
    public void whenInputCorrectDeposit() throws TransactionException {
        Assert.assertTrue(correctDeposit.doTransaction());
    }

    @Test(expected = DepositAmountException.class)
    public void whenInputIncorrectDepositAmount() throws TransactionException {
        incorrectDepositAmount.doTransaction();
    }

    @Test(expected = DepositAccountException.class)
    public void whenInputIncorrectDepositAccountNumber() throws TransactionException {
        incorrectDepositAccountNumber.doTransaction();
    }

    @Test
    public void whenInputIncorrectDepositAccountNull() throws TransactionException {
        Assert.assertFalse(incorrectDepositAccountNull.doTransaction());
    }
}
