package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class StoreChildBean implements Serializable {
    /**
     * id : 1306973751067000833
     * createBy : admin
     * createTime : 2020-09-18 23:09:59
     * updateBy : null
     * updateTime : null
     * sysOrgCode : A01
     * pid : 1306972861010526210
     * hasChild : 0
     * name : 苹果
     * icon : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/所发生的_1603726420340.jpg
     */

    private String id;
    private String createBy;
    private String createTime;
    private Object updateBy;
    private Object updateTime;
    private String sysOrgCode;
    private String pid;
    private String hasChild;
    private String name;
    private String icon;

    public String getId() {
        return id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public String getPid() {
        return pid;
    }

    public String getHasChild() {
        return hasChild;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
