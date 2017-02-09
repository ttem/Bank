package com.ttem.model.exception.transaction.accounttransaction.check;

import com.ttem.model.exception.transaction.accounttransaction.AccountTransactionException;

public class CheckException extends AccountTransactionException {

    public CheckException() {
    }

    public CheckException(final String message) {
        super(message);
    }
}
