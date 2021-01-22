package com.example.mechanicalapp.ui.data;

import java.util.List;

public class FactoryCommentListBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"orderId":null,"orderNum":"99665","updateTime":null,"commentContent":"哈哈哈哈哈哈哈","customerName":"玩儿","repairFactoryName":"维修厂1","createBy":"admin","customerPhone":"12554555211","starLevelName":"5星","createTime":"2020-10-13 22:03:47","updateBy":null,"repairFactoryId":"1","customerId":null,"sysOrgCode":"A01A03","id":"1316016788757762049","starLevel":"1"},{"orderId":null,"orderNum":"021001010","updateTime":null,"commentContent":"45","customerName":"啊三","repairFactoryName":"维修厂1","createBy":"admin","customerPhone":"545","starLevelName":"4545","createTime":"2020-11-07 17:48:51","updateBy":null,"repairFactoryId":"1","customerId":null,"sysOrgCode":"A01A03","id":"1325012326534537218","starLevel":"5"},{"orderId":"1340948775642931201","orderNum":"120201221171436360303","updateTime":null,"commentContent":"4分好评","customerName":"yz","repairFactoryName":null,"createBy":"13751773402","customerPhone":"13333333","starLevelName":null,"createTime":"2021-01-22 16:07:27","updateBy":null,"repairFactoryId":"1","customerId":null,"sysOrgCode":null,"id":"1352528286881685506","starLevel":"4"}],"total":3,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1611304977072
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
         * records : [{"orderId":null,"orderNum":"99665","updateTime":null,"commentContent":"哈哈哈哈哈哈哈","customerName":"玩儿","repairFactoryName":"维修厂1","createBy":"admin","customerPhone":"12554555211","starLevelName":"5星","createTime":"2020-10-13 22:03:47","updateBy":null,"repairFactoryId":"1","customerId":null,"sysOrgCode":"A01A03","id":"1316016788757762049","starLevel":"1"},{"orderId":null,"orderNum":"021001010","updateTime":null,"commentContent":"45","customerName":"啊三","repairFactoryName":"维修厂1","createBy":"admin","customerPhone":"545","starLevelName":"4545","createTime":"2020-11-07 17:48:51","updateBy":null,"repairFactoryId":"1","customerId":null,"sysOrgCode":"A01A03","id":"1325012326534537218","starLevel":"5"},{"orderId":"1340948775642931201","orderNum":"120201221171436360303","updateTime":null,"commentContent":"4分好评","customerName":"yz","repairFactoryName":null,"createBy":"13751773402","customerPhone":"13333333","starLevelName":null,"createTime":"2021-01-22 16:07:27","updateBy":null,"repairFactoryId":"1","customerId":null,"sysOrgCode":null,"id":"1352528286881685506","starLevel":"4"}]
         * total : 3
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
        private List<FactoryCommentData> records;

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

        public List<FactoryCommentData> getRecords() {
            return records;
        }

        public void setRecords(List<FactoryCommentData> records) {
            this.records = records;
        }


    }
}
