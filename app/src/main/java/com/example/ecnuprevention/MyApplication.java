package com.example.ecnuprevention;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public synchronized static Context getGlobalContext() {
        return context;
    }
}
