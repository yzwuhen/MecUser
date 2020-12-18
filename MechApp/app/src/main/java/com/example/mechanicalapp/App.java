package com.example.mechanicalapp;

import android.app.Application;
import android.text.TextUtils;

import com.amap.api.location.DPoint;
import com.example.mechanicalapp.config.Configs;
import com.example.mechanicalapp.ui.data.HomeCityData;
import com.example.mechanicalapp.ui.data.UserInfo;
import com.netease.nim.uikit.api.NimUIKit;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.auth.LoginInfo;
import com.netease.nimlib.sdk.util.NIMUtil;
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
        initIMSDK();
    }

    private void initIMSDK() {
        NIMClient.init(this, loginInfo(), options());

        if (NIMUtil.isMainProcess(this)) {
            // 在主进程中初始化UI组件，判断所属进程方法请参见demo源码。
            initUiKit();
        }
    }

    private void initUiKit() {
        // 初始化
        NimUIKit.init(this);
    }

    // 如果提供，将同时进行自动登录。如果当前还没有登录用户，请传入null。详见自动登录章节。
    private LoginInfo loginInfo() {
        if (!TextUtils.isEmpty(getToken())) {
            LoginInfo loginInfo = new LoginInfo(getUserInfo().getImId(), getUserInfo().getImToken());
            return loginInfo;
        }
        return null;
    }

    // 设置初始化配置参数，如果返回值为 null，则全部使用默认参数。
    private SDKOptions options() {
//        SDKOptions options = new SDKOptions();
//        // 设置app图片/音频/日志等缓存目录
//        options.appCacheDir = NimSDKOptionConfig.getAppCacheDir(this) + "/app";
        return null;
    }

    private void initSDK() {
        UMConfigure.init(this, "5fd1be54bed37e4506c8504b"
                , "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
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

    public void setUser(UserInfo user) {
        Hawk.put(Configs.USER_INFO, user);
        this.userInfoBean = user;
    }

    public UserInfo getUserInfo() {
        if (userInfoBean == null) {
            userInfoBean = Hawk.get(Configs.USER_INFO);
        }

        if (userInfoBean == null) {
            userInfoBean = new UserInfo();
        }
        return userInfoBean;
    }

    public void setToken(String token) {
        Hawk.put(Configs.TOKEN, token);
        mToken = token;
    }

    public String getToken() {
        if (TextUtils.isEmpty(mToken)) {
            mToken = Hawk.get(Configs.TOKEN);
        }
        return mToken;
    }

    public DPoint getThisPoint() {
        return thisPoint;
    }

    public void setThisPoint(DPoint thisPoint) {
        this.thisPoint = thisPoint;
    }

    public HomeCityData getHomeCityData() {
        return homeCityData == null ? new HomeCityData() : homeCityData;
    }

    public void setHomeCityData(HomeCityData homeCityData) {
        this.homeCityData = homeCityData;
    }
}
