package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class MecLeaseData implements Serializable {

    /**
     * priceUnit_dictText : 元/台班
     * facDate : 2020-10-18
     * modelId : 1321491075206004738
     * city : null
     * pic : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg
     * cateName : 挖掘机子类
     * isPerson : 1
     * mecUnit : 2
     * orderTime : 2020-10-19
     * updateBy : admin
     * briefDesc : 点点滴滴才休息
     * price : 100
     * isOn : 1
     * contactPone : 15013096883
     * isNew_dictText : 是
     * id : 1318136162723864517
     * isTop_dictText : null
     * title : 大臂机械20
     * priceUnit : 1
     * brandName : 八达重工
     * gpsLon : 1.22333
     * bussiessType : 2
     * contactName : 老铁
     * tenancy : 1
     * updateTime : 2020-11-05 20:16:35
     * isNew : 1
     * workTime : 2年
     * modelName : 机械机型1
     * createBy : admin
     * createTime : 2020-10-20 08:50:55
     * cateId : 1323668504007696385
     * isTop : null
     * brandId : 1321490471452721153
     * gpsLat : 3.122
     * sysOrgCode : string
     * isEnterprise : null
     * bussiessType_dictText : 求租
     */

    private String priceUnit_dictText;
    private String facDate;
    private String modelId;
    private String city;
    private String pic;
    private String cateName;
    private String isPerson;
    private String mecUnit;
    private String orderTime;
    private String updateBy;
    private String briefDesc;
    private Double price;
    private String isOn;
    private String contactPone;
    private String isNew_dictText;
    private String id;
    private Object isTop_dictText;
    private String title;
    private String priceUnit;
    private String brandName;
    private Double gpsLon;
    private String bussiessType;
    private String contactName;
    private String tenancy;
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
    private String bussiessType_dictText;
    private String avatar;



    private boolean isSelect;

    public String getAvatar() {
        return avatar;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getPriceUnit_dictText() {
        return TextUtils.isEmpty(priceUnit_dictText)?"元":priceUnit_dictText;
    }

    public void setPriceUnit_dictText(String priceUnit_dictText) {
        this.priceUnit_dictText = priceUnit_dictText;
    }

    public String getFacDate() {
        return facDate;
    }

    public void setFacDate(String facDate) {
        this.facDate = facDate;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getCity() {
        return TextUtils.isEmpty(city)?"广州":city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
        this.isPerson = isPerson;
    }

    public String getMecUnit() {
        return mecUnit;
    }

    public void setMecUnit(String mecUnit) {
        this.mecUnit = mecUnit;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIsOn() {
        return isOn;
    }

    public void setIsOn(String isOn) {
        this.isOn = isOn;
    }

    public String getContactPone() {
        return contactPone;
    }

    public void setContactPone(String contactPone) {
        this.contactPone = contactPone;
    }

    public String getIsNew_dictText() {
        return isNew_dictText;
    }

    public void setIsNew_dictText(String isNew_dictText) {
        this.isNew_dictText = isNew_dictText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getIsTop_dictText() {
        return isTop_dictText;
    }

    public void setIsTop_dictText(Object isTop_dictText) {
        this.isTop_dictText = isTop_dictText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Double getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(Double gpsLon) {
        this.gpsLon = gpsLon;
    }

    public String getBussiessType() {
        return bussiessType;
    }

    public void setBussiessType(String bussiessType) {
        this.bussiessType = bussiessType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTenancy() {
        return tenancy;
    }

    public void setTenancy(String tenancy) {
        this.tenancy = tenancy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public Object getIsTop() {
        return isTop;
    }

    public void setIsTop(Object isTop) {
        this.isTop = isTop;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public Object getIsEnterprise() {
        return isEnterprise;
    }

    public void setIsEnterprise(Object isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    public String getBussiessType_dictText() {
        return bussiessType_dictText;
    }

    public void setBussiessType_dictText(String bussiessType_dictText) {
        this.bussiessType_dictText = bussiessType_dictText;
    }
}
