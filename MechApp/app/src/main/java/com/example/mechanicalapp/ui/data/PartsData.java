package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class PartsData implements Serializable {


    /**
     * priceUnit_dictText : null
     * city : 深圳市
     * pic : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg-1_1605684491284.bin,
     * title : 全球气温
     * partsType : 挖掘机
     * cateName : 挖掘机
     * content : 1是法国
     * isPerson : null
     * orderTime : 2020-11-18
     * updateBy : null
     * price : 123123
     * isOn : 1
     * id : 1328963220114886657
     * isTop_dictText : null
     * brand : 去微软
     * isTalk : 1
     * priceUnit : null
     * address : 广东省深圳市 宝安区
     * gpsLon : 113.841901
     * bussiessType : 1
     * contactName : 微软
     * updateTime : null
     * createBy : 13751773402
     * createTime : 2020-11-18 15:28:17
     * cateId : 1321476604976406530
     * isTop : null
     * isOn_dictText : 是
     * gpsLat : 22.628645
     * sysOrgCode : A02
     * isEnterprise : null
     * contactPhone : 1333333333
     */

    private String priceUnit_dictText;
    private String city;
    private String pic;
    private String title;
    private String partsType;
    private String cateName;
    private String content;
    private int isPerson;
    private String orderTime;
    private String updateBy;
    private String price;
    private int isOn;
    private String id;
    private String isTop_dictText;
    private String brand;
    private String isTalk;
    private String priceUnit;
    private String address;
    private String gpsLon;
    private int bussiessType;
    private String contactName;
    private String updateTime;
    private String createBy;
    private String createTime;
    private String cateId;
    private String isTop;
    private String isOn_dictText;
    private String gpsLat;
    private String sysOrgCode;
    private String isEnterprise;
    private String contactPhone;
    private boolean isSelect;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPartsType() {
        return partsType;
    }

    public void setPartsType(String partsType) {
        this.partsType = partsType;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(int isPerson) {
        this.isPerson = isPerson;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIsOn() {
        return isOn;
    }

    public void setIsOn(int isOn) {
        this.isOn = isOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsTop_dictText() {
        return isTop_dictText;
    }

    public void setIsTop_dictText(String isTop_dictText) {
        this.isTop_dictText = isTop_dictText;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIsTalk() {
        return isTalk;
    }

    public void setIsTalk(String isTalk) {
        this.isTalk = isTalk;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpsLon() {
        return TextUtils.isEmpty(gpsLon)?0.0d:Double.valueOf(gpsLon);
    }

    public void setGpsLon(String gpsLon) {
        this.gpsLon = gpsLon;
    }

    public int getBussiessType() {
        return bussiessType;
    }

    public void setBussiessType(int bussiessType) {
        this.bussiessType = bussiessType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getIsOn_dictText() {
        return isOn_dictText;
    }

    public void setIsOn_dictText(String isOn_dictText) {
        this.isOn_dictText = isOn_dictText;
    }

    public double getGpsLat() {
        return TextUtils.isEmpty(gpsLat)?0.0d:Double.valueOf(gpsLat);
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getIsEnterprise() {
        return isEnterprise;
    }

    public void setIsEnterprise(String isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
