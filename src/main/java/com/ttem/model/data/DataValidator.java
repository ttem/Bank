package com.ttem.model.data;


import com.ttem.model.exception.account.AccountNumberException;
import com.ttem.model.exception.data.AmountException;
import com.ttem.model.exception.data.SwiftException;

public class DataValidator {

    public static boolean isCorrectAmount(final double amount) throws AmountException{
        if (amount < 0){
            throw new AmountException();
        }
        return true;
    }

    public static boolean isCorrectSwift(final byte[] swift) throws SwiftException{
        if (swift.length != 15){
            throw new SwiftException();
        }
        return true;
    }

    public static boolean isCorrectAccountNumber(final byte[] number) throws AccountNumberException{
        if (number.length != 15){
            throw new AccountNumberException();
        }
        return true;
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }
}
