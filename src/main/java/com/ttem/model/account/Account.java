package com.ttem.model.account;

import com.ttem.model.exception.account.AccountException;
import com.ttem.model.exception.account.AccountNumberException;
import com.ttem.model.exception.transaction.TransactionException;
import com.ttem.model.transaction.accounttransaction.AccountTransaction;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final byte[] number;
    private final String description;
    private final List<AccountTransaction> historyTransaction;

    public Account(final byte[] number, final String description) {
        this.number = number;
        this.description = description;
        this.historyTransaction = getHistoryTransactionFromDataBase();
    }

    public boolean doTransaction(final AccountTransaction transaction) throws TransactionException, AccountException{
        if (this.isValid() && transaction != null && transaction.doTransaction()){
            addTransactionToDataBase(transaction);
            return true;
        }
        return false;
    }

    public boolean isValid() throws AccountNumberException{
        if (this.number.length != 15){
            throw  new AccountNumberException(this.number + " invalid account number");
        }
        return true;
    }

    public byte[] getNumber() {
        return this.number;
    }

    public String getDescription() {
        return this.description;
    }

    public List<AccountTransaction> getHistoryTransaction() {
        return this.historyTransaction;
    }

    private List<AccountTransaction> getHistoryTransactionFromDataBase() {
        return new ArrayList<>();
    }

    private boolean addTransactionToDataBase(final AccountTransaction transaction) {
        return this.historyTransaction.add(transaction);
    }
}
