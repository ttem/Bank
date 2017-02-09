package com.ttem.model.data.datavalidator;

import com.ttem.model.data.DataValidator;
import com.ttem.model.exception.data.SwiftException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsCorrectSwift {

    private static byte[] correctSwift;
    private static byte[] incorrectSwift;

    @Before
    public void setUp() throws Exception {
        correctSwift = new byte[15];
        incorrectSwift = new byte[13];
    }

    @Test
    public void whenInputCorrectSwift() throws SwiftException {
        Assert.assertTrue(DataValidator.isCorrectSwift(correctSwift));
    }

    @Test(expected = SwiftException.class)
    public void whenInputIncorrectSwift() throws SwiftException {
        DataValidator.isCorrectSwift(incorrectSwift);
    }

}
