package com.ttem.model.transaction.accounttransaction.check;

import com.ttem.model.account.Account;
import com.ttem.model.exception.transaction.TransactionException;
import com.ttem.model.exception.transaction.accounttransaction.check.valid.CheckAccountException;
import com.ttem.model.exception.transaction.accounttransaction.check.valid.CheckAmountException;
import com.ttem.model.exception.transaction.accounttransaction.check.valid.CheckDoneException;
import com.ttem.model.transaction.accounttransaction.Check;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Check correctCheck;
    private static Check incorrectCheckDone;
    private static Check incorrectCheckAmount;
    private static Check incorrectCheckAccountNumber;
    private static Check incorrectCheckAccountNull;

    @BeforeClass
    public static void setUp() throws Exception {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctCheck = new Check(2.3, correctAccount, "correct check");
        incorrectCheckAmount = new Check(-3.4, correctAccount, "incorrect amount");
        incorrectCheckAccountNumber = new Check(3.4, incorrectAccountNumber, "incorrect account number");
        incorrectCheckAccountNull = new Check(3.4, null, "incorrect account null");
    }

    @Test
    public void whenInputCorrectCheck() throws TransactionException {
        Assert.assertTrue(correctCheck.doTransaction());
    }

    @Test(expected = CheckDoneException.class)
    public void whenInputIncorrectCheckDone() throws TransactionException {
        incorrectCheckDone = correctCheck;
        incorrectCheckDone.doTransaction();

        incorrectCheckDone.doTransaction();
    }

    @Test(expected = CheckAmountException.class)
    public void whenInputIncorrectCheckAmount() throws TransactionException {
        incorrectCheckAmount.doTransaction();
    }

    @Test(expected = CheckAccountException.class)
    public void whenInputIncorrectCheckAccountNumber() throws TransactionException {
        incorrectCheckAccountNumber.doTransaction();
    }

    @Test
    public void whenInputIncorrectCheckAccountNull() throws TransactionException {
        Assert.assertFalse(incorrectCheckAccountNull.doTransaction());
    }
}
