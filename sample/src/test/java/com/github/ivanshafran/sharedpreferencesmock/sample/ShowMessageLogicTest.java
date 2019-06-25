package com.github.ivanshafran.sharedpreferencesmock.sample;

import com.github.ivanshafran.sharedpreferencesmock.SPMockBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShowMessageLogicTest {

    private final SPMockBuilder spMockBuilder = new SPMockBuilder();
    private CounterPreferences counterPreferences;
    private ShowMessageLogic showMessageLogic;

    @Before
    public void setUp() {
        counterPreferences = new CounterPreferences(spMockBuilder.createContext());
        showMessageLogic = new ShowMessageLogic(counterPreferences);
    }

    @Test
    public void on42CounterItShouldShowMessage() {
        counterPreferences.setCounter(42);

        Assert.assertTrue(showMessageLogic.shouldShowMessage());
    }

    @Test
    public void onLessThan42ItShouldNotShowMessage() {
        counterPreferences.setCounter(41);

        Assert.assertFalse(showMessageLogic.shouldShowMessage());
    }
}
