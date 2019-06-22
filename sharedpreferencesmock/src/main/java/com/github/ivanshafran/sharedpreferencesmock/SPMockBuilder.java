package com.github.ivanshafran.sharedpreferencesmock;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public final class SPMockBuilder {

    public SPMockBuilder() {

    }

    public SharedPreferences createSharedPreferences() {
        return new SharedPreferencesMock();
    }

    public Context createContext() {
        return new SPContextWrapperMock(new ContextMock());
    }

    public Context wrapContext(@NonNull final Context context) {
        return new SPContextWrapperMock(context);
    }
}
