package com.ttem.model.exception.account.client;

import com.ttem.model.exception.bank.BankException;

public class ClientException extends BankException{

    public ClientException() {
    }

    public ClientException(final String message) {
        super(message);
    }
}
