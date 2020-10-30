package com.example.mechanicalapp;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

public class App extends Application {
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Hawk.init(this).build();
    }
    public static App getInstance() {
        return instance;
    }
}
