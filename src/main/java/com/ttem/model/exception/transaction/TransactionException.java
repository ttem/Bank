package com.ttem.model.exception.transaction;

import com.ttem.model.exception.bank.BankException;

public class TransactionException extends BankException{

    public TransactionException() {
    }

    public TransactionException(final String message) {
        super(message);
    }
}
