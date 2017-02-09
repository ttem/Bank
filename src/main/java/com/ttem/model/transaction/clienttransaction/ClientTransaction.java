package com.ttem.model.transaction.clienttransaction;

import com.ttem.model.exception.transaction.clienttransaction.ClientTransactionException;
import com.ttem.model.transaction.Transaction;

public abstract class ClientTransaction extends Transaction{

    public ClientTransaction(final double amount, final String description) {
        super(amount, description);
    }

    @Override
    public abstract boolean doTransaction() throws ClientTransactionException;
}
