package com.ttem.model.transaction.accounttransaction;

import com.ttem.model.account.Account;
import com.ttem.model.exception.transaction.accounttransaction.deposit.*;

import java.util.Date;

public class Deposit extends AccountTransaction{

    private final Account fromAccount;

    public Deposit(final double amount, final Account fromAccount, final String description) {
        super(amount, description);
        this.fromAccount = fromAccount;
    }

    @Override
    public boolean doTransaction() throws DepositException {
        if(this.isValid() && executionOfTransaction()){
            return true;
        }
        return false;
    }

    public Account getFromAccount() {
        return this.fromAccount;
    }

    private boolean executionOfTransaction() {
        this.setDone(true);
        this.setDate(new Date());
        return this.isDone();
    }

    private boolean isValid() throws DepositValidException{
        return this.isNotDone() && this.amountValid() && this.accountValid();
    }

    private boolean isNotDone() throws DepositDoneException {
        if (this.isDone()){
            throw new DepositDoneException(this.toString() + " this transaction is completed");
        }
        return true;
    }

    private boolean amountValid() throws DepositAmountException {
        if (this.getAmount() < 0){
            throw new DepositAmountException(this.getAmount() + " invalid amount");
        }
        return true;
    }

    private boolean accountValid() throws DepositAccountException {
        if (this.getFromAccount() == null){
            return false;
        }
        if (getFromAccount().getNumber().length != 15){
            throw new DepositAccountException(getFromAccount().toString() + " this account has invalid number");
        }
        return true;
    }
}
