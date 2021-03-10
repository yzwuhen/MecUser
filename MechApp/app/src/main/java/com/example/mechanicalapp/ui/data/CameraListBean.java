package com.example.mechanicalapp.ui.data;

import java.util.List;

public class CameraListBean extends NetData {

    /**
     * success : true
     * result : [{"id":"1325306930987204609","createBy":"admin","createTime":"2020-11-08 13:19:30","updateBy":"wxc","updateTime":"2021-03-01 11:02:57","sysOrgCode":"A01A03","name":"摄像头22","webcamNum":"sfsdfsfs","status":"0","isOnline":"离线","repairFactoryId":"1332262998391255042","repairFactoryName":"维修厂1","checkCode":"","webcamAreaId":"1325262509709123586","webcamAreaName":"维修区1","webcamAreaChannelId":"1325264156229296129","channelNo":"1","channelName":"通道1","webcamAreaChannelName":"","serialNum":"E82901339","webcamUrl":"","accessToken":"at.8by79blt7c0dubo956wgsmihcpjzttmo-4n69dhugvi-0cicct3-y2yzyrcbd"}]
     * timestamp : 1615341806605
     */

    private List<CameraListData> result;

    public List<CameraListData> getResult() {
        return result;
    }

    public void setResult(List<CameraListData> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1325306930987204609
         * createBy : admin
         * createTime : 2020-11-08 13:19:30
         * updateBy : wxc
         * updateTime : 2021-03-01 11:02:57
         * sysOrgCode : A01A03
         * name : 摄像头22
         * webcamNum : sfsdfsfs
         * status : 0
         * isOnline : 离线
         * repairFactoryId : 1332262998391255042
         * repairFactoryName : 维修厂1
         * checkCode :
         * webcamAreaId : 1325262509709123586
         * webcamAreaName : 维修区1
         * webcamAreaChannelId : 1325264156229296129
         * channelNo : 1
         * channelName : 通道1
         * webcamAreaChannelName :
         * serialNum : E82901339
         * webcamUrl :
         * accessToken : at.8by79blt7c0dubo956wgsmihcpjzttmo-4n69dhugvi-0cicct3-y2yzyrcbd
         */

        private String id;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String sysOrgCode;
        private String name;
        private String webcamNum;
        private String status;
        private String isOnline;
        private String repairFactoryId;
        private String repairFactoryName;
        private String checkCode;
        private String webcamAreaId;
        private String webcamAreaName;
        private String webcamAreaChannelId;
        private String channelNo;
        private String channelName;
        private String webcamAreaChannelName;
        private String serialNum;
        private String webcamUrl;
        private String accessToken;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWebcamNum() {
            return webcamNum;
        }

        public void setWebcamNum(String webcamNum) {
            this.webcamNum = webcamNum;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(String isOnline) {
            this.isOnline = isOnline;
        }

        public String getRepairFactoryId() {
            return repairFactoryId;
        }

        public void setRepairFactoryId(String repairFactoryId) {
            this.repairFactoryId = repairFactoryId;
        }

        public String getRepairFactoryName() {
            return repairFactoryName;
        }

        public void setRepairFactoryName(String repairFactoryName) {
            this.repairFactoryName = repairFactoryName;
        }

        public String getCheckCode() {
            return checkCode;
        }

        public void setCheckCode(String checkCode) {
            this.checkCode = checkCode;
        }

        public String getWebcamAreaId() {
            return webcamAreaId;
        }

        public void setWebcamAreaId(String webcamAreaId) {
            this.webcamAreaId = webcamAreaId;
        }

        public String getWebcamAreaName() {
            return webcamAreaName;
        }

        public void setWebcamAreaName(String webcamAreaName) {
            this.webcamAreaName = webcamAreaName;
        }

        public String getWebcamAreaChannelId() {
            return webcamAreaChannelId;
        }

        public void setWebcamAreaChannelId(String webcamAreaChannelId) {
            this.webcamAreaChannelId = webcamAreaChannelId;
        }

        public String getChannelNo() {
            return channelNo;
        }

        public void setChannelNo(String channelNo) {
            this.channelNo = channelNo;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getWebcamAreaChannelName() {
            return webcamAreaChannelName;
        }

        public void setWebcamAreaChannelName(String webcamAreaChannelName) {
            this.webcamAreaChannelName = webcamAreaChannelName;
        }

        public String getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(String serialNum) {
            this.serialNum = serialNum;
        }

        public String getWebcamUrl() {
            return webcamUrl;
        }

        public void setWebcamUrl(String webcamUrl) {
            this.webcamUrl = webcamUrl;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }
    }
}
