package com.example.mechanicalapp;

import android.app.Application;
import android.text.TextUtils;

import com.amap.api.location.DPoint;
import com.example.mechanicalapp.ui.data.HomeCityData;
import com.example.mechanicalapp.ui.data.UserInfo;
import com.orhanobut.hawk.Hawk;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application {
    private static App instance;
    private UserInfo userInfoBean;
    private String mToken;
    private DPoint thisPoint;
    private HomeCityData homeCityData;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Hawk.init(this).build();
        initSDK();
      //  mToken ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ5OTcyMzIsInVzZXJuYW1lIjoiMTM3NTE3NzM0MDIifQ.GncACvJUq42cmTjms2tqhp_CyjJTDYX1LjMcLhLnyLE";
    }

    private void initSDK() {
        UMConfigure.init(this,"5fd1be54bed37e4506c8504b"
                ,"umeng", UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0

        // 微信设置
        PlatformConfig.setWeixin("wxcee9e76d06d68a8f", "769905f75aa7b29c8ee1a3d7ff316012");
        PlatformConfig.setWXFileProvider("com.example.mechanicalapp.fileprovider");
        // QQ设置
        PlatformConfig.setQQZone("101830139", "5d63ae8858f1caab67715ccd6c18d7a5");
        PlatformConfig.setQQFileProvider("com.example.mechanicalapp.fileprovider");

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

    public HomeCityData getHomeCityData() {
        return homeCityData==null?new HomeCityData():homeCityData;
    }

    public void setHomeCityData(HomeCityData homeCityData) {
        this.homeCityData = homeCityData;
    }
}
