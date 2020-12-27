package com.example.mechanicalapp.ui.data.request;

import java.io.Serializable;

public class ReLoginThree implements Serializable {

    /**
     * captcha :
     * code :
     * mobile :
     * password :
     * thirdId :
     * type :
     */

    private String captcha;
    private String mobile;
    private String password;
    private String thirdId;
    private String type;//1 微信 2 QQ

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }



    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
