package com.example.mechanicalapp.ui.data;

import java.util.List;

public class BannerBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"img":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/097d2bc485a1411089bf5c420cbeb614_20200507_1001_1606297422253.jpeg","type_dictText":"机械租赁","updateTime":null,"type":"1","isShow_dictText":"是","isShow":"1","createBy":"admin","adId":null,"createTime":"2020-11-25 17:44:03","updateBy":null,"position_dictText":"用户首页","sysOrgCode":"A01A03","id":"1331534102443065345","position":"1"}],"total":1,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1606298877682
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
         * records : [{"img":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/097d2bc485a1411089bf5c420cbeb614_20200507_1001_1606297422253.jpeg","type_dictText":"机械租赁","updateTime":null,"type":"1","isShow_dictText":"是","isShow":"1","createBy":"admin","adId":null,"createTime":"2020-11-25 17:44:03","updateBy":null,"position_dictText":"用户首页","sysOrgCode":"A01A03","id":"1331534102443065345","position":"1"}]
         * total : 1
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
        private List<BannerData> records;

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

        public List<BannerData> getRecords() {
            return records;
        }

        public void setRecords(List<BannerData> records) {
            this.records = records;
        }
    }
}
