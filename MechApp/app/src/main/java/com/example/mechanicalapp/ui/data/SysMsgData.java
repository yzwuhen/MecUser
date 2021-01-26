package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class SysMsgData implements Serializable {

    /**
     * id : 1351157490405888001
     * createBy : admin
     * createTime : 2021-01-18 21:20:24
     * updateBy : null
     * updateTime : null
     * sysOrgCode : A01A03
     * title : 个人公告
     * content : <p>公告怪怪的</p>
     * type : 2
     * isRead : null
     */

    private String id;
    private String createBy;
    private String createTime;
    private String sysOrgCode;
    private String title;
    private String content;
    private String type;
    private String isRead;

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

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
}
