package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

/**
 * 审核日志
 */
public class OrderBackLogBean implements Serializable {


    /**
     * id : 1343827480519143425
     * createBy : 13751773402
     * createTime : 2020-12-29 15:53:33
     * updateBy : null
     * updateTime : null
     * sysOrgCode : null
     * mecOrderBackId : 1343827480334594050
     * handleUserId : 888
     * handleUserName : admin
     * handleNode : 同意售后
     * nextHandleNode : 待买家回寄商品
     * nextNodeId : back_product
     * isFinished : 0
     * actionCode : seller_agree
     * isHandling : 1
     * isTemplate : 0
     * handleTime : null
     * isCheckOk : null
     * checkResult : null
     * refusedReason : null
     * orderNum : 2
     * params : {"id":"1343827480519143425","status":"1"}
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String mecOrderBackId;
    private String handleUserId;
    private String handleUserName;
    private String handleNode;
    private String nextHandleNode;
    private String nextNodeId;
    private String isFinished;
    private String actionCode;
    private String isHandling;
    private String isTemplate;
    private String handleTime;
    private String isCheckOk;
    private String checkResult;
    private String refusedReason;
    private String orderNum;
    private ParamsBean params;

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

    public String getMecOrderBackId() {
        return mecOrderBackId;
    }

    public void setMecOrderBackId(String mecOrderBackId) {
        this.mecOrderBackId = mecOrderBackId;
    }

    public String getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(String handleUserId) {
        this.handleUserId = handleUserId;
    }

    public String getHandleUserName() {
        return handleUserName;
    }

    public void setHandleUserName(String handleUserName) {
        this.handleUserName = handleUserName;
    }

    public String getHandleNode() {
        return handleNode;
    }

    public void setHandleNode(String handleNode) {
        this.handleNode = handleNode;
    }

    public String getNextHandleNode() {
        return nextHandleNode;
    }

    public void setNextHandleNode(String nextHandleNode) {
        this.nextHandleNode = nextHandleNode;
    }

    public String getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(String nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getIsHandling() {
        return isHandling;
    }

    public void setIsHandling(String isHandling) {
        this.isHandling = isHandling;
    }

    public String getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(String isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
    }

    public String getIsCheckOk() {
        return isCheckOk;
    }

    public void setIsCheckOk(String isCheckOk) {
        this.isCheckOk = isCheckOk;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getRefusedReason() {
        return refusedReason;
    }

    public void setRefusedReason(String refusedReason) {
        this.refusedReason = refusedReason;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public ParamsBean getParams() {
        return params;
    }

    public void setParams(ParamsBean params) {
        this.params = params;
    }

    public static class ParamsBean {
        /**
         * id : 1343827480519143425
         * status : 1
         */

        private String id;
        private String status;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
