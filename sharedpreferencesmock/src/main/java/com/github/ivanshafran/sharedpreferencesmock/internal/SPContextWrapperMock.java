package com.github.ivanshafran.sharedpreferencesmock.internal;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class SPContextWrapperMock extends ContextWrapper {

    private final Map<String, SharedPreferences> preferencesMap = new HashMap<>();
    private final SharedPreferencesFactory factory;

    public SPContextWrapperMock(@NonNull final Context base, @NonNull final SharedPreferencesFactory factory) {
        super(base);
        this.factory = factory;
    }

    @Override
    public SharedPreferences getSharedPreferences(final String name, final int mode) {
        if (preferencesMap.containsKey(name)) {
            return preferencesMap.get(name);
        } else {
            final SharedPreferences sharedPreferences = factory.create();
            preferencesMap.put(name, sharedPreferences);
            return sharedPreferences;
        }
    }

    @Override
    public boolean deleteSharedPreferences(final String name) {
        preferencesMap.remove(name);
        return true;
    }
}
