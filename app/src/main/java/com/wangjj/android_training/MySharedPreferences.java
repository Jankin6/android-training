package com.wangjj.android_training;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;


public class MySharedPreferences {

    public static final String FIRST_START_APP = "first_start_app";
    public static final String KEY_APP_DEFAULT_USER = "key_app_default_user";

    public static void set(SharedPreferences sp, String prefKey, Object newValue) {
        SharedPreferences.Editor editor = sp.edit();
        if (newValue == null) {
            editor.remove(prefKey);
        } else {
            if (newValue.getClass() == Boolean.class) {
                editor.putBoolean(prefKey, (Boolean) newValue);
            } else if (newValue.getClass() == Float.class) {
                editor.putFloat(prefKey, (Float) newValue);
            } else if (newValue.getClass() == Integer.class) {
                editor.putInt(prefKey, (Integer) newValue);
            } else if (newValue.getClass() == Long.class) {
                editor.putLong(prefKey, (Long) newValue);
            } else {
                editor.putString(prefKey, newValue.toString());
            }
        }
        editor.commit();
    }

    public static void setDefault(String prefKey, Object newValue) {
        set(PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance())
            , prefKey, newValue);
    }

    public static void setDefault(String prefKey, Set<String> strSet) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(MyApplication.getInstance()).edit();
        if (strSet == null) {
            editor.remove(prefKey);
        } else {
            editor.putStringSet(prefKey, strSet);
        }
        editor.commit();
    }

    public static Set<String> getDefault(String prefKey) {
        return PreferenceManager.getDefaultSharedPreferences(
            MyApplication.getInstance()).getStringSet(prefKey, new HashSet<String>());
    }

    public static String getDefault(String prefKey, String defValue) {
        return PreferenceManager.getDefaultSharedPreferences(
            MyApplication.getInstance()).getString(prefKey, defValue);
    }

    public static boolean getDefault(String prefKey, boolean defValue) {
        return PreferenceManager.getDefaultSharedPreferences(
            MyApplication.getInstance()).getBoolean(prefKey, defValue);
    }

    public static float getDefault(String prefKey, float defValue) {
        return PreferenceManager.getDefaultSharedPreferences(
            MyApplication.getInstance()).getFloat(prefKey, defValue);
    }

    public static long getDefault(String prefKey, long defValue) {
        return PreferenceManager.getDefaultSharedPreferences(
            MyApplication.getInstance()).getLong(prefKey, defValue);
    }

    public static int getDefault(String prefKey, int defValue) {
        return PreferenceManager.getDefaultSharedPreferences(
            MyApplication.getInstance()).getInt(prefKey, defValue);
    }
}
