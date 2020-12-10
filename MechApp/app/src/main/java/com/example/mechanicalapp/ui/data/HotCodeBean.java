package com.example.mechanicalapp.ui.data;

import java.util.List;

public class HotCodeBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"isSystem_dictText":"是","type_dictText":"首页-机械租赁","updateTime":null,"type":"0","userId":null,"isSystem":"1","createBy":"admin","searchTime":10,"createTime":"2020-12-10 14:29:03","updateBy":null,"name":"挖掘机","sysOrgCode":"A01A03","id":"1336920847046270978"},{"isSystem_dictText":"是","type_dictText":"机械","updateTime":null,"type":"10","userId":null,"isSystem":"1","createBy":"admin","searchTime":122,"createTime":"2020-12-10 14:29:36","updateBy":null,"name":"机械匕","sysOrgCode":"A01A03","id":"1336920987748392962"},{"isSystem_dictText":"是","type_dictText":"首页-配件租赁","updateTime":null,"type":"2","userId":null,"isSystem":"1","createBy":"admin","searchTime":11,"createTime":"2020-12-10 14:30:04","updateBy":null,"name":"移动机械箱","sysOrgCode":"A01A03","id":"1336921105193099265"}],"total":3,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1607590505789
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
         * records : [{"isSystem_dictText":"是","type_dictText":"首页-机械租赁","updateTime":null,"type":"0","userId":null,"isSystem":"1","createBy":"admin","searchTime":10,"createTime":"2020-12-10 14:29:03","updateBy":null,"name":"挖掘机","sysOrgCode":"A01A03","id":"1336920847046270978"},{"isSystem_dictText":"是","type_dictText":"机械","updateTime":null,"type":"10","userId":null,"isSystem":"1","createBy":"admin","searchTime":122,"createTime":"2020-12-10 14:29:36","updateBy":null,"name":"机械匕","sysOrgCode":"A01A03","id":"1336920987748392962"},{"isSystem_dictText":"是","type_dictText":"首页-配件租赁","updateTime":null,"type":"2","userId":null,"isSystem":"1","createBy":"admin","searchTime":11,"createTime":"2020-12-10 14:30:04","updateBy":null,"name":"移动机械箱","sysOrgCode":"A01A03","id":"1336921105193099265"}]
         * total : 3
         * size : 10
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
        private List<HotCodeData> records;

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

        public List<HotCodeData> getRecords() {
            return records;
        }

        public void setRecords(List<HotCodeData> records) {
            this.records = records;
        }
    }
}
