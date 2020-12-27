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
        private OrderBackData orderBack;
        private OrderBean order;
        private List<PartsOrderGoodsList> productList;


        public OrderBackData getOrderBack() {
            return orderBack;
        }

        public void setOrderBack(OrderBackData orderBack) {
            this.orderBack = orderBack;
        }

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
            private int productAmount;
            private double amount;
            private int weight;
            private int quantity;
            private String memo;
            private String isAllocatedstock;
            private String paymentTime;
            private String expire;
            private int status;
            private String statusName;
            private String isBackOrder;

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

            public String getPaymentTime() {
                return paymentTime;
            }

            public void setPaymentTime(String paymentTime) {
                this.paymentTime = paymentTime;
            }

            public String getExpire() {
                return expire;
            }

            public void setExpire(String expire) {
                this.expire = expire;
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

            public String getIsBackOrder() {
                return isBackOrder;
            }

            public void setIsBackOrder(String isBackOrder) {
                this.isBackOrder = isBackOrder;
            }
        }


    }
}
