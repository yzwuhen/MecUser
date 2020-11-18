package com.example.mechanicalapp.ui.data;

import java.util.List;

public class IntegralListBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"createBy":"admin","createTime":"2020-10-12 23:10:54","updateBy":"admin","sysOrgCode":"A01A03","updateTime":"2020-11-17 23:25:46","id":"1315671289571790850","signInDay":2,"isSignIn":null,"points":33328},{"createBy":"2233","createTime":"2020-10-12 23:12:16","updateBy":"admin","sysOrgCode":"A01A03","updateTime":"2020-10-20 00:02:27","id":"1315671634435854337","signInDay":null,"isSignIn":null,"points":23424},{"createBy":"13886943851","createTime":"2020-11-12 11:07:23","updateBy":"13886943851","sysOrgCode":null,"updateTime":"2020-11-18 10:26:33","id":"1326723235215130626","signInDay":1,"isSignIn":null,"points":99960},{"createBy":"13751773402","createTime":"2020-11-14 17:00:50","updateBy":"13751773402","sysOrgCode":"A02","updateTime":"2020-11-18 15:45:45","id":"1327536960469729281","signInDay":null,"isSignIn":null,"points":99885}],"total":4,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1605693900230
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
         * records : [{"createBy":"admin","createTime":"2020-10-12 23:10:54","updateBy":"admin","sysOrgCode":"A01A03","updateTime":"2020-11-17 23:25:46","id":"1315671289571790850","signInDay":2,"isSignIn":null,"points":33328},{"createBy":"2233","createTime":"2020-10-12 23:12:16","updateBy":"admin","sysOrgCode":"A01A03","updateTime":"2020-10-20 00:02:27","id":"1315671634435854337","signInDay":null,"isSignIn":null,"points":23424},{"createBy":"13886943851","createTime":"2020-11-12 11:07:23","updateBy":"13886943851","sysOrgCode":null,"updateTime":"2020-11-18 10:26:33","id":"1326723235215130626","signInDay":1,"isSignIn":null,"points":99960},{"createBy":"13751773402","createTime":"2020-11-14 17:00:50","updateBy":"13751773402","sysOrgCode":"A02","updateTime":"2020-11-18 15:45:45","id":"1327536960469729281","signInDay":null,"isSignIn":null,"points":99885}]
         * total : 4
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
        private List<IntegralData> records;

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

        public List<IntegralData> getRecords() {
            return records;
        }

        public void setRecords(List<IntegralData> records) {
            this.records = records;
        }
    }
}
