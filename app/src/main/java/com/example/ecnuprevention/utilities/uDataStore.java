package com.example.ecnuprevention.utilities;


import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import com.example.ecnuprevention.MyApplication;

public class uDataStore {

    private static final String storeName = "datastore";
    private static final SharedPreferences sp = MyApplication
            .getGlobalContext()
            .getSharedPreferences(storeName, MODE_PRIVATE);
    private static final SharedPreferences.Editor editor = sp.edit();


    public static void putString(String key, String val) {
        editor.putString(key, val);
        editor.apply();
    }

    public static void putInteger(String key, Integer val) {
        editor.putInt(key, val);
        editor.apply();
    }

    public static void putBoolean(String key, Boolean val) {
        editor.putBoolean(key, val);
        editor.apply();
    }

    public static String getString(String key) {
        return sp.getString(key, null);
    }

    public static Integer getInteger(String key) {
        if(sp.contains(key)) {
            return sp.getInt(key, 0);
        }
        return null;
    }

    public static Boolean getBoolean(String key) {
        if(sp.contains(key)) {
            return sp.getBoolean(key, false);
        }
        return null;
    }

    public static Boolean contains(String key) {
        return sp.contains(key);
    }

    public static Boolean delete(String key) {
        if(contains(key)) {
            editor.remove(key);
            editor.apply();
            return true;
        }
        return false;
    }

}
