package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class MecDetailsData implements Serializable {
    /**
     * id : 5
     * createBy : admin
     * createTime : 2020-10-18 08:50:55
     * updateBy : admin
     * updateTime : 2020-11-05 20:16:35
     * sysOrgCode : string
     * title : 大臂机械
     * cateId : 1323668504007696385
     * brandId : 1321490471452721153
     * modelId : 1321491075206004738
     * price : 100.0
     * workTime : 2年
     * facDate : 2020-10-18
     * briefDesc : 点点滴滴才休息
     * pic : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg
     * bussiessType : 1
     * priceUnit : 1
     * tenancy : 2
     * gpsLon : 1.22333
     * gpsLat : 3.122
     * mecUnit : 2
     * orderTime : 2020-10-19
     * isNew : 1
     * city : null
     * isPerson : 1
     * isEnterprise : null
     * isOn : 1
     * cateName : 挖掘机子类
     * brandName : 八达重工
     * modelName : 机械机型1
     * isTop : null
     * contactName : 老铁
     * contactPhone : 15035900233
     * address : null
     * facTime : 5
     * avatar : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg
     * realname : 老陈
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String title;
    private String cateId;
    private String brandId;
    private String modelId;
    private double price;
    private String workTime;
    private String facDate;
    private String briefDesc;
    private String pic;
    private String bussiessType;
    private String priceUnit;
    private String tenancy;
    private String gpsLon;
    private String gpsLat;
    private String mecUnit;
    private String orderTime;
    private String isNew;
    private Object city;
    private String isPerson;
    private Object isEnterprise;
    private String isOn;
    private String cateName;
    private String brandName;
    private String modelName;
    private Object isTop;
    private String contactName;
    private String contactPhone;
    private Object address;
    private int facTime;
    private String avatar;
    private String realname;
    private String priceUnit_dictText;
    private String viewNum;

    public String getViewNum() {
        return viewNum;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
    }

    public String getPriceUnit_dictText() {
        return TextUtils.isEmpty(priceUnit_dictText)?"元":priceUnit_dictText;
    }

    public void setPriceUnit_dictText(String priceUnit_dictText) {
        this.priceUnit_dictText = priceUnit_dictText;
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getFacDate() {
        return facDate;
    }

    public void setFacDate(String facDate) {
        this.facDate = facDate;
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

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getTenancy() {
        return tenancy;
    }

    public void setTenancy(String tenancy) {
        this.tenancy = tenancy;
    }

    public String getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(String gpsLon) {
        this.gpsLon = gpsLon;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
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

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
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

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public int getFacTime() {
        return facTime;
    }

    public void setFacTime(int facTime) {
        this.facTime = facTime;
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
}
