package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class FactoryCommentData implements Serializable {

    /**
     * id : 1352528286881685506
     * createBy : 13751773402
     * createTime : 2021-01-22 16:07:27
     * updateBy : null
     * updateTime : null
     * sysOrgCode : null
     * customerId : null
     * customerName : yz
     * customerPhone : 13333333
     * repairFactoryId : 1
     * repairFactoryName : null
     * commentContent : 4分好评
     * orderId : 1340948775642931201
     * orderNum : 120201221171436360303
     * starLevel : 4
     * starLevelName : null
     */

    private String id;
    private String createBy;
    private String createTime;
    private String customerHeadPic;
    private String customerName;
    private String customerPhone;
    private String repairFactoryId;
    private String commentContent;
    private String orderId;
    private String orderNum;
    private float starLevel;

    public String getCustomerHeadPic() {
        return customerHeadPic;
    }

    public void setCustomerHeadPic(String customerHeadPic) {
        this.customerHeadPic = customerHeadPic;
    }

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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getRepairFactoryId() {
        return repairFactoryId;
    }

    public void setRepairFactoryId(String repairFactoryId) {
        this.repairFactoryId = repairFactoryId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public float getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(float starLevel) {
        this.starLevel = starLevel;
    }
}
