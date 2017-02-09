package com.ttem.model.exception.account;

public class AccountDuplicateException extends AccountException{

    public AccountDuplicateException() {
    }

    public AccountDuplicateException(final String message) {
        super(message);
    }
}
