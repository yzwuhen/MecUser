package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

public class MecSellData {
    /**
     * facDate : 2020-11-10
     * modelId : 1321491075206004738
     * city : 广州市
     * pic : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/2D 2D-01_1604502265355.jpg
     * cateName :
     * paymentType : 1
     * isPerson : 1
     * orderTime : null
     * updateBy : admin
     * briefDesc : 123123213123
     * price : null
     * isOn : 1
     * isNew_dictText : 是
     * id : 1324004673299951617
     * isTop_dictText : null
     * tittle : 推土机SD13型号
     * brandName : 八达重工
     * gpsLon : 1.22333
     * bussiessType : 1
     * contactName : 老陈
     * updateTime : 2020-11-05 20:16:35
     * isNew : 1
     * workTime : 2年
     * modelName : 机械机型1
     * createBy : admin
     * createTime : 2020-11-04 23:04:47
     * cateId : 1323668504007696385
     * isTop : null
     * brandId : 1321490471452721153
     * gpsLat : 1
     * sysOrgCode : A01A03
     * isEnterprise : null
     * paymentType_dictText : 协议付款
     * bussiessType_dictText : 出售
     * contactPhone : 15013098003
     */

    private String facDate;
    private String modelId;
    private String city;
    private String pic;
    private String cateName;
    private String paymentType;
    private String isPerson;
    private Object orderTime;
    private String updateBy;
    private String briefDesc;
    private String price;
    private String isOn;
    private String isNew_dictText;
    private String id;
    private Object isTop_dictText;
    private String tittle;
    private String brandName;
    private Double gpsLon;
    private String bussiessType;
    private String contactName;
    private String updateTime;
    private String isNew;
    private String workTime;
    private String modelName;
    private String createBy;
    private String createTime;
    private String cateId;
    private Object isTop;
    private String brandId;
    private Double gpsLat;
    private String sysOrgCode;
    private Object isEnterprise;
    private String paymentType_dictText;
    private String bussiessType_dictText;
    private String contactPhone;
    private String priceUnit;
    private String priceUnit_dictText;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
    public String getFacDate() {
        return facDate;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public String getPriceUnit_dictText() {
        return TextUtils.isEmpty(priceUnit_dictText)?"元":priceUnit_dictText;
    }

    public String getModelId() {
        return modelId;
    }

    public String getCity() {
        return TextUtils.isEmpty(city)?"广州":city;
    }

    public String getPic() {
        return pic;
    }

    public String getCateName() {
        return cateName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public Object getOrderTime() {
        return orderTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public String getPrice() {
        return TextUtils.isEmpty(price)?"0":price;
    }

    public String getIsOn() {
        return isOn;
    }

    public String getIsNew_dictText() {
        return isNew_dictText;
    }

    public String getId() {
        return id;
    }

    public Object getIsTop_dictText() {
        return isTop_dictText;
    }

    public String getTittle() {
        return tittle;
    }

    public String getBrandName() {
        return brandName;
    }

    public Double getGpsLon() {
        return gpsLon;
    }

    public String getBussiessType() {
        return bussiessType;
    }

    public String getContactName() {
        return TextUtils.isEmpty(contactName)?"":contactName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getIsNew() {
        return isNew;
    }

    public String getWorkTime() {
        return workTime;
    }

    public String getModelName() {
        return modelName;
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

    public Object getIsTop() {
        return isTop;
    }

    public String getBrandId() {
        return brandId;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public Object getIsEnterprise() {
        return isEnterprise;
    }

    public String getPaymentType_dictText() {
        return paymentType_dictText;
    }

    public String getBussiessType_dictText() {
        return bussiessType_dictText;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}
