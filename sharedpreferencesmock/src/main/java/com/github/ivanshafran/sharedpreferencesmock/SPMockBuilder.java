package com.github.ivanshafran.sharedpreferencesmock;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

import com.github.ivanshafran.sharedpreferencesmock.internal.ContextMock;
import com.github.ivanshafran.sharedpreferencesmock.internal.SPContextWrapperMock;
import com.github.ivanshafran.sharedpreferencesmock.internal.SharedPreferencesFactory;

public final class SPMockBuilder {

    private boolean isThreadSafe = false;

    public SPMockBuilder() {

    }

    public SPMockBuilder setThreadSafe(final boolean isThreadSafe) {
        this.isThreadSafe = isThreadSafe;
        return this;
    }

    public SharedPreferences createSharedPreferences() {
        return createFactory().create();
    }

    public Context createContext() {
        return new SPContextWrapperMock(new ContextMock(), createFactory());
    }

    public Context wrapContext(@NonNull final Context context) {
        return new SPContextWrapperMock(context, createFactory());
    }

    private SharedPreferencesFactory createFactory() {
        return new SharedPreferencesFactory(isThreadSafe);
    }
}
