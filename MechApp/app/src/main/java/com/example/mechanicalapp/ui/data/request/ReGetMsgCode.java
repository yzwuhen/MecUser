package com.example.mechanicalapp.ui.data.request;

import java.io.Serializable;

public class ReGetMsgCode implements Serializable {
    private String mobile;
    private String smsmode;// 0 .登录模板、1.注册模板、2.忘记密码模板
    private String captcha;
    private String password;


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsmode() {
        return smsmode;
    }

    public void setSmsmode(String smsmode) {
        this.smsmode = smsmode;
    }
}
