package com.ttem.model.account;

import com.ttem.model.exception.account.AccountException;
import com.ttem.model.exception.transaction.clienttransaction.ClientTransactionException;
import com.ttem.model.transaction.clienttransaction.ClientTransaction;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person{

    private final List<ClientTransaction> historyTransaction;
    private final List<Account> accountList;

    public Client(final String firstName, final String lastName) {
        super(firstName, lastName);
        this.historyTransaction = getHistoryTransactionFromDataBase();
        this.accountList = getAccountListFromDataBase();
    }

    public boolean addNewAccount(final Account newAccount) throws AccountException {
        if (newAccount != null && newAccount.isValid() && isNewAccount(newAccount)){
            return addNewAccountToDataBase(newAccount);
        }
        return false;
    }

    private boolean isNewAccount(final Account newAccount) {
        for (Account existingAccount : this.getAccountList()) {
            if (existingAccount == newAccount){
                return false;
            }
        }
        return true;
    }

    public boolean doTransaction(final ClientTransaction transaction) throws ClientTransactionException {
        if (this.isValid() && transaction != null && transaction.doTransaction()){
            addTransactionToDataBase(transaction);
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return true;
    }

    public List<ClientTransaction> getHistoryTransaction() {
        return this.historyTransaction;
    }

    public List<Account> getAccountList() {
        return this.accountList;
    }

    private List<ClientTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }

    private List<Account> getAccountListFromDataBase() {
        return new ArrayList<>();
    }

    private boolean addNewAccountToDataBase(final Account newAccount) {
        return this.accountList.add(newAccount);
    }

    private boolean addTransactionToDataBase(final ClientTransaction transaction) {
        return this.historyTransaction.add(transaction);
    }
}
