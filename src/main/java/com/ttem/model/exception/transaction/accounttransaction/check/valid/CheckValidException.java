package com.ttem.model.exception.transaction.accounttransaction.check.valid;

import com.ttem.model.exception.transaction.accounttransaction.check.CheckException;

public class CheckValidException extends CheckException {

    public CheckValidException() {
    }

    public CheckValidException(final String message) {
        super(message);
    }
}
