package com.example.mechanicalapp.ui.data.request;

public class ReGetMsgCode {
    private String mobile;
    private String smsmode;// 0 .登录模板、1.注册模板、2.忘记密码模板

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
