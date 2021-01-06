package com.example.mechanicalapp.ui.data;

import java.util.List;

public class LookEvaluateBean extends NetData {


    /**
     * success : true
     * result : [{"id":"1344575215706841089","createBy":"13751773402","createTime":"2020-12-31 17:24:47","updateBy":null,"updateTime":null,"sysOrgCode":null,"mecProdId":null,"mecProdTitle":null,"mecProductSkuId":"16061453525181615290","mecProductSkuName":"红,M","content":"12","star":"5","commentUserId":null,"commentUserPhone":null,"commentUserName":null,"commentUserHeader":null,"mecOrderId":"020201231103803899930","mecOrderItemId":"1331173915724132353","total":null,"goodCount":null,"midCount":null,"badCount":null,"partNum":1,"prices":234,"totalMoney":234,"freight":0},{"id":"1344575215811698690","createBy":"13751773402","createTime":"2020-12-31 17:24:47","updateBy":null,"updateTime":null,"sysOrgCode":null,"mecProdId":null,"mecProdTitle":null,"mecProductSkuId":"16061453525182258112","mecProductSkuName":"黄,X","content":"34","star":"5","commentUserId":null,"commentUserPhone":null,"commentUserName":null,"commentUserHeader":null,"mecOrderId":"020201231103803899930","mecOrderItemId":"1331173915724132353","total":null,"goodCount":null,"midCount":null,"badCount":null,"partNum":1,"prices":234,"totalMoney":234,"freight":0}]
     * timestamp : 1609851479077
     */

    private boolean success;
    private long timestamp;
    private List<EvaluateData> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<EvaluateData> getResult() {
        return result;
    }

    public void setResult(List<EvaluateData> result) {
        this.result = result;
    }

}
