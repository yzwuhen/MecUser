package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class FactoryData implements Serializable {
    /**
     * businessLicense : null
     * componentType : 234
     * address : 234
     * lng : null
     * updateTime : null
     * userId : null
     * isApprove : null
     * createBy : admin
     * repaireType : 234
     * factoryPicture : null
     * createTime : 2020-10-14 20:09:31
     * updateBy : null
     * responsePersonId : 234
     * name : 维修厂1
     * sysOrgCode : A01A03
     * responsePersonPhone : 234
     * id : 1
     * lat : null
     * introduction : null
     */

    private Object businessLicense;
    private String componentType;
    private String address;
    private Object lng;
    private String updateTime;
    private String userId;
    private Object isApprove;
    private String createBy;
    private String repaireType;
    private String factoryPicture;
    private String createTime;
    private String updateBy;
    private String responsePersonId;
    private String name;
    private String sysOrgCode;
    private String responsePersonPhone;
    private String id;
    private Object lat;
    private String introduction;
    private String companyId;

    private boolean isSelect;

    private String gpsLat;
    private String gpsLon;

    public Double getGpsLon() {
        return TextUtils.isEmpty(gpsLon)?0.0d:Double.valueOf(gpsLon);
    }

    public Double getGpsLat() {
        return TextUtils.isEmpty(gpsLat)?0.0d:Double.valueOf(gpsLat);
    }

    public boolean isSelect() {
        return isSelect;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Object getBusinessLicense() {
        return businessLicense;
    }

    public String getComponentType() {
        return componentType;
    }

    public String getAddress() {
        return address;
    }

    public Object getLng() {
        return lng;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public Object getIsApprove() {
        return isApprove;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getRepaireType() {
        return repaireType;
    }

    public String getFactoryPicture() {
        return factoryPicture;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getResponsePersonId() {
        return responsePersonId;
    }

    public String getName() {
        return name;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public String getResponsePersonPhone() {
        return responsePersonPhone;
    }

    public String getId() {
        return id;
    }

    public Object getLat() {
        return lat;
    }

    public String getIntroduction() {
        return TextUtils.isEmpty(introduction)?"暂无":introduction;
    }
}
