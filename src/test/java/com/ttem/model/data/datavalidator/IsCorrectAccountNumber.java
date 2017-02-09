package com.ttem.model.data.datavalidator;

import com.ttem.model.data.DataValidator;
import com.ttem.model.exception.account.AccountNumberException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsCorrectAccountNumber {

    private static byte[] correctNumber;
    private static byte[] incorrectNumber;

    @BeforeClass
    public static void setUp() throws Exception {
        correctNumber = new byte[15];
        incorrectNumber = new byte[11];
    }

    @Test
    public void whenInputCorrectNumber() throws AccountNumberException {
        Assert.assertTrue(DataValidator.isCorrectAccountNumber(correctNumber));
    }

    @Test(expected = AccountNumberException.class)
    public void whenInputIncorrectNumber() throws AccountNumberException {
        DataValidator.isCorrectAccountNumber(incorrectNumber);
    }
}
