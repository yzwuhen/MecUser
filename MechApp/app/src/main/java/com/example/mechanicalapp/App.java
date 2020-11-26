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
        mToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ2NzU1NzYsInVzZXJuYW1lIjoiMTM3NTE3NzM0MDIifQ.xdV6NQJ_tAGgwQ99taNBvC30aIYtBLaNwSoMijgwdMI";
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
        return mToken;
    }

    public DPoint getThisPoint() {
        return thisPoint;
    }

    public void setThisPoint(DPoint thisPoint) {
        this.thisPoint = thisPoint;
    }
}
