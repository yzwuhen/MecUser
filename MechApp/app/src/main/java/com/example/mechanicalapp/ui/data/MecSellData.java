package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

public class MecSellData {

    /**
     * id : 1332225413392494593
     * createBy : 13886943851
     * createTime : 2020-11-27 15:31:05
     * updateBy : null
     * updateTime : 2020-12-03 09:14:07
     * sysOrgCode : null
     * title : 挖掘机
     * isNew : null
     * cateId : 1323668504007696385
     * brandId : 1
     * modelId : 1326573816739692546
     * price : 2000000
     * workTime : 200
     * facDate : null
     * paymentType : null
     * briefDesc : 求购一台挖掘机，求购一台挖掘机
     * pic : null
     * bussiessType : 2
     * gpsLon : 113.284017
     * gpsLat : 23.007530
     * orderTime : 2020-11-27
     * city : 广州市
     * isPerson : null
     * isEnterprise : null
     * isOn : 1
     * cateName : 挖掘机子类
     * brandName : 长城
     * modelName : ak149
     * isTop : null
     * contactName : 锅碗瓢盆
     * contactPhone : 13886943851
     * address : 广州市番禺区会江村石中二路119号105
     * avatar : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1930d268-03cc-4d2b-abc6-b98a046970f2_1606725276452.jpg
     * realname : 13886943851
     * isVerify : 1
     * viewNum : 6
     */

    private String id;
    private String createBy;
    private String createTime;
    private Object updateBy;
    private String updateTime;
    private Object sysOrgCode;
    private String title;
    private Object isNew;
    private String cateId;
    private String brandId;
    private String modelId;
    private String price;
    private String workTime;
    private String facDate;
    private Object paymentType;
    private String briefDesc;
    private String pic;
    private String bussiessType;
    private String gpsLon;
    private String gpsLat;
    private String orderTime;
    private String city;
    private Object isPerson;
    private Object isEnterprise;
    private String isOn;
    private String cateName;
    private String brandName;
    private String modelName;
    private Object isTop;
    private String contactName;
    private String contactPhone;
    private String address;
    private String avatar;
    private String realname;
    private String isVerify;
    private int viewNum;

    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Object getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(Object sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getIsNew() {
        return isNew;
    }

    public void setIsNew(Object isNew) {
        this.isNew = isNew;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getFacDate() {
        return TextUtils.isEmpty(facDate)?"":(facDate.split("-")[0]+"年");
    }

    public void setFacDate(String facDate) {
        this.facDate = facDate;
    }

    public Object getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Object paymentType) {
        this.paymentType = paymentType;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getBussiessType() {
        return bussiessType;
    }

    public void setBussiessType(String bussiessType) {
        this.bussiessType = bussiessType;
    }

    public double getGpsLon() {
        return TextUtils.isEmpty(gpsLon)?0.0:Double.valueOf(gpsLon);
    }

    public void setGpsLon(String gpsLon) {
        this.gpsLon = gpsLon;
    }

    public double getGpsLat() {
        return TextUtils.isEmpty(gpsLat)?0.0:Double.valueOf(gpsLat);
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(Object isPerson) {
        this.isPerson = isPerson;
    }

    public Object getIsEnterprise() {
        return isEnterprise;
    }

    public void setIsEnterprise(Object isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    public String getIsOn() {
        return isOn;
    }

    public void setIsOn(String isOn) {
        this.isOn = isOn;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Object getIsTop() {
        return isTop;
    }

    public void setIsTop(Object isTop) {
        this.isTop = isTop;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIsVerify() {
        return isVerify;
    }

    public void setIsVerify(String isVerify) {
        this.isVerify = isVerify;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }
}
