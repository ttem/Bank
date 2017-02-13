package com.ttem.model.exception.transaction.accounttransaction.deposit.valid;

import com.ttem.model.exception.transaction.accounttransaction.deposit.DepositException;

public class DepositValidException extends DepositException {

    public DepositValidException() {
    }

    public DepositValidException(final String message) {
        super(message);
    }
}
