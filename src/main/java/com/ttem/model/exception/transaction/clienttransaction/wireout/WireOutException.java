package com.ttem.model.exception.transaction.clienttransaction.wireout;

import com.ttem.model.exception.transaction.accounttransaction.AccountTransactionException;

public class WireOutException extends AccountTransactionException {

    public WireOutException() {
    }

    public WireOutException(final String message) {
        super(message);
    }
}
