package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class RecruitData  implements Serializable {
    /**
     * gpsId : null
     * city : null
     * recruitType_dictText : 招聘
     * compamyAddress : null
     * content : null
     * isPerson : null
     * price_dictText :
     * orderTime : null
     * updateBy : null
     * price : 5000
     * isOn : 1
     * jobEx : 1.0
     * company : null
     * id : 1
     * jobType_dictText : 挖掘机工程师
     * isTop_dictText : null
     * jobType : 1
     * gpsLon : null
     * contactName : 尼才
     * recruitType : 1
     * updateTime : 2020-10-31 20:24:31
     * needNumber : 100
     * jobAddress : null
     * createBy : null
     * createTime : 2020-10-31 20:24:29
     * isTop : null
     * gpsLat : null
     * sysOrgCode : null
     * isEnterprise : null
     * jobTittle : 高级维修工程师招聘
     * contactPhone : 1355555555
     */

    private String gpsId;
    private String city;
    private String recruitType_dictText;
    private String compamyAddress;
    private String content;
    private String isPerson;
    private String price_dictText;
    private String orderTime;
    private String updateBy;
    private Double price;
    private String isOn;
    private Double jobEx;
    private String company;
    private String id;
    private String jobType_dictText;
    private String isTop_dictText;
    private String jobType;
    private Object gpsLon;
    private String contactName;
    private String recruitType;
    private String updateTime;
    private Integer needNumber;
    private String jobAddress;
    private String createBy;
    private String createTime;
    private String isTop;
    private Object gpsLat;
    private Object sysOrgCode;
    private Object isEnterprise;
    private String jobTittle;
    private String contactPhone;

    public String getGpsId() {
        return gpsId;
    }

    public String getCity() {
        return TextUtils.isEmpty(city)?"广州":city;
    }

    public String getRecruitType_dictText() {
        return recruitType_dictText;
    }

    public String getCompamyAddress() {
        return compamyAddress;
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

    public Double getPrice() {
        return price;
    }

    public String getIsOn() {
        return isOn;
    }

    public Double getJobEx() {
        return jobEx;
    }

    public String getCompany() {
        return company;
    }

    public String getId() {
        return id;
    }

    public String getJobType_dictText() {
        return jobType_dictText;
    }

    public String getIsTop_dictText() {
        return isTop_dictText;
    }

    public String getJobType() {
        return jobType;
    }

    public Object getGpsLon() {
        return gpsLon;
    }

    public String getContactName() {
        return contactName;
    }

    public String getRecruitType() {
        return recruitType;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public Integer getNeedNumber() {
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

    public String getIsTop() {
        return isTop;
    }

    public Object getGpsLat() {
        return gpsLat;
    }

    public Object getSysOrgCode() {
        return sysOrgCode;
    }

    public Object getIsEnterprise() {
        return isEnterprise;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}
