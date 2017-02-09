package com.ttem.model.transaction;

import com.ttem.model.exception.transaction.TransactionException;

import java.util.Date;

public abstract class Transaction {

    private final double amount;
    private Date date;
    private final String description;
    private boolean done;

    protected Transaction(final double amount, final String description) {
        this.amount = amount;
        this.description = description;
    }

    public abstract boolean doTransaction() throws TransactionException;

    public double getAmount() {
        return this.amount;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isDone() {
        return this.done;
    }

    protected void setDate(final Date date) {
        if (this.getDate() == null) {
            this.date = date;
        }
    }

    protected void setDone(final boolean done) {
        if (!this.isDone()) {
            this.done = done;
        }
    }
}
