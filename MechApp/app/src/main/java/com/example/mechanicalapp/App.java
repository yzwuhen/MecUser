package com.example.mechanicalapp;

import android.app.Application;

import com.example.mechanicalapp.ui.data.UserInfoBean;
import com.orhanobut.hawk.Hawk;

public class App extends Application {
    private static App instance;
    private UserInfoBean userInfoBean;
    private String mToken;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Hawk.init(this).build();
    }
    public static App getInstance() {
        return instance;
    }
    public void setUser(UserInfoBean user){
        this.userInfoBean =user;
    }

    public UserInfoBean getUserInfo(){
        return userInfoBean;
    }

    public void setToken(String token){
        mToken =token;
    }
    public String getToken(){
        return mToken;
    }
}
