package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class RecruitData  implements Serializable {


    /**
     * birthday : null
     * sex_dictText : null
     * gpsId : null
     * city : null
     * isReady : null
     * recruitType_dictText : 招聘
     * cateName : 旋挖机驾驶员
     * content : 招聘地铁司机
     * isPerson : null
     * price_dictText : 面议
     * orderTime : 2020-11-18
     * updateBy : null
     * price : 5
     * isOn : 1
     * jobEx : 5
     * company : 广州地铁
     * id : 1328887284547833857
     * isTop_dictText : null
     * gpsLon : null
     * contactName : 哈哈
     * recruitType : 1
     * sex : null
     * jobEx_dictText :
     * isReady_dictText : null
     * updateTime : null
     * needNumber : 5
     * jobAddress : 广州市
     * createBy : 13886943851
     * createTime : 2020-11-18 10:26:33
     * cateId : 1327630527800279042
     * isTop : null
     * companyAddress : 广州市
     * gpsLat : null
     * sysOrgCode : null
     * isEnterprise : null
     * jobtitle : 司机
     * contactPhone : 13886943851
     * age : null
     */

    private String birthday;
    private String sex_dictText;
    private String gpsId;
    private String city;
    private String isReady;
    private String recruitType_dictText;
    private String cateName;
    private String content;
    private String isPerson;
    private String price_dictText;
    private String orderTime;
    private String updateBy;
    private int price;
    private String isOn;
    private int jobEx;
    private String company;
    private String id;
    private String isTop_dictText;
    private String gpsLon;
    private String contactName;
    private String recruitType;
    private String sex;
    private String jobEx_dictText;
    private String isReady_dictText;
    private String updateTime;
    private int needNumber;
    private String jobAddress;
    private String createBy;
    private String createTime;
    private String cateId;
    private String isTop;
    private String companyAddress;
    private String gpsLat;
    private String sysOrgCode;
    private String isEnterprise;
    private String jobtitle;
    private String contactPhone;
    private boolean isSelect;
    private String realname;

    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex_dictText() {
        return TextUtils.isEmpty(sex_dictText)?"男":sex_dictText;
    }

    public String getGpsId() {
        return gpsId;
    }

    public String getCity() {
        return TextUtils.isEmpty(city)?"广州":city;
    }

    public String getIsReady() {
        return isReady;
    }

    public String getRecruitType_dictText() {
        return recruitType_dictText;
    }

    public String getCateName() {
        return cateName;
    }

    public String getContent() {
        return content;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public String getPrice_dictText() {
        return price_dictText;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public int getPrice() {
        return price;
    }

    public String getIsOn() {
        return isOn;
    }

    public int getJobEx() {
        return jobEx;
    }

    public String getCompany() {
        return company;
    }

    public String getId() {
        return id;
    }

    public String getIsTop_dictText() {
        return isTop_dictText;
    }

    public Double getGpsLon() {
        return TextUtils.isEmpty(gpsLon)?0.0d:Double.valueOf(gpsLon);
    }

    public String getContactName() {
        return contactName;
    }

    public String getRecruitType() {
        return recruitType;
    }

    public String getSex() {
        return sex;
    }

    public String getJobEx_dictText() {
        return jobEx_dictText;
    }

    public String getIsReady_dictText() {
        return isReady_dictText;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public int getNeedNumber() {
        return needNumber;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getCateId() {
        return cateId;
    }

    public String getIsTop() {
        return isTop;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public Double getGpsLat() {
        return TextUtils.isEmpty(gpsLat)?0.0d:Double.valueOf(gpsLat);
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public String getIsEnterprise() {
        return isEnterprise;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}
