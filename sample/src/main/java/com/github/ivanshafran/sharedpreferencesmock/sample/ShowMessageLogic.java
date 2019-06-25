package com.github.ivanshafran.sharedpreferencesmock.sample;

public class ShowMessageLogic {

    private final CounterPreferences counterPreferences;

    public ShowMessageLogic(final CounterPreferences counterPreferences) {
        this.counterPreferences = counterPreferences;
    }

    public boolean shouldShowMessage() {
        return counterPreferences.getCounter() >= 42;
    }
}
