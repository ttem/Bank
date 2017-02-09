package com.ttem.model.exception.account.client;

public class ClientDuplicateException extends ClientException{

    public ClientDuplicateException() {
    }

    public ClientDuplicateException(final String message) {
        super(message);
    }
}
