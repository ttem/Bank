package com.ttem.model.testprogram;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import com.ttem.model.bank.Bank;
import com.ttem.model.exception.account.AccountException;
import com.ttem.model.exception.account.client.ClientException;
import com.ttem.model.exception.transaction.TransactionException;
import com.ttem.model.exception.transaction.clienttransaction.ClientTransactionException;
import com.ttem.model.transaction.accounttransaction.Check;
import com.ttem.model.transaction.accounttransaction.Deposit;
import com.ttem.model.transaction.clienttransaction.WireOut;
import com.ttem.view.ConsoleView;
import org.apache.log4j.Logger;

public class Program {

    private static Logger log = Logger.getLogger(Program.class);

    private static Bank bank;
    private static Client client;
    private static Account account;
    private static Account forTestTransactions;
    private static ConsoleView consoleView;

    private static void setUp() {
        bank = new Bank("ING");

        client = new Client("Bob", "Ross");

        account = new Account(new byte[15], "private");
        forTestTransactions = new Account(new byte[15], "public");

        consoleView = new ConsoleView();
    }

    private static void addNewClient() {
        try {
            bank.addNewClient(client);
        } catch (ClientException e) {
            log.error(e.getMessage());
        }
    }

    private static void addNewAccount() {
        try {
            bank.getClientDataBase().get(0).addNewAccount(account);
        } catch (AccountException e) {
            log.error(e.getMessage());
        }
    }

    private static void clientDoTransaction() {
        WireOut wireOut = new WireOut.Builder()
                .setAmount(23.3)
                .setToAccount(forTestTransactions)
                .setSwift(new byte[15])
                .setCountry("USA")
                .setDescription("from Poland")
                .build();

        try {
            client.doTransaction(wireOut);
        } catch (ClientTransactionException e) {
            log.error(e.getMessage());
        }
    }

    private static void accountDoTransaction() {
        Check check = new Check(2.3, forTestTransactions, "correct check");
        Deposit deposit = new Deposit(2.3, forTestTransactions, "correct deposit");

        try {
            client.getAccountList().get(0).doTransaction(check);
        } catch (TransactionException e) {
            log.error(e.getMessage());
        } catch (AccountException e) {
            log.error(e.getMessage());
        }

        try {
            client.getAccountList().get(0).doTransaction(deposit);
        } catch (TransactionException e) {
            log.error(e.getMessage());
        } catch (AccountException e) {
            log.error(e.getMessage());
        }
    }

    private static void printResult() {
        consoleView.printBank(bank);
        consoleView.printClient(bank.getClientDataBase().get(0));
        consoleView.printAccount(bank.getClientDataBase().get(0).getAccountList().get(0));
    }

    public static void main(String[] args) {
        setUp();
        addNewClient();
        addNewAccount();
        clientDoTransaction();
        accountDoTransaction();
        printResult();
    }
}
