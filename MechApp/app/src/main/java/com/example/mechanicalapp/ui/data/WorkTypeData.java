package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class WorkTypeData implements Serializable {

    /**
     * id : 1327630623413633026
     * createBy : admin
     * createTime : 2020-11-14 23:13:01
     * updateBy : null
     * updateTime : null
     * sysOrgCode : A01A03
     * cateName : 汽车吊
     * ishot : null
     * orderNum : null
     * pid : 1327629521653858305
     * hasChild : 0
     */

    private String id;
    private String createBy;
    private String createTime;
    private Object updateBy;
    private Object updateTime;
    private String sysOrgCode;
    private String cateName;
    private Object ishot;
    private Object orderNum;
    private String pid;
    private String hasChild;

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

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Object getIshot() {
        return ishot;
    }

    public void setIshot(Object ishot) {
        this.ishot = ishot;
    }

    public Object getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Object orderNum) {
        this.orderNum = orderNum;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }
}
