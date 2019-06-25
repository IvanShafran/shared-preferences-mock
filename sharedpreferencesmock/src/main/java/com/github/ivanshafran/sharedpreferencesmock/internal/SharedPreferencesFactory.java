package com.github.ivanshafran.sharedpreferencesmock.internal;

import android.content.SharedPreferences;

public class SharedPreferencesFactory {

    private boolean isThreadSafe;

    public SharedPreferencesFactory(final boolean isThreadSafe) {
        this.isThreadSafe = isThreadSafe;
    }

    public SharedPreferences create() {
        if (isThreadSafe) {
            return new ThreadSafeSharedPreferencesMock();
        } else {
            return new SharedPreferencesMock();
        }
    }
}
