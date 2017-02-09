package com.ttem.model.exception.data;

import com.ttem.model.exception.BankException;

public class DataException extends BankException{

    public DataException() {
    }

    public DataException(final String message) {
        super(message);
    }
}
