package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class ReportData implements Serializable {

    /**
     * createBy : admin
     * createTime : 2020-11-25 17:08:19
     * updateBy : null
     * name : 涉嫌国家言论
     * sysOrgCode : A01A03
     * updateTime : null
     * id : 1331525108648415233
     */

    private String createBy;
    private String createTime;
    private Object updateBy;
    private String name;
    private String sysOrgCode;
    private Object updateTime;
    private String id;

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

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
