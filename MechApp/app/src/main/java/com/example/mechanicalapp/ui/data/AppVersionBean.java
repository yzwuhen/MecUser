package com.example.mechanicalapp.ui.data;

import com.example.mechanicalapp.ui.data.request.ReAppVersion;

public class AppVersionBean extends  NetData {

    /**
     * success : true
     * result : {"id":"1357956562919899137","createBy":"admin","createTime":"2021-02-06 15:37:29","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","version":"1.3.3","mobileType":"1","appType":"2","isUpdate":"0","content":null,"downUrl":null}
     * timestamp : 1614133048228
     */

    private boolean success;
    private ReAppVersion result;
    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ReAppVersion getResult() {
        return result;
    }

    public void setResult(ReAppVersion result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
