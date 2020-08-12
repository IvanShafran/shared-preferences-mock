package com.github.ivanshafran.sharedpreferencesmock.sample;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

public class CounterPreferences {

    private static final String FILENAME = "filename";
    private static final String KEY = "key";

    private final SharedPreferences sharedPreferences;

    public CounterPreferences(@NonNull final Context context) {
        sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
    }

    public int getCounter() {
        return sharedPreferences.getInt(KEY, 0);
    }

    public void setCounter(final int counter) {
        sharedPreferences.edit().putInt(KEY, counter).apply();
    }
}
