package com.example.mechanicalapp.ui.data;

import java.util.List;

public class SysMsgBean extends NetData {

    /**
     * success : true
     * result : [{"id":"1351157490405888001","createBy":"admin","createTime":"2021-01-18 21:20:24","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","title":"个人公告","content":"<p>公告怪怪的<\/p>","type":"2","isRead":null}]
     * timestamp : 1611649203449
     */

    private List<SysMsgData> result;

    public List<SysMsgData> getResult() {
        return result;
    }

    public void setResult(List<SysMsgData> result) {
        this.result = result;
    }

}
