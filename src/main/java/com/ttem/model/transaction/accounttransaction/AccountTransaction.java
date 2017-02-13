package com.ttem.model.transaction.accounttransaction;

import com.ttem.model.exception.transaction.accounttransaction.AccountTransactionException;
import com.ttem.model.transaction.Transaction;

public abstract class AccountTransaction extends Transaction{

    public AccountTransaction(final double amount, final String description) {
        super(amount, description);
    }

    @Override
    public abstract boolean doTransaction() throws AccountTransactionException;
}
