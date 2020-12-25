package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class PartsOrderData implements Serializable {


    /**
     * isAllocatedstock : 1
     * isAllocatedstock_dictText : 是
     * orderItemList : [{"productSum":234,"thumbnail":null,"quantity":1,"orderId":"020201126102345747564","productSkuImg":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg","freight":null,"weight":null,"updateTime":null,"isBaoyou":null,"skuName":null,"totalSum":234,"createBy":"13751773402","isDelivery":null,"createTime":"2020-11-26 10:23:46","updateBy":null,"price":234,"prodName":"苹果999","sysOrgCode":"A02","id":"1331785689544577025","mecProductSkuId":"16061452639240298040"}]
     * freight : null
     * fee : null
     * createUserPhone : 13751773402
     * orderNum : 20201126102346631412
     * memo : null
     * type_dictText : null
     * createUserName : 13751773402
     * status_dictText : 未支付
     * type : null
     * skuIds : null
     * paymentType : null
     * completeDate : null
     * skuName : null
     * picUrl : null
     * receiverId : 1330423821953454081
     * receiverPhone : 13336
     * updateBy : null
     * statusName : 待支付
     * id : 020201126102345747564
     * sn : null
     * receiverAreaId : 450124
     * paymentTime : null
     * orderTitle : null
     * amount : 234
     * quantity : 1
     * shippingName : null
     * receiverName : 默写
     * paymentTypeName : null
     * weight : 0
     * updateTime : null
     * tax : null
     * receiverAddress : 额我问了一下
     * receiveTime : null
     * createBy : 13751773402
     * productAmount : 234
     * createTime : 2020-11-26 10:23:46
     * expire : 2020-11-26 10:28:46
     * sysOrgCode : A02
     * receiverAreaName : 广西壮族自治区,南宁市,马山县
     * paymentType_dictText : null
     * status : 0
     */

    private String status_dictText;
    private String orderNum;
    private String statusName;
    private String id;
    private double amount;
    private int quantity;
    private String createBy;
    private String createTime;
    private int status;
    private String isBackOrder;
    private List<PartsOrderGoodsList> orderItemList;
    private String deliverycorpCode;
    private String trackingNo;

    public String getDeliverycorpCode() {
        return deliverycorpCode;
    }

    public String getStatus_dictText() {
        return status_dictText;
    }

    public String getTrackingNo() {
        return trackingNo;
    }


    public String getIsBackOrder() {
        return isBackOrder;
    }


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<PartsOrderGoodsList> getOrderItemList() {
        return orderItemList;
    }

}
