package com.ttem.model.testprogram;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import com.ttem.model.bank.Bank;
import com.ttem.model.exception.account.AccountException;
import com.ttem.model.exception.account.AccountNumberException;
import com.ttem.model.exception.account.client.ClientException;
import com.ttem.model.exception.transaction.clienttransaction.ClientTransactionException;
import com.ttem.model.transaction.accounttransaction.Check;
import com.ttem.model.transaction.accounttransaction.Deposit;
import com.ttem.model.transaction.clienttransaction.WireOut;
import com.ttem.view.ConsoleView;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProgram {
    
    private static Bank bank;
    private static Client client;
    private static Account account;
    private static Account forTestTransactions;
    private static ConsoleView consoleView;

    @BeforeClass
    public static void initializationBankAccountClient() throws AccountNumberException {
        forTestTransactions = new Account(new byte[15], "public");
        bank = new Bank("ING");

        client = new Client("Bob", "Ross");
        Assert.assertTrue(client.isValid());

        account = new Account(new byte[15], "private");
        Assert.assertTrue(account.isValid());

        consoleView = new ConsoleView();
    }

    @BeforeClass
    public static void addNewClientAndAccount() throws ClientException, AccountException {
        bank.addNewClient(client);
        Assert.assertSame(client, bank.getClientDataBase().get(0));

        bank.getClientDataBase().get(0).addNewAccount(account);
        Assert.assertSame(account, client.getAccountList().get(0));

    }

    @Test
    public void clientDoTransaction() throws ClientTransactionException {
        WireOut wireOut = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(forTestTransactions)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        client.doTransaction(wireOut);
        Assert.assertSame(wireOut, client.getHistoryTransaction().get(0));
    }

    @Test
    public void accountDoTransaction() throws Exception {
        Check check = new Check(2.3, forTestTransactions, "correct check");
        Deposit deposit = new Deposit(2.3, forTestTransactions, "correct deposit");

        client.getAccountList().get(0).doTransaction(check);
        client.getAccountList().get(0).doTransaction(deposit);

        Assert.assertSame(check, client.getAccountList().get(0).getHistoryTransaction().get(0));
        Assert.assertSame(deposit, client.getAccountList().get(0).getHistoryTransaction().get(1));
    }

    @AfterClass
    public static void printResult(){
        consoleView.printBank(bank);
        consoleView.printClient(bank.getClientDataBase().get(0));
        consoleView.printAccount(bank.getClientDataBase().get(0).getAccountList().get(0));
    }
}
