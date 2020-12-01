package com.example.mechanicalapp.ui.data;

import java.util.List;

public class MyLookLeaseBean extends NetData {

    /**
     * success : true
     * result : [{"priceUnit_dictText":"元/台班","facDate":"2020-10-18","modelId":"1321491075206004738","city":null,"pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","cateName":"挖掘机子类","isPerson":"1","mecUnit":"2","orderTime":"2020-10-19","updateBy":"admin","briefDesc":"点点滴滴才休息","price":100,"isOn":"1","isNew_dictText":"是","id":"8","isTop_dictText":null,"title":"大臂机械","priceUnit":"1","brandName":"八达重工","gpsLon":"1.22333","address":null,"bussiessType":"1","contactName":"老铁","tenancy":"2","facTime":1,"updateTime":"2020-11-05 20:16:35","isNew":"1","workTime":"2年","modelName":"机械机型1","createBy":"admin","facTime_dictText":"一年以内","createTime":"2020-10-18 08:50:55","cateId":"1323668504007696385","isTop":null,"brandId":"1321490471452721153","gpsLat":"3.122","sysOrgCode":"string","isEnterprise":null,"bussiessType_dictText":"出租","contactPhone":"15035900233"}]
     * timestamp : 1605710085480
     */

    private List<MecLeaseData> result;


    public List<MecLeaseData> getResult() {
        return result;
    }

    public void setResult(List<MecLeaseData> result) {
        this.result = result;
    }


}
