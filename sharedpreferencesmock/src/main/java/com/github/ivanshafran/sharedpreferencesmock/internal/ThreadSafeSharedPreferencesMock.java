package com.github.ivanshafran.sharedpreferencesmock.internal;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

final class ThreadSafeSharedPreferencesMock extends SharedPreferencesMock {

    private final Object lock = new Object();

    @Override
    public Map<String, ?> getAll() {
        synchronized (lock) {
            return super.getAll();
        }
    }

    @Nullable
    @Override
    public String getString(final String key, @Nullable final String defValue) {
        synchronized (lock) {
            return super.getString(key, defValue);
        }
    }

    @Nullable
    @Override
    public Set<String> getStringSet(final String key, @Nullable final Set<String> defValues) {
        synchronized (lock) {
            return super.getStringSet(key, defValues);
        }
    }

    @Override
    public int getInt(final String key, final int defValue) {
        synchronized (lock) {
            return super.getInt(key, defValue);
        }
    }

    @Override
    public long getLong(final String key, final long defValue) {
        synchronized (lock) {
            return super.getLong(key, defValue);
        }
    }

    @Override
    public float getFloat(final String key, final float defValue) {
        synchronized (lock) {
            return super.getFloat(key, defValue);
        }
    }

    @Override
    public boolean getBoolean(final String key, final boolean defValue) {
        synchronized (lock) {
            return super.getBoolean(key, defValue);
        }
    }

    @Override
    public boolean contains(final String key) {
        synchronized (lock) {
            return super.contains(key);
        }
    }

    @Override
    public Editor edit() {
        return new ThreadSafeEditor();
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(final OnSharedPreferenceChangeListener listener) {
        synchronized (lock) {
            super.registerOnSharedPreferenceChangeListener(listener);
        }
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(final OnSharedPreferenceChangeListener listener) {
        synchronized (lock) {
            super.unregisterOnSharedPreferenceChangeListener(listener);
        }
    }

    public class ThreadSafeEditor extends SharedPreferencesMock.EditorImpl {

        private final Object editorLock = new Object();

        @Override
        public Editor putString(final String key, @Nullable final String value) {
            synchronized (editorLock) {
                super.putString(key, value);
                return this;
            }
        }

        @Override
        public Editor putStringSet(final String key, @Nullable final Set<String> values) {
            synchronized (editorLock) {
                super.putStringSet(key, values);
                return this;
            }
        }

        @Override
        public Editor putInt(final String key, final int value) {
            synchronized (editorLock) {
                super.putInt(key, value);
                return this;
            }
        }

        @Override
        public Editor putLong(final String key, final long value) {
            synchronized (editorLock) {
                super.putLong(key, value);
                return this;
            }
        }

        @Override
        public Editor putFloat(final String key, final float value) {
            synchronized (editorLock) {
                super.putFloat(key, value);
                return this;
            }
        }

        @Override
        public Editor putBoolean(final String key, final boolean value) {
            synchronized (editorLock) {
                super.putBoolean(key, value);
                return this;
            }
        }

        @Override
        public Editor remove(final String key) {
            synchronized (editorLock) {
                super.remove(key);
                return this;
            }
        }

        @Override
        public Editor clear() {
            synchronized (editorLock) {
                super.clear();
                return this;
            }
        }

        @Override
        public boolean commit() {
            synchronized (editorLock) {
                synchronized (lock) {
                    return super.commit();
                }
            }
        }

        @Override
        public void apply() {
            synchronized (editorLock) {
                synchronized (lock) {
                    super.apply();
                }
            }
        }
    }
}
