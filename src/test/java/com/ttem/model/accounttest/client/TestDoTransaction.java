package com.ttem.model.accounttest.client;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import com.ttem.model.exception.transaction.clienttransaction.ClientTransactionException;
import com.ttem.model.exception.transaction.clienttransaction.wireout.WireOutAccountException;
import com.ttem.model.exception.transaction.clienttransaction.wireout.WireOutSwiftException;
import com.ttem.model.transaction.clienttransaction.WireOut;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDoTransaction {

    private static Account correctAccount;
    private static Account incorrectAccountNumber;

    private static Client correctClient;

    private static WireOut correctWireOut;
    private static WireOut incorrectWireOutSwift;
    private static WireOut incorrectWireOutAccountNumber;
    private static WireOut incorrectWireOutAccountNull;

    @BeforeClass
    public static void setUp() {
        correctAccount = new Account(new byte[15], "correct");
        incorrectAccountNumber = new Account(new byte[12], "incorrect number");

        correctClient = new Client("Bob", "Ross");

        correctWireOut = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(correctAccount)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutSwift = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(correctAccount)
                .setSwift(new byte[19])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutAccountNumber = new WireOut.Builder()
                .setAmount(3.2)
                .setToAccount(incorrectAccountNumber)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        incorrectWireOutAccountNull = new WireOut.Builder()
                .setAmount(3.2)
                .setToAccount(null)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();
    }

    @Test
    public void whenInputCorrectWireOut() throws ClientTransactionException {
        Assert.assertTrue(correctClient.doTransaction(correctWireOut));
    }

    @Test(expected = WireOutSwiftException.class)
    public void whenInputIncorrectWireOut() throws ClientTransactionException {
        correctClient.doTransaction(incorrectWireOutSwift);
    }

    @Test(expected = WireOutAccountException.class)
    public void whenInputIncorrectWireOutAccountNumber() throws ClientTransactionException {
        correctClient.doTransaction(incorrectWireOutAccountNumber);
    }

    @Test
    public void whenInputIncorrectWireOutAccountNull() throws ClientTransactionException {
        Assert.assertFalse(correctClient.doTransaction(incorrectWireOutAccountNull));
    }
}
