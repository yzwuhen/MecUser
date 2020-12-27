package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class HotCodeData implements Serializable {

    /**
     * isSystem_dictText : 是
     * type_dictText : 首页-机械租赁
     * updateTime : null
     * type : 0
     * userId : null
     * isSystem : 1
     * createBy : admin
     * searchTime : 10
     * createTime : 2020-12-10 14:29:03
     * updateBy : null
     * name : 挖掘机
     * sysOrgCode : A01A03
     * id : 1336920847046270978
     */

    private String isSystem_dictText;
    private String type_dictText;
    private String type;
    private String userId;
    private String isSystem;
    private String createBy;
    private int searchTime;
    private String createTime;
    private String name;
    private String sysOrgCode;
    private String id;

    public String getIsSystem_dictText() {
        return isSystem_dictText;
    }

    public void setIsSystem_dictText(String isSystem_dictText) {
        this.isSystem_dictText = isSystem_dictText;
    }

    public String getType_dictText() {
        return type_dictText;
    }

    public void setType_dictText(String type_dictText) {
        this.type_dictText = type_dictText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(int searchTime) {
        this.searchTime = searchTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
