package com.example.mechanicalapp.ui.data;

import java.util.List;

public class EngListLetterBean extends  NetData{


    /**
     * success : true
     * result : [[{"key":"A"},{"data":[]}],[{"key":"B"},{"data":[]}],[{"key":"C"},{"data":[]}],[{"key":"D"},{"data":[]}],[{"key":"E"},{"data":[]}],[{"key":"F"},{"data":[]}],[{"key":"G"},{"data":[]}],[{"key":"H"},{"data":[{"id":"1340957287563419649","createBy":"admin","createTime":"2020-12-21 17:48:26","updateBy":"admin","updateTime":"2020-12-21 17:48:26","sysOrgCode":"A01A03","headPicture":null,"name":"Huang ziping","repairFactoryId":null,"repairFactoryName":null,"phone":"15013059002","repairNum":null,"repairAge":null,"post":null,"userId":"1340957289929007105","engineerImId":null}]}],[{"key":"I"},{"data":[]}],[{"key":"J"},{"data":[]}],[{"key":"K"},{"data":[]}],[{"key":"L"},{"data":[{"id":"5","createBy":"admin","createTime":"2020-10-14 23:59:38","updateBy":"admin","updateTime":"2020-10-16 21:25:36","sysOrgCode":"A01A03","headPicture":"temp/timg22_1602691158438.jpg","name":"龙哥哥","repairFactoryId":"1","repairFactoryName":"维修厂1","phone":"16620164051","repairNum":222,"repairAge":22,"post":"2","userId":"1","engineerImId":null}]}],[{"key":"M"},{"data":[]}],[{"key":"N"},{"data":[]}],[{"key":"O"},{"data":[]}],[{"key":"P"},{"data":[]}],[{"key":"Q"},{"data":[]}],[{"key":"R"},{"data":[]}],[{"key":"S"},{"data":[]}],[{"key":"T"},{"data":[]}],[{"key":"U"},{"data":[]}],[{"key":"V"},{"data":[]}],[{"key":"W"},{"data":[]}],[{"key":"X"},{"data":[]}],[{"key":"Y"},{"data":[]}],[{"key":"Z"},{"data":[]}]]
     * timestamp : 1608716933065
     */

    private boolean success;
    private long timestamp;
    private List<List<EngLetterParentData>> result;

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

    public List<List<EngLetterParentData>> getResult() {
        return result;
    }

    public void setResult(List<List<EngLetterParentData>> result) {
        this.result = result;
    }

}
