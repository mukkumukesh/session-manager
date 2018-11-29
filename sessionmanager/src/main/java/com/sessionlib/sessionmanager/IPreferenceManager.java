package com.sessionlib.sessionmanager;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Set;

/**
 * Interface to be implemented by any session managing class.
 */
@SuppressWarnings({"unused", "SameParameterValue"})
public interface IPreferenceManager {
    String AUTH_TOKEN = "auth_token";

    /**
     * Initialize session's shared preference.
     * @param context context.
     */
    void initialize(@NonNull Context context);

    /**
     * Destroys the current saved session.
     * @throws IllegalStateException if initialize has not be called before.
     */
    void destroySession() throws IllegalStateException;

    /**
     * Save string data on preference
     * @param key Preference key
     * @param val String value
     */
    void put(@NonNull String key, Object val);

    /**
     * Get string data from preference
     * @param key Get value using key
     */
    String getString(@NonNull String key);

    /**
     * Get integer data from preference
     * @param key Get value using key
     */
    int getInt(@NonNull String key);

    /**
     * Get Long data from preference
     * @param key Get value using key
     */
    long getLong(@NonNull String key);

    /**
     * Get float data from preference
     * @param key Get value using key
     */
    float getFloat(@NonNull String key);

    /**
     * Get boolean data from preference
     * @param key Get value using key
     */
    boolean getBoolean(@NonNull String key);

    /**
     * Save string set on preference
     * @param key Preference key
     * @param val String set value
     */
    void putStringSet(@NonNull String key, Set<String> val);

    /**
     * Get string set from preference using [key]
     */
    Set<String> getStringSet(@NonNull String key);

    /**
     * Destroy the selected key val from session
     * @param key Key
     */
    void remove(@NonNull String key);

    /**
     * @return true if user is not in guest mode else false
     */
    boolean isCurrentUserLoggedIn();

}
