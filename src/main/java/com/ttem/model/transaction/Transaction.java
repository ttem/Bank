package com.ttem.model.transaction;

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

    public abstract boolean doTransaction();

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

    public void setDate(final Date date) {
        if (this.getDate() == null) {
            this.date = date;
        }
    }

    public void setDone(final boolean done) {
        if (!this.isDone()) {
            this.done = done;
        }
    }
}
