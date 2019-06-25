package com.github.ivanshafran.sharedpreferencesmock;

import android.content.SharedPreferences;

class SharedPreferencesFactory {

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
