package com.ttem.model.exception.account;

import com.ttem.model.exception.bank.BankException;

public class AccountException extends BankException{

    public AccountException() {
    }

    public AccountException(final String message) {
        super(message);
    }
}
