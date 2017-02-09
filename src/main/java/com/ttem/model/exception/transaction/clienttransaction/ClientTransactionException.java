package com.ttem.model.exception.transaction.clienttransaction;

import com.ttem.model.exception.transaction.TransactionException;

public class ClientTransactionException extends TransactionException{

    public ClientTransactionException() {
    }

    public ClientTransactionException(final String message) {
        super(message);
    }
}
