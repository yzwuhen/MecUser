package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class CommentData implements Serializable {

    /**
     * id : 10
     * createBy : admin
     * createTime : 2020-09-22 21:24:35
     * updateBy : admin
     * updateTime : 2020-09-22 21:27:02
     * sysOrgCode : A01
     * mecProdId : 4
     * mecProdTitle : 666
     * mecProductSkuId : 2
     * mecProductSkuName : 红色,X
     * content : sfsdfssfsdfssfsdfssfsdfssfsdfs
     * star : 5
     * commentUserId : 1
     * commentUserPhone : 13685487458
     * commentUserName : 张娜
     * commentUserHeader : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String mecProdId;
    private String mecProdTitle;
    private String mecProductSkuId;
    private String mecProductSkuName;
    private String content;
    private float star;
    private String commentUserId;
    private String commentUserPhone;
    private String commentUserName;
    private String commentUserHeader;

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

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getMecProdId() {
        return mecProdId;
    }

    public void setMecProdId(String mecProdId) {
        this.mecProdId = mecProdId;
    }

    public String getMecProdTitle() {
        return mecProdTitle;
    }

    public void setMecProdTitle(String mecProdTitle) {
        this.mecProdTitle = mecProdTitle;
    }

    public String getMecProductSkuId() {
        return mecProductSkuId;
    }

    public void setMecProductSkuId(String mecProductSkuId) {
        this.mecProductSkuId = mecProductSkuId;
    }

    public String getMecProductSkuName() {
        return mecProductSkuName;
    }

    public void setMecProductSkuName(String mecProductSkuName) {
        this.mecProductSkuName = mecProductSkuName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserPhone() {
        return commentUserPhone;
    }

    public void setCommentUserPhone(String commentUserPhone) {
        this.commentUserPhone = commentUserPhone;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentUserHeader() {
        return commentUserHeader;
    }

    public void setCommentUserHeader(String commentUserHeader) {
        this.commentUserHeader = commentUserHeader;
    }
}
