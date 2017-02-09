package com.ttem.model.exception.transaction.clienttransaction.wireout;

import com.ttem.model.exception.transaction.clienttransaction.ClientTransactionException;

public class WireOutException extends ClientTransactionException{

    public WireOutException() {
    }

    public WireOutException(final String message) {
        super(message);
    }
}
