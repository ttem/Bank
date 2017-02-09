package com.ttem.model.data.DataValidator;


public class DataValidator {
    public static boolean isCorrectAmount(final double amount) throws Exception {
        if (amount < 0){
            throw new Exception();
        }
        return true;
    }
}
