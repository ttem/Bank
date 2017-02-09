package com.ttem.model.exception.transaction.accounttransaction.check;

public class CheckAmountException extends CheckValidException{

    public CheckAmountException() {
    }

    public CheckAmountException(final String message) {
        super(message);
    }
}
