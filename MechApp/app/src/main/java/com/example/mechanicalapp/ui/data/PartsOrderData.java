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

    private String isAllocatedstock;
    private String isAllocatedstock_dictText;
    private Object freight;
    private Object fee;
    private String createUserPhone;
    private String orderNum;
    private Object memo;
    private Object type_dictText;
    private String createUserName;
    private String status_dictText;
    private Object type;
    private Object skuIds;
    private Object paymentType;
    private Object completeDate;
    private String skuName;
    private String picUrl;
    private String receiverId;
    private String receiverPhone;
    private Object updateBy;
    private String statusName;
    private String id;
    private Object sn;
    private String receiverAreaId;
    private Object paymentTime;
    private String orderTitle;
    private double amount;
    private int quantity;
    private Object shippingName;
    private String receiverName;
    private Object paymentTypeName;
    private int weight;
    private Object updateTime;
    private Object tax;
    private String receiverAddress;
    private Object receiveTime;
    private String createBy;
    private int productAmount;
    private String createTime;
    private String expire;
    private String sysOrgCode;
    private String receiverAreaName;
    private String paymentType_dictText;
    private int status;
    private List<PartsOrderGoodsList> orderItemList;

    public String getIsAllocatedstock() {
        return isAllocatedstock;
    }

    public void setIsAllocatedstock(String isAllocatedstock) {
        this.isAllocatedstock = isAllocatedstock;
    }

    public String getIsAllocatedstock_dictText() {
        return isAllocatedstock_dictText;
    }

    public void setIsAllocatedstock_dictText(String isAllocatedstock_dictText) {
        this.isAllocatedstock_dictText = isAllocatedstock_dictText;
    }

    public Object getFreight() {
        return freight;
    }

    public void setFreight(Object freight) {
        this.freight = freight;
    }

    public Object getFee() {
        return fee;
    }

    public void setFee(Object fee) {
        this.fee = fee;
    }

    public String getCreateUserPhone() {
        return createUserPhone;
    }

    public void setCreateUserPhone(String createUserPhone) {
        this.createUserPhone = createUserPhone;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Object getMemo() {
        return memo;
    }

    public void setMemo(Object memo) {
        this.memo = memo;
    }

    public Object getType_dictText() {
        return type_dictText;
    }

    public void setType_dictText(Object type_dictText) {
        this.type_dictText = type_dictText;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getStatus_dictText() {
        return status_dictText;
    }

    public void setStatus_dictText(String status_dictText) {
        this.status_dictText = status_dictText;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(Object skuIds) {
        this.skuIds = skuIds;
    }

    public Object getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Object paymentType) {
        this.paymentType = paymentType;
    }

    public Object getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Object completeDate) {
        this.completeDate = completeDate;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
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

    public Object getSn() {
        return sn;
    }

    public void setSn(Object sn) {
        this.sn = sn;
    }

    public String getReceiverAreaId() {
        return receiverAreaId;
    }

    public void setReceiverAreaId(String receiverAreaId) {
        this.receiverAreaId = receiverAreaId;
    }

    public Object getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
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

    public Object getShippingName() {
        return shippingName;
    }

    public void setShippingName(Object shippingName) {
        this.shippingName = shippingName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Object getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(Object paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getTax() {
        return tax;
    }

    public void setTax(Object tax) {
        this.tax = tax;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Object getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Object receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpire() {
        return expire;
    }
    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getReceiverAreaName() {
        return receiverAreaName;
    }

    public String getPaymentType_dictText() {
        return paymentType_dictText;
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
