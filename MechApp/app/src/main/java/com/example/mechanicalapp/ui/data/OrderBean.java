package com.example.mechanicalapp.ui.data;

import java.util.List;

public class OrderBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"productModel":"awd-663","progress_dictText":null,"payTime":null,"city":null,"repairFactoryAddress":"广州市海珠区","productBrand":"八达重工","companyName":null,"orderNum":null,"repairId":null,"adress":"广东省深圳市 宝安区","status_dictText":"待确认","orderSum":null,"customerPhone":"13333","payType":null,"updateBy":null,"repairFactoryId":null,"statusName":null,"customerId":null,"progressName":null,"id":"1328357286455894018","productModelId":"1326574064199434242","repairType_dictText":null,"productType":"挖掘机","orderDesc":"你现在在","lat":"22.681693","productId":null,"lng":"113.939388","repairTypeName":null,"repairType":null,"productBrandId":"1321490471452721153","payType_dictText":null,"updateTime":null,"finishedRepairTime":null,"customerName":"你现在在","productTypeId":"1321476604976406530","payTypeName":null,"startRepairTime":null,"repairFactoryName":"锅碗瓢盆","receiveTime":null,"engineerIds":null,"createBy":"13751773402","repairName":null,"createTime":"2020-11-16 23:20:31","sysOrgCode":"A02","progress":null,"reachTime":null,"status":"0"}],"total":1,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1606053672787
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
         * records : [{"productModel":"awd-663","progress_dictText":null,"payTime":null,"city":null,"repairFactoryAddress":"广州市海珠区","productBrand":"八达重工","companyName":null,"orderNum":null,"repairId":null,"adress":"广东省深圳市 宝安区","status_dictText":"待确认","orderSum":null,"customerPhone":"13333","payType":null,"updateBy":null,"repairFactoryId":null,"statusName":null,"customerId":null,"progressName":null,"id":"1328357286455894018","productModelId":"1326574064199434242","repairType_dictText":null,"productType":"挖掘机","orderDesc":"你现在在","lat":"22.681693","productId":null,"lng":"113.939388","repairTypeName":null,"repairType":null,"productBrandId":"1321490471452721153","payType_dictText":null,"updateTime":null,"finishedRepairTime":null,"customerName":"你现在在","productTypeId":"1321476604976406530","payTypeName":null,"startRepairTime":null,"repairFactoryName":"锅碗瓢盆","receiveTime":null,"engineerIds":null,"createBy":"13751773402","repairName":null,"createTime":"2020-11-16 23:20:31","sysOrgCode":"A02","progress":null,"reachTime":null,"status":"0"}]
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
        private List<OrderData> records;

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

        public List<OrderData> getRecords() {
            return records;
        }

        public void setRecords(List<OrderData> records) {
            this.records = records;
        }

    }
}
