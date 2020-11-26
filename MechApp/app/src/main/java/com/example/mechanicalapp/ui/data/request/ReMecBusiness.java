package com.example.mechanicalapp.ui.data.request;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * 出售求购 request
 */
public class ReMecBusiness implements Serializable {


    /**
     * address :
     * brandId :
     * brandName :
     * briefDesc :
     * bussiessType :
     * cateId :
     * cateName :
     * city :
     * contactName :
     * contactPhone :
     * createBy :
     * createTime :
     * facDate :
     * gpsLat :
     * gpsLon :
     * id :
     * isEnterprise :
     * isNew :
     * isOn :
     * isPerson :
     * isTop :
     * modelId :
     * modelName :
     * orderTime :
     * paymentType :
     * pic :
     * price :
     * sysOrgCode :
     * tittle :
     * updateBy :
     * updateTime :
     * workTime :
     */

    private String address;
    private String brandId;
    private String brandName;
    private String briefDesc;
    private String bussiessType;
    private String cateId;
    private String cateName;
    private String city;
    private String contactName;
    private String contactPhone;
    private String createBy;
    private String createTime;
    private String facDate;
    private String gpsLat;
    private String gpsLon;
    private String id;
    private String isEnterprise;
    private String isNew;
    private String isOn;
    private String isPerson;
    private String isTop;
    private String modelId;
    private String modelName;
    private String orderTime;
    private String paymentType;
    private String pic;
    private String price;
    private String sysOrgCode;
    private String tittle;
    private String updateBy;
    private String updateTime;
    private String workTime;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public String getBussiessType() {
        return bussiessType;
    }

    public void setBussiessType(String bussiessType) {
        this.bussiessType = bussiessType;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getFacDate() {
        return facDate;
    }

    public void setFacDate(String facDate) {
        this.facDate = facDate;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(String gpsLon) {
        this.gpsLon = gpsLon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsEnterprise() {
        return isEnterprise;
    }

    public void setIsEnterprise(String isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getIsOn() {
        return isOn;
    }

    public void setIsOn(String isOn) {
        this.isOn = isOn;
    }

    public String getIsPerson() {
        return isPerson;
    }

    public void setIsPerson(String isPerson) {
        this.isPerson = isPerson;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPic() {
        return TextUtils.isEmpty(pic)?"":pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
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

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
}
