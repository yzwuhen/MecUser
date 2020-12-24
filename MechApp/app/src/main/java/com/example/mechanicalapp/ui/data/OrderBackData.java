package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class OrderBackData implements Serializable {

    /**
     * id : 1341922782220431362
     * createBy : 13751773402
     * createTime : 2020-12-24 09:44:58
     * updateBy : null
     * updateTime : null
     * sysOrgCode : null
     * mecOrderId : 020201222181448578975
     * mecProductSkuId : null
     * backReason : ......11
     * imgs : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/735fe0c9-dcaa-4f54-bde6-4918a822c731_1608774146255.bin
     * state : 0
     * statusName : 售后中
     * applyUser : 13886943851
     * applyPhone : 13886943851
     * businessId : 1
     * applyTime : 2020-12-24 09:44:58
     * areaId : null
     * backAddress : null
     * backPersonName : null
     * backPersonPhone : null
     */

    private String id;
    private String createBy;
    private String createTime;
    private String mecOrderId;
    private String backReason;
    private String imgs;
    private String state;
    private String statusName;
    private String applyUser;
    private String applyPhone;
    private String businessId;
    private String applyTime;

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

    public String getMecOrderId() {
        return mecOrderId;
    }

    public void setMecOrderId(String mecOrderId) {
        this.mecOrderId = mecOrderId;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyPhone() {
        return applyPhone;
    }

    public void setApplyPhone(String applyPhone) {
        this.applyPhone = applyPhone;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
