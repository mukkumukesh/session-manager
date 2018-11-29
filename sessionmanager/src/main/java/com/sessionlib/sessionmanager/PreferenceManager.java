package com.sessionlib.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.Set;

/**
 * Session Manager class to persist and fetch user details.
 */
public final class PreferenceManager implements IPreferenceManager {

    private static final String STRING_DEFAULT = null;
    private static final int INT_DEFAULT = 0;
    private SharedPreferences mSharedPreference;
    private static IPreferenceManager sInstance = new PreferenceManager();

    private PreferenceManager() {
        if (sInstance != null) {
            throw new IllegalStateException("Object is already created");
        }
    }

    public static IPreferenceManager getInstance() {
        return sInstance;
    }

    @Override
    public void initialize(@NonNull Context context) {
        mSharedPreference = context.getSharedPreferences("user_session", Context.MODE_PRIVATE);
    }

    @Override
    public void destroySession() throws IllegalStateException {
        checkForInitialization();
        mSharedPreference.edit().clear().apply();
    }

    @Override
    public void put(@NonNull String key, Object val) {
        checkForInitialization();
        final SharedPreferences.Editor editor = mSharedPreference.edit();
        if (val instanceof Boolean) {
            editor.putBoolean(key, (Boolean) val).apply();
        } else if (val instanceof Integer) {
            editor.putInt(key, (Integer) val).apply();
        } else if (val instanceof Long) {
            editor.putLong(key, (Long) val).apply();
        } else if (val instanceof Float) {
            editor.putFloat(key, (Float) val).apply();
        } else {
            editor.putString(key, (String) val).apply();
        }
    }

    @Override
    public String getString(@NonNull String key) {
        checkForInitialization();
        return mSharedPreference.getString(key, STRING_DEFAULT);
    }

    @Override
    public int getInt(@NonNull String key) {
        checkForInitialization();
        return mSharedPreference.getInt(key, INT_DEFAULT);
    }

    @Override
    public long getLong(@NonNull String key) {
        checkForInitialization();
        return mSharedPreference.getLong(key, INT_DEFAULT);
    }

    @Override
    public float getFloat(@NonNull String key) {
        checkForInitialization();
        return mSharedPreference.getFloat(key, INT_DEFAULT);
    }

    @Override
    public boolean getBoolean(@NonNull String key) {
        checkForInitialization();
        return mSharedPreference.getBoolean(key, false);
    }

    @Override
    public void putStringSet(@NonNull String key, Set<String> val) {
        checkForInitialization();
        final SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.putStringSet(key, val).apply();
    }

    @Override
    public Set<String> getStringSet(@NonNull String key) {
        checkForInitialization();
        return mSharedPreference.getStringSet(key, null);
    }

    @Override
    public void remove(@NonNull String key) {
        checkForInitialization();
        final SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.remove(key);
        editor.apply();
    }

    @Override
    public boolean isCurrentUserLoggedIn() {
        return getString(AUTH_TOKEN) != null;
    }

    /**
     * Throws IllegalStateException if initialization has not been performed.
     */
    private void checkForInitialization() {
        if (mSharedPreference == null) {
            throw new IllegalStateException("Initialization is not performed yet.");
        }
    }
}