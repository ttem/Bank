package com.ttem.model.exception.transaction.accounttransaction.deposit;

import com.ttem.model.exception.transaction.accounttransaction.AccountTransactionException;

public class DepositException extends AccountTransactionException {

    public DepositException() {
    }

    public DepositException(final String message) {
        super(message);
    }
}
