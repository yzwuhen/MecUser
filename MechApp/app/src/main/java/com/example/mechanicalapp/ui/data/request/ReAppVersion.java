package com.example.mechanicalapp.ui.data.request;

import java.io.Serializable;

public class ReAppVersion implements Serializable {

    /**
     * appType :
     * content :
     * createBy :
     * createTime :
     * downUrl :
     * id :
     * isUpdate :
     * mobileType :
     * sysOrgCode :
     * updateBy :
     * updateTime :
     * version :
     */

    private String appType;
    private String mobileType;
    private String version;
    private String id;
    private String isUpdate;
    private String downUrl;

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }
}
