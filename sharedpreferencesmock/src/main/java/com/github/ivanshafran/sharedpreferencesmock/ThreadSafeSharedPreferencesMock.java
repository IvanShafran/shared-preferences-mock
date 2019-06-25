package com.github.ivanshafran.sharedpreferencesmock;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

class ThreadSafeSharedPreferencesMock implements SharedPreferences {

    private final Object lock = new Object();
    private final SharedPreferences sharedPreferences;

    public ThreadSafeSharedPreferencesMock(@NonNull final SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public Map<String, ?> getAll() {
        synchronized (lock) {
            return sharedPreferences.getAll();
        }
    }

    @Nullable
    @Override
    public String getString(final String key, @Nullable final String defValue) {
        synchronized (lock) {
            return sharedPreferences.getString(key, defValue);
        }
    }

    @Nullable
    @Override
    public Set<String> getStringSet(final String key, @Nullable final Set<String> defValues) {
        synchronized (lock) {
            return sharedPreferences.getStringSet(key, defValues);
        }
    }

    @Override
    public int getInt(final String key, final int defValue) {
        synchronized (lock) {
            return sharedPreferences.getInt(key, defValue);
        }
    }

    @Override
    public long getLong(final String key, final long defValue) {
        synchronized (lock) {
            return sharedPreferences.getLong(key, defValue);
        }
    }

    @Override
    public float getFloat(final String key, final float defValue) {
        synchronized (lock) {
            return sharedPreferences.getFloat(key, defValue);
        }
    }

    @Override
    public boolean getBoolean(final String key, final boolean defValue) {
        synchronized (lock) {
            return sharedPreferences.getBoolean(key, defValue);
        }
    }

    @Override
    public boolean contains(final String key) {
        synchronized (lock) {
            return sharedPreferences.contains(key);
        }
    }

    @Override
    public Editor edit() {
        return new ThreadSafeEditor(sharedPreferences.edit());
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(final OnSharedPreferenceChangeListener listener) {
        synchronized (lock) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
        }
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(final OnSharedPreferenceChangeListener listener) {
        synchronized (lock) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
        }
    }

    public class ThreadSafeEditor implements SharedPreferences.Editor {

        private final Object editorLock = new Object();
        private final Editor editor;

        public ThreadSafeEditor(@NonNull final Editor editor) {
            this.editor = editor;
        }

        @Override
        public Editor putString(final String key, @Nullable final String value) {
            synchronized (editorLock) {
                editor.putString(key, value);
                return this;
            }
        }

        @Override
        public Editor putStringSet(final String key, @Nullable final Set<String> values) {
            synchronized (editorLock) {
                editor.putStringSet(key, values);
                return this;
            }
        }

        @Override
        public Editor putInt(final String key, final int value) {
            synchronized (editorLock) {
                editor.putInt(key, value);
                return this;
            }
        }

        @Override
        public Editor putLong(final String key, final long value) {
            synchronized (editorLock) {
                editor.putLong(key, value);
                return this;
            }
        }

        @Override
        public Editor putFloat(final String key, final float value) {
            synchronized (editorLock) {
                editor.putFloat(key, value);
                return this;
            }
        }

        @Override
        public Editor putBoolean(final String key, final boolean value) {
            synchronized (editorLock) {
                editor.putBoolean(key, value);
                return this;
            }
        }

        @Override
        public Editor remove(final String key) {
            synchronized (editorLock) {
                editor.remove(key);
                return this;
            }
        }

        @Override
        public Editor clear() {
            synchronized (editorLock) {
                editor.clear();
                return this;
            }
        }

        @Override
        public boolean commit() {
            synchronized (editorLock) {
                synchronized (lock) {
                    return editor.commit();
                }
            }
        }

        @Override
        public void apply() {
            synchronized (editorLock) {
                synchronized (lock) {
                    editor.apply();
                }
            }
        }
    }
}
