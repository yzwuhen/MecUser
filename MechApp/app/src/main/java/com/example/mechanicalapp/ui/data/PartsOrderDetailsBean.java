package com.example.mechanicalapp.ui.data;

import java.util.List;

public class PartsOrderDetailsBean extends NetData {

    /**
     * success : true
     * result : {"orderDelivery":{"id":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"sysOrgCode":null,"areaId":null,"areaName":null,"address":null,"consignee":null,"shippingMethod":null,"deliveryCorp":null,"trackingNo":null,"freight":null,"phone":null,"memo":null,"deliverycorpCode":null,"deliverycorpUrl":null,"orderId":null},"productList":[{"id":"1331785689544577025","createBy":"13751773402","createTime":"2020-11-26 10:23:46","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderId":"020201126102345747564","prodName":"苹果999","mecProductSkuId":"16061452639240298040","skuName":null,"price":234,"quantity":1,"weight":null,"isDelivery":null,"thumbnail":null,"productSkuImg":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg","isBaoyou":null,"freight":null,"productSum":234,"totalSum":234}],"order":{"id":"020201126102345747564","createBy":"13751773402","createTime":"2020-11-26 10:23:46","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderNum":"20201126102346631412","createUserName":"13751773402","createUserPhone":"13751773402","receiverId":"1330423821953454081","receiverName":"默写","receiverAreaId":"450124","receiverAreaName":"广西壮族自治区,南宁市,马山县","receiverPhone":"13336","receiverAddress":"额我问了一下","receiveTime":null,"freight":null,"tax":null,"fee":null,"productAmount":234,"amount":234,"weight":0,"quantity":1,"memo":null,"isAllocatedstock":"1","paymentType":null,"paymentTime":null,"shippingName":null,"completeDate":null,"expire":"2020-11-26 10:28:46","sn":null,"type":null,"status":"0","statusName":"待支付","paymentTypeName":null,"skuIds":null,"orderItemList":null,"picUrl":null,"orderTitle":null,"skuName":null}}
     * timestamp : 1606707441420
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * orderDelivery : {"id":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"sysOrgCode":null,"areaId":null,"areaName":null,"address":null,"consignee":null,"shippingMethod":null,"deliveryCorp":null,"trackingNo":null,"freight":null,"phone":null,"memo":null,"deliverycorpCode":null,"deliverycorpUrl":null,"orderId":null}
         * productList : [{"id":"1331785689544577025","createBy":"13751773402","createTime":"2020-11-26 10:23:46","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderId":"020201126102345747564","prodName":"苹果999","mecProductSkuId":"16061452639240298040","skuName":null,"price":234,"quantity":1,"weight":null,"isDelivery":null,"thumbnail":null,"productSkuImg":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg","isBaoyou":null,"freight":null,"productSum":234,"totalSum":234}]
         * order : {"id":"020201126102345747564","createBy":"13751773402","createTime":"2020-11-26 10:23:46","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderNum":"20201126102346631412","createUserName":"13751773402","createUserPhone":"13751773402","receiverId":"1330423821953454081","receiverName":"默写","receiverAreaId":"450124","receiverAreaName":"广西壮族自治区,南宁市,马山县","receiverPhone":"13336","receiverAddress":"额我问了一下","receiveTime":null,"freight":null,"tax":null,"fee":null,"productAmount":234,"amount":234,"weight":0,"quantity":1,"memo":null,"isAllocatedstock":"1","paymentType":null,"paymentTime":null,"shippingName":null,"completeDate":null,"expire":"2020-11-26 10:28:46","sn":null,"type":null,"status":"0","statusName":"待支付","paymentTypeName":null,"skuIds":null,"orderItemList":null,"picUrl":null,"orderTitle":null,"skuName":null}
         */

        private OrderDeliveryBean orderDelivery;
        private OrderBean order;
        private List<PartsOrderGoodsList> productList;

        public OrderDeliveryBean getOrderDelivery() {
            return orderDelivery;
        }

        public void setOrderDelivery(OrderDeliveryBean orderDelivery) {
            this.orderDelivery = orderDelivery;
        }

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public List<PartsOrderGoodsList> getProductList() {
            return productList;
        }

        public void setProductList(List<PartsOrderGoodsList> productList) {
            this.productList = productList;
        }

        public static class OrderDeliveryBean {
            /**
             * id : null
             * createBy : null
             * createTime : null
             * updateBy : null
             * updateTime : null
             * sysOrgCode : null
             * areaId : null
             * areaName : null
             * address : null
             * consignee : null
             * shippingMethod : null
             * deliveryCorp : null
             * trackingNo : null
             * freight : null
             * phone : null
             * memo : null
             * deliverycorpCode : null
             * deliverycorpUrl : null
             * orderId : null
             */

            private Object id;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;
            private Object sysOrgCode;
            private Object areaId;
            private Object areaName;
            private Object address;
            private Object consignee;
            private Object shippingMethod;
            private Object deliveryCorp;
            private Object trackingNo;
            private Object freight;
            private Object phone;
            private Object memo;
            private Object deliverycorpCode;
            private Object deliverycorpUrl;
            private Object orderId;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getSysOrgCode() {
                return sysOrgCode;
            }

            public void setSysOrgCode(Object sysOrgCode) {
                this.sysOrgCode = sysOrgCode;
            }

            public Object getAreaId() {
                return areaId;
            }

            public void setAreaId(Object areaId) {
                this.areaId = areaId;
            }

            public Object getAreaName() {
                return areaName;
            }

            public void setAreaName(Object areaName) {
                this.areaName = areaName;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getConsignee() {
                return consignee;
            }

            public void setConsignee(Object consignee) {
                this.consignee = consignee;
            }

            public Object getShippingMethod() {
                return shippingMethod;
            }

            public void setShippingMethod(Object shippingMethod) {
                this.shippingMethod = shippingMethod;
            }

            public Object getDeliveryCorp() {
                return deliveryCorp;
            }

            public void setDeliveryCorp(Object deliveryCorp) {
                this.deliveryCorp = deliveryCorp;
            }

            public Object getTrackingNo() {
                return trackingNo;
            }

            public void setTrackingNo(Object trackingNo) {
                this.trackingNo = trackingNo;
            }

            public Object getFreight() {
                return freight;
            }

            public void setFreight(Object freight) {
                this.freight = freight;
            }

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public Object getMemo() {
                return memo;
            }

            public void setMemo(Object memo) {
                this.memo = memo;
            }

            public Object getDeliverycorpCode() {
                return deliverycorpCode;
            }

            public void setDeliverycorpCode(Object deliverycorpCode) {
                this.deliverycorpCode = deliverycorpCode;
            }

            public Object getDeliverycorpUrl() {
                return deliverycorpUrl;
            }

            public void setDeliverycorpUrl(Object deliverycorpUrl) {
                this.deliverycorpUrl = deliverycorpUrl;
            }

            public Object getOrderId() {
                return orderId;
            }

            public void setOrderId(Object orderId) {
                this.orderId = orderId;
            }
        }

        public static class OrderBean {
            /**
             * id : 020201126102345747564
             * createBy : 13751773402
             * createTime : 2020-11-26 10:23:46
             * updateBy : null
             * updateTime : null
             * sysOrgCode : A02
             * orderNum : 20201126102346631412
             * createUserName : 13751773402
             * createUserPhone : 13751773402
             * receiverId : 1330423821953454081
             * receiverName : 默写
             * receiverAreaId : 450124
             * receiverAreaName : 广西壮族自治区,南宁市,马山县
             * receiverPhone : 13336
             * receiverAddress : 额我问了一下
             * receiveTime : null
             * freight : null
             * tax : null
             * fee : null
             * productAmount : 234
             * amount : 234
             * weight : 0
             * quantity : 1
             * memo : null
             * isAllocatedstock : 1
             * paymentType : null
             * paymentTime : null
             * shippingName : null
             * completeDate : null
             * expire : 2020-11-26 10:28:46
             * sn : null
             * type : null
             * status : 0
             * statusName : 待支付
             * paymentTypeName : null
             * skuIds : null
             * orderItemList : null
             * picUrl : null
             * orderTitle : null
             * skuName : null
             */

            private String id;
            private String createBy;
            private String createTime;
            private Object updateBy;
            private Object updateTime;
            private String sysOrgCode;
            private String orderNum;
            private String createUserName;
            private String createUserPhone;
            private String receiverId;
            private String receiverName;
            private String receiverAreaId;
            private String receiverAreaName;
            private String receiverPhone;
            private String receiverAddress;
            private Object receiveTime;
            private Object freight;
            private Object tax;
            private Object fee;
            private int productAmount;
            private double amount;
            private int weight;
            private int quantity;
            private String memo;
            private String isAllocatedstock;
            private Object paymentType;
            private String paymentTime;
            private Object shippingName;
            private Object completeDate;
            private String expire;
            private Object sn;
            private Object type;
            private int status;
            private String statusName;
            private Object paymentTypeName;
            private Object skuIds;
            private Object orderItemList;
            private Object picUrl;
            private Object orderTitle;
            private Object skuName;

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

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public String getSysOrgCode() {
                return sysOrgCode;
            }

            public void setSysOrgCode(String sysOrgCode) {
                this.sysOrgCode = sysOrgCode;
            }

            public String getOrderNum() {
                return orderNum;
            }

            public void setOrderNum(String orderNum) {
                this.orderNum = orderNum;
            }

            public String getCreateUserName() {
                return createUserName;
            }

            public void setCreateUserName(String createUserName) {
                this.createUserName = createUserName;
            }

            public String getCreateUserPhone() {
                return createUserPhone;
            }

            public void setCreateUserPhone(String createUserPhone) {
                this.createUserPhone = createUserPhone;
            }

            public String getReceiverId() {
                return receiverId;
            }

            public void setReceiverId(String receiverId) {
                this.receiverId = receiverId;
            }

            public String getReceiverName() {
                return receiverName;
            }

            public void setReceiverName(String receiverName) {
                this.receiverName = receiverName;
            }

            public String getReceiverAreaId() {
                return receiverAreaId;
            }

            public void setReceiverAreaId(String receiverAreaId) {
                this.receiverAreaId = receiverAreaId;
            }

            public String getReceiverAreaName() {
                return receiverAreaName;
            }

            public void setReceiverAreaName(String receiverAreaName) {
                this.receiverAreaName = receiverAreaName;
            }

            public String getReceiverPhone() {
                return receiverPhone;
            }

            public void setReceiverPhone(String receiverPhone) {
                this.receiverPhone = receiverPhone;
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

            public Object getFreight() {
                return freight;
            }

            public void setFreight(Object freight) {
                this.freight = freight;
            }

            public Object getTax() {
                return tax;
            }

            public void setTax(Object tax) {
                this.tax = tax;
            }

            public Object getFee() {
                return fee;
            }

            public void setFee(Object fee) {
                this.fee = fee;
            }

            public int getProductAmount() {
                return productAmount;
            }

            public void setProductAmount(int productAmount) {
                this.productAmount = productAmount;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public String getMemo() {
                return memo;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public String getIsAllocatedstock() {
                return isAllocatedstock;
            }

            public void setIsAllocatedstock(String isAllocatedstock) {
                this.isAllocatedstock = isAllocatedstock;
            }

            public Object getPaymentType() {
                return paymentType;
            }

            public void setPaymentType(Object paymentType) {
                this.paymentType = paymentType;
            }

            public String getPaymentTime() {
                return paymentTime;
            }

            public void setPaymentTime(String paymentTime) {
                this.paymentTime = paymentTime;
            }

            public Object getShippingName() {
                return shippingName;
            }

            public void setShippingName(Object shippingName) {
                this.shippingName = shippingName;
            }

            public Object getCompleteDate() {
                return completeDate;
            }

            public void setCompleteDate(Object completeDate) {
                this.completeDate = completeDate;
            }

            public String getExpire() {
                return expire;
            }

            public void setExpire(String expire) {
                this.expire = expire;
            }

            public Object getSn() {
                return sn;
            }

            public void setSn(Object sn) {
                this.sn = sn;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public Object getPaymentTypeName() {
                return paymentTypeName;
            }

            public void setPaymentTypeName(Object paymentTypeName) {
                this.paymentTypeName = paymentTypeName;
            }

            public Object getSkuIds() {
                return skuIds;
            }

            public void setSkuIds(Object skuIds) {
                this.skuIds = skuIds;
            }

            public Object getOrderItemList() {
                return orderItemList;
            }

            public void setOrderItemList(Object orderItemList) {
                this.orderItemList = orderItemList;
            }

            public Object getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(Object picUrl) {
                this.picUrl = picUrl;
            }

            public Object getOrderTitle() {
                return orderTitle;
            }

            public void setOrderTitle(Object orderTitle) {
                this.orderTitle = orderTitle;
            }

            public Object getSkuName() {
                return skuName;
            }

            public void setSkuName(Object skuName) {
                this.skuName = skuName;
            }
        }

    }
}
