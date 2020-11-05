package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class StoreLeftBean implements Serializable {
    /**
     * id : 1306972861010526210
     * createBy : admin
     * createTime : 2020-09-18 23:06:27
     * updateBy : admin
     * updateTime : 2020-09-18 23:08:14
     * sysOrgCode : A01
     * pid : 0
     * hasChild : 1
     * name : 水果
     * icon : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/所发生的_1603726420340.jpg
     * children : [{"id":"1306973751067000833","createBy":"admin","createTime":"2020-09-18 23:09:59","updateBy":null,"updateTime":null,"sysOrgCode":"A01","pid":"1306972861010526210","hasChild":"0","name":"苹果","icon":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/所发生的_1603726420340.jpg"},{"id":"1320751129165508610","createBy":"admin","createTime":"2020-10-26 23:36:22","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","pid":"1306972861010526210","hasChild":null,"name":"香蕉","icon":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/所发生的_1603726420340.jpg"},{"id":"1320751194684731393","createBy":"admin","createTime":"2020-10-26 23:36:38","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","pid":"1306972861010526210","hasChild":null,"name":"例子","icon":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/所发生的_1603726420340.jpg"},{"id":"1320751245138014209","createBy":"admin","createTime":"2020-10-26 23:36:50","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","pid":"1306972861010526210","hasChild":null,"name":"红苹果","icon":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/所发生的_1603726420340.jpg"}]
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String pid;
    private String hasChild;
    private String name;
    private String icon;
    private List<StoreChildBean> children;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getId() {
        return id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public String getUpdateTime() {
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

    public List<StoreChildBean> getChildren() {
        return children;
    }
}
