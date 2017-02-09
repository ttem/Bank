package com.ttem.model.data.datavalidator;

import com.ttem.model.data.DataValidator.DataValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsCorrectAmount {
    private static double correctAmount;

    @Before
    public void setUp() throws Exception {
        correctAmount = 3.2;
    }

    @Test
    public void WhenInputCorrectAmount() throws Exception {
        Assert.assertTrue(DataValidator.isCorrectAmount(correctAmount));
    }
}
