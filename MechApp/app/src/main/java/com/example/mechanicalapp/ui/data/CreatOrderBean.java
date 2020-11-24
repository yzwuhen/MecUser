package com.example.mechanicalapp.ui.data;

import java.util.List;

public class CreatOrderBean extends NetData {

    /**
     * success : true
     * result : {"id":"020201124171129397022","createBy":"13751773402","createTime":"2020-11-24 17:11:29","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderNum":"20201124171129722132","createUserName":"13751773402","createUserPhone":null,"receiverId":"1330423821953454081","receiverName":"默写","receiverAreaId":"450124","receiverAreaName":"广西壮族自治区,南宁市,马山县","receiverPhone":"13336","receiverAddress":"额我问了一下","receiveTime":null,"freight":null,"tax":null,"fee":null,"productAmount":234,"amount":234,"weight":0,"quantity":1,"memo":null,"isAllocatedstock":"1","paymentType":null,"paymentTime":null,"shippingName":null,"completeDate":null,"expire":"2020-11-24 17:16:29","sn":null,"type":null,"status":"0","statusName":"待支付","paymentTypeName":null,"skuIds":null,"orderItemList":[{"id":"1331163521844535297","createBy":"13751773402","createTime":"2020-11-24 17:11:30","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderId":"020201124171129397022","prodName":"苹果999","mecProductSkuId":"16061452639243882418","skuName":null,"price":234,"quantity":1,"weight":null,"isDelivery":null,"thumbnail":null,"productSkuImg":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg","isBaoyou":null,"freight":null,"productSum":234,"totalSum":234}]}
     * timestamp : 1606209090231
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
         * id : 020201124171129397022
         * createBy : 13751773402
         * createTime : 2020-11-24 17:11:29
         * updateBy : null
         * updateTime : null
         * sysOrgCode : A02
         * orderNum : 20201124171129722132
         * createUserName : 13751773402
         * createUserPhone : null
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
         * expire : 2020-11-24 17:16:29
         * sn : null
         * type : null
         * status : 0
         * statusName : 待支付
         * paymentTypeName : null
         * skuIds : null
         * orderItemList : [{"id":"1331163521844535297","createBy":"13751773402","createTime":"2020-11-24 17:11:30","updateBy":null,"updateTime":null,"sysOrgCode":"A02","orderId":"020201124171129397022","prodName":"苹果999","mecProductSkuId":"16061452639243882418","skuName":null,"price":234,"quantity":1,"weight":null,"isDelivery":null,"thumbnail":null,"productSkuImg":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg","isBaoyou":null,"freight":null,"productSum":234,"totalSum":234}]
         */

        private String id;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private String sysOrgCode;
        private String orderNum;
        private String createUserName;
        private Object createUserPhone;
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
        private Object memo;
        private String isAllocatedstock;
        private Object paymentType;
        private Object paymentTime;
        private Object shippingName;
        private Object completeDate;
        private String expire;
        private Object sn;
        private Object type;
        private String status;
        private String statusName;
        private Object paymentTypeName;
        private Object skuIds;
        private List<OrderItemListBean> orderItemList;

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

        public Object getCreateUserPhone() {
            return createUserPhone;
        }

        public void setCreateUserPhone(Object createUserPhone) {
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

        public Object getMemo() {
            return memo;
        }

        public void setMemo(Object memo) {
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

        public Object getPaymentTime() {
            return paymentTime;
        }

        public void setPaymentTime(Object paymentTime) {
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
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

        public List<OrderItemListBean> getOrderItemList() {
            return orderItemList;
        }

        public void setOrderItemList(List<OrderItemListBean> orderItemList) {
            this.orderItemList = orderItemList;
        }

        public static class OrderItemListBean {
            /**
             * id : 1331163521844535297
             * createBy : 13751773402
             * createTime : 2020-11-24 17:11:30
             * updateBy : null
             * updateTime : null
             * sysOrgCode : A02
             * orderId : 020201124171129397022
             * prodName : 苹果999
             * mecProductSkuId : 16061452639243882418
             * skuName : null
             * price : 234
             * quantity : 1
             * weight : null
             * isDelivery : null
             * thumbnail : null
             * productSkuImg : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg
             * isBaoyou : null
             * freight : null
             * productSum : 234
             * totalSum : 234
             */

            private String id;
            private String createBy;
            private String createTime;
            private Object updateBy;
            private Object updateTime;
            private String sysOrgCode;
            private String orderId;
            private String prodName;
            private String mecProductSkuId;
            private Object skuName;
            private int price;
            private int quantity;
            private Object weight;
            private Object isDelivery;
            private Object thumbnail;
            private String productSkuImg;
            private Object isBaoyou;
            private Object freight;
            private int productSum;
            private int totalSum;

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

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getProdName() {
                return prodName;
            }

            public void setProdName(String prodName) {
                this.prodName = prodName;
            }

            public String getMecProductSkuId() {
                return mecProductSkuId;
            }

            public void setMecProductSkuId(String mecProductSkuId) {
                this.mecProductSkuId = mecProductSkuId;
            }

            public Object getSkuName() {
                return skuName;
            }

            public void setSkuName(Object skuName) {
                this.skuName = skuName;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public Object getWeight() {
                return weight;
            }

            public void setWeight(Object weight) {
                this.weight = weight;
            }

            public Object getIsDelivery() {
                return isDelivery;
            }

            public void setIsDelivery(Object isDelivery) {
                this.isDelivery = isDelivery;
            }

            public Object getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(Object thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getProductSkuImg() {
                return productSkuImg;
            }

            public void setProductSkuImg(String productSkuImg) {
                this.productSkuImg = productSkuImg;
            }

            public Object getIsBaoyou() {
                return isBaoyou;
            }

            public void setIsBaoyou(Object isBaoyou) {
                this.isBaoyou = isBaoyou;
            }

            public Object getFreight() {
                return freight;
            }

            public void setFreight(Object freight) {
                this.freight = freight;
            }

            public int getProductSum() {
                return productSum;
            }

            public void setProductSum(int productSum) {
                this.productSum = productSum;
            }

            public int getTotalSum() {
                return totalSum;
            }

            public void setTotalSum(int totalSum) {
                this.totalSum = totalSum;
            }
        }
    }
}
