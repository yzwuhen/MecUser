package com.example.mechanicalapp.ui.data;

import java.util.List;

public class EnMsgBean extends NetData {

    /**
     * success : true
     * result : [{"post_dictText":"中级工程师","updateTime":"2021-01-21 16:13:55","userId":"1","headPicture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/3c546ba4-7a64-4c47-ba9a-dcf184411b68_1611216832452.png","repairFactoryName":"锅碗瓢盆","createBy":"admin","post":"2","createTime":"2020-10-14 23:59:38","updateBy":"admin","phone":"16620164051","repairNum":222,"repairFactoryId":"1332262998391255042","name":"龙哥哥","sysOrgCode":"A01A03","id":"5","engineerImId":null,"repairAge":22}]
     * timestamp : 1611569056771
     */

    private List<EngineerData> result;

    public List<EngineerData> getResult() {
        return result;
    }

    public void setResult(List<EngineerData> result) {
        this.result = result;
    }


}
