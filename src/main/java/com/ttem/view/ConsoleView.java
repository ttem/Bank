package com.ttem.view;

import com.ttem.model.account.Account;
import com.ttem.model.account.Client;
import com.ttem.model.bank.Bank;
import com.ttem.model.transaction.accounttransaction.AccountTransaction;
import com.ttem.model.transaction.clienttransaction.ClientTransaction;

public class ConsoleView implements DefaultView{

    @Override
    public void printBank(final Bank bank) {
        System.out.println(bank.getName());
        System.out.println("Clients list:");
        for(Client c : bank.getClientDataBase()){
            System.out.println(c.getFirstName());
        }
        System.out.println();
    }

    public void printClient(final Client client){
        System.out.println("Client: " + client.getFirstName());
        System.out.println("Client transactions");
        for (ClientTransaction clientTransaction : client.getHistoryTransaction()){
            System.out.println(clientTransaction);
        }
        System.out.println();
    }

    public void printAccount(final Account account){
        System.out.println("Account: " + account);
        System.out.println("Client transactions");
        for (AccountTransaction accountTransaction : account.getHistoryTransaction()){
            System.out.println(accountTransaction);
        }
        System.out.println();
    }
}
