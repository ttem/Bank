package com.ttem.model.data.datavalidator;

import com.ttem.model.data.DataValidator;
import com.ttem.model.exception.data.AmountException;
import com.ttem.model.exception.data.DataException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IsCorrectAmount {

    private static double correctAmount;
    private static double incorrectAmount;

    @BeforeClass
    public static void setUp() throws Exception {
        correctAmount = 3.2;
        incorrectAmount = -2.5;
    }

    @Test
    public void whenInputCorrectAmount() throws AmountException {
        Assert.assertTrue(DataValidator.isCorrectAmount(correctAmount));
    }

    @Test(expected = AmountException.class)
    public void whenInputIncorrectAmount() throws AmountException {
        DataValidator.isCorrectAmount(incorrectAmount);
    }
}
