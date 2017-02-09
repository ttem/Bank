package com.ttem.model.exception.transaction.accounttransaction;

import com.ttem.model.exception.transaction.TransactionException;

public class AccountTransactionException extends TransactionException{

    public AccountTransactionException() {
    }

    public AccountTransactionException(final String message) {
        super(message);
    }
}
