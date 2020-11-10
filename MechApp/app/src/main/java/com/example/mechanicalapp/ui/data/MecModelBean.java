package com.example.mechanicalapp.ui.data;

import java.util.List;

public class MecModelBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"modelName":"机械机型1","createBy":"admin","createTime":"2020-10-29 00:36:39","updateBy":null,"sysOrgCode":"A01A03","updateTime":null,"id":"1321491075206004738"}],"total":1,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1604999603846
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
         * records : [{"modelName":"机械机型1","createBy":"admin","createTime":"2020-10-29 00:36:39","updateBy":null,"sysOrgCode":"A01A03","updateTime":null,"id":"1321491075206004738"}]
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
        private List<MecModelData> records;

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

        public List<MecModelData> getRecords() {
            return records;
        }

        public void setRecords(List<MecModelData> records) {
            this.records = records;
        }

    }
}
