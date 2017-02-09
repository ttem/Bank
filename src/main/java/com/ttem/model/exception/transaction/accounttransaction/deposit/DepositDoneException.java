package com.ttem.model.exception.transaction.accounttransaction.deposit;

public class DepositDoneException extends DepositValidException {

    public DepositDoneException() {
    }

    public DepositDoneException(final String message) {
        super(message);
    }
}
