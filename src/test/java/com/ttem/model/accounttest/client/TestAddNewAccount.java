package com.ttem.model.accounttest.client;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import com.ttem.model.exception.account.AccountException;
import com.ttem.model.exception.account.AccountNumberException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAddNewAccount {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;
    private static Account incorrectAccountNull;

    private static Client correctClient;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");
        incorrectAccountNull = null;

        correctClient = new Client("Bob", "Ross");
    }

    @Test
    public void whenInputCorrectAccount() throws AccountException {
        Account expectedAccount = correctAccount;

        Assert.assertTrue(correctClient.addNewAccount(expectedAccount));

        Account actualAccount = correctClient.getAccountList().get(0);
        Assert.assertSame(expectedAccount, actualAccount);
    }

    @Test(expected = AccountNumberException.class)
    public void whenInputIncorrectAccountNumber() throws AccountException {
        correctClient.addNewAccount(incorrectAccountNumber);
    }

    @Test
    public void whenInputIncorrectAccountNull() throws AccountException {
       Assert.assertFalse(correctClient.addNewAccount(incorrectAccountNull));
    }
}
