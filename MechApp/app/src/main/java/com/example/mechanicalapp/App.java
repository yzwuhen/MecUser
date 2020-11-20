package com.example.mechanicalapp;

import android.app.Application;

import com.amap.api.location.DPoint;
import com.example.mechanicalapp.ui.data.UserInfo;
import com.orhanobut.hawk.Hawk;

public class App extends Application {
    private static App instance;
    private UserInfo userInfoBean;
    private String mToken;

    private DPoint thisPoint;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Hawk.init(this).build();
    }
    public static App getInstance() {
        return instance;
    }
    public void setUser(UserInfo user){
        this.userInfoBean =user;
    }

    public UserInfo getUserInfo(){
        if (userInfoBean ==null){
            userInfoBean =new  UserInfo();
        }
        return userInfoBean;
    }

    public void setToken(String token){
        mToken =token;
    }
    public String getToken(){
        return "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQxNTYwMjAsInVzZXJuYW1lIjoiMTM3NTE3NzM0MDIifQ.xdcw7xyur9wTXg4IPUXDZSKQuStnt76Graa5T_DI9N8";
    }

    public DPoint getThisPoint() {
        return thisPoint;
    }

    public void setThisPoint(DPoint thisPoint) {
        this.thisPoint = thisPoint;
    }
}
