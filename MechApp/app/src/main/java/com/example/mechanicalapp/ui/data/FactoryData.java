package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class FactoryData implements Serializable {

    /**
     * businessLicense : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/448318f3-c7d5-4fdf-9243-af159deaa606_1606471217052.jpg
     * isApprove_dictText : null
     * city : 广州市
     * companyName : 广州一帆风顺维修厂
     * repaireType : 挖掘机子类
     * updateBy : null
     * id : 1332262998391255042
     * isTop_dictText : null
     * lat : 23.131704
     * introduction : 添加维修厂测试，添加维修厂测试
     * componentType : 配件1
     * responsePersonName : null
     * address : 广州市天河区天河路228号正佳广场6楼
     * lng : 113.327011
     * star : 3
     * updateTime : 2020-12-03 00:33:57
     * userId : null
     * isApprove : null
     * createBy : null
     * companyId : null
     * viewNum : 1
     * factoryPicture : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/34b653f1-d531-4dc3-bd7d-4d2fdd7fbe07_1606471224514.jpg
     * responsePersonId_dictText : null
     * createTime : 2020-11-27 18:00:26
     * responsePersonId : null
     * isTop : null
     * name : 锅碗瓢盆
     * sysOrgCode : null
     * responsePersonPhone : 13886943851
     * userId_dictText : null
     */

    private String businessLicense;
    private Object isApprove_dictText;
    private String city;
    private String companyName;
    private String repaireType;
    private Object updateBy;
    private String id;
    private Object isTop_dictText;
    private double lat;
    private String introduction;
    private String componentType;
    private Object responsePersonName;
    private String address;
    private double lng;
    private float star;
    private String updateTime;
    private Object userId;
    private Object isApprove;
    private Object createBy;
    private Object companyId;
    private int viewNum;
    private String factoryPicture;
    private Object responsePersonId_dictText;
    private String createTime;
    private Object responsePersonId;
    private Object isTop;
    private String name;
    private Object sysOrgCode;
    private String responsePersonPhone;
    private Object userId_dictText;

    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public Object getIsApprove_dictText() {
        return isApprove_dictText;
    }

    public void setIsApprove_dictText(Object isApprove_dictText) {
        this.isApprove_dictText = isApprove_dictText;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRepaireType() {
        return repaireType;
    }

    public void setRepaireType(String repaireType) {
        this.repaireType = repaireType;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getIntroduction() {
        return TextUtils.isEmpty(introduction)?"":introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Object getResponsePersonName() {
        return responsePersonName;
    }

    public void setResponsePersonName(Object responsePersonName) {
        this.responsePersonName = responsePersonName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Object isApprove) {
        this.isApprove = isApprove;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public Object getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public String getFactoryPicture() {
        return factoryPicture;
    }

    public void setFactoryPicture(String factoryPicture) {
        this.factoryPicture = factoryPicture;
    }

    public Object getResponsePersonId_dictText() {
        return responsePersonId_dictText;
    }

    public void setResponsePersonId_dictText(Object responsePersonId_dictText) {
        this.responsePersonId_dictText = responsePersonId_dictText;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Object getResponsePersonId() {
        return responsePersonId;
    }

    public void setResponsePersonId(Object responsePersonId) {
        this.responsePersonId = responsePersonId;
    }

    public Object getIsTop() {
        return isTop;
    }

    public void setIsTop(Object isTop) {
        this.isTop = isTop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(Object sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getResponsePersonPhone() {
        return responsePersonPhone;
    }

    public void setResponsePersonPhone(String responsePersonPhone) {
        this.responsePersonPhone = responsePersonPhone;
    }

    public Object getUserId_dictText() {
        return userId_dictText;
    }

    public void setUserId_dictText(Object userId_dictText) {
        this.userId_dictText = userId_dictText;
    }
}
