package com.example.mechanicalapp.ui.data;

public class OrderDetailsBean  extends NetData{


    /**
     * success : true
     * result : {"id":"1328357286455894018","createBy":"13751773402","createTime":"2020-11-16 23:20:31","updateBy":null,"updateTime":null,"sysOrgCode":"A02","repairFactoryId":null,"repairFactoryName":"锅碗瓢盆","repairFactoryAddress":"广州市海珠区","orderNum":null,"repairType":null,"repairTypeName":null,"orderSum":null,"payTime":null,"payType":null,"payTypeName":null,"status":"0","statusName":null,"progress":null,"progressName":null,"repairId":null,"repairName":null,"customerId":null,"customerName":"你现在在","customerPhone":"13333","productId":null,"productModel":"awd-663","productModelId":"1326574064199434242","productType":"挖掘机","productTypeId":"1321476604976406530","productBrandId":"1321490471452721153","productBrand":"八达重工","orderDesc":"你现在在","receiveTime":null,"reachTime":null,"startRepairTime":null,"finishedRepairTime":null,"engineerIds":null,"adress":"广东省深圳市 宝安区","lng":"113.939388","lat":"22.681693","companyName":null,"city":null}
     * timestamp : 1606057995580
     */

    private OrderData result;

    public OrderData getResult() {
        return result;
    }

    public void setResult(OrderData result) {
        this.result = result;
    }
}
