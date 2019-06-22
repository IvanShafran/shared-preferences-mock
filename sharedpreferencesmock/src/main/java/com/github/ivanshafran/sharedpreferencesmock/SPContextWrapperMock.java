package com.github.ivanshafran.sharedpreferencesmock;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SPContextWrapperMock extends ContextWrapper {

    private final Map<String, SharedPreferences> preferencesMap = new HashMap<>();

    public SPContextWrapperMock(final Context base) {
        super(base);
    }

    @Override
    public SharedPreferences getSharedPreferences(final String name, final int mode) {
        if (preferencesMap.containsKey(name)) {
            return preferencesMap.get(name);
        } else {
            final SharedPreferences sharedPreferences = new SharedPreferencesMock();
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
