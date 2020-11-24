package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class SkuListData implements Serializable {
    /**
     * id : 16038070877750329019
     * createBy : admin
     * createTime : 2020-10-27 21:58:17
     * updateBy : admin
     * updateTime : 2020-10-29 19:03:42
     * sysOrgCode : A01A03
     * mecProductId : 4
     * mecProductName : 苹果999
     * name : 颜色:红,尺码:L
     * isDefault : null
     * isActive : N
     * stock : 100
     * marketPrice : null
     * price : 100
     * sn : null
     * picture : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String mecProductId;
    private String mecProductName;
    private String name;
    private Object isDefault;
    private String isActive;
    private int stock;
    private Object marketPrice;
    private int price;
    private Object sn;
    private String picture;

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

    public String getMecProductId() {
        return mecProductId;
    }

    public void setMecProductId(String mecProductId) {
        this.mecProductId = mecProductId;
    }

    public String getMecProductName() {
        return mecProductName;
    }

    public void setMecProductName(String mecProductName) {
        this.mecProductName = mecProductName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Object isDefault) {
        this.isDefault = isDefault;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Object getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Object marketPrice) {
        this.marketPrice = marketPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object getSn() {
        return sn;
    }

    public void setSn(Object sn) {
        this.sn = sn;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
