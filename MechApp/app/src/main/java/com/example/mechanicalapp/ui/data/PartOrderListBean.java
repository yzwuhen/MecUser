package com.example.mechanicalapp.ui.data;

import java.util.List;

public class PartOrderListBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"isAllocatedstock":"1","isAllocatedstock_dictText":"是","orderItemList":null,"freight":null,"fee":null,"createUserPhone":null,"orderNum":"20201124165015350634","memo":null,"type_dictText":null,"createUserName":"13751773402","status_dictText":"未支付","type":null,"skuIds":null,"paymentType":null,"completeDate":null,"receiverId":"1330423821953454081","receiverPhone":"13336","updateBy":null,"statusName":"待支付","id":"020201124165015133670","sn":null,"receiverAreaId":"450124","paymentTime":null,"amount":234,"quantity":1,"shippingName":null,"receiverName":"默写","paymentTypeName":null,"weight":0,"updateTime":null,"tax":null,"receiverAddress":"额我问了一下","receiveTime":null,"createBy":"13751773402","productAmount":234,"createTime":"2020-11-24 16:50:16","expire":"2020-11-24 16:55:16","sysOrgCode":"A02","receiverAreaName":"广西壮族自治区,南宁市,马山县","paymentType_dictText":null,"status":"0"}],"total":1,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1606208445767
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
         * records : [{"isAllocatedstock":"1","isAllocatedstock_dictText":"是","orderItemList":null,"freight":null,"fee":null,"createUserPhone":null,"orderNum":"20201124165015350634","memo":null,"type_dictText":null,"createUserName":"13751773402","status_dictText":"未支付","type":null,"skuIds":null,"paymentType":null,"completeDate":null,"receiverId":"1330423821953454081","receiverPhone":"13336","updateBy":null,"statusName":"待支付","id":"020201124165015133670","sn":null,"receiverAreaId":"450124","paymentTime":null,"amount":234,"quantity":1,"shippingName":null,"receiverName":"默写","paymentTypeName":null,"weight":0,"updateTime":null,"tax":null,"receiverAddress":"额我问了一下","receiveTime":null,"createBy":"13751773402","productAmount":234,"createTime":"2020-11-24 16:50:16","expire":"2020-11-24 16:55:16","sysOrgCode":"A02","receiverAreaName":"广西壮族自治区,南宁市,马山县","paymentType_dictText":null,"status":"0"}]
         * total : 1
         * size : 30
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * searchCount : true
         * pages : 1
         */

        private int total;
        private int size;
        private int current;
        private boolean optimizeCountSql;
        private boolean hitCount;
        private boolean searchCount;
        private int pages;
        private List<PartsOrderData> records;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<PartsOrderData> getRecords() {
            return records;
        }

        public void setRecords(List<PartsOrderData> records) {
            this.records = records;
        }

    }
}
