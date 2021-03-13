package com.example.mechanicalapp.ui.data;

import java.util.List;

public class ReportBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"reportReasonId":"1331525190890328066","reportReasonContent":"举报测试测试测试车是？我\u2026\u2026在一起就会觉得你不知道你在一起吗？我也想知道为什么要","reportId":null,"type_dictText":null,"updateTime":null,"remark":null,"pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/tmpImage20201126144658695680_1606378619080.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/tmpImage20201126144705517211_1606378627590.jpg","type":null,"createBy":"13886943851","createTime":"2020-11-26 16:17:17","updateBy":null,"sysOrgCode":null,"id":"1331874655228710914","reportReasonId_dictText":"涉嫌暴力，色情"},{"reportReasonId":"1331525246905257986","reportReasonContent":"测试","reportId":null,"type_dictText":null,"updateTime":null,"remark":null,"pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/tmpImage20201126150032790321_1606379434030.jpg","type":null,"createBy":"13886943851","createTime":"2020-11-26 16:30:36","updateBy":null,"sysOrgCode":null,"id":"1331878003570954241","reportReasonId_dictText":"涉嫌传销"}],"total":2,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1606456460171
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
         * records : [{"reportReasonId":"1331525190890328066","reportReasonContent":"举报测试测试测试车是？我\u2026\u2026在一起就会觉得你不知道你在一起吗？我也想知道为什么要","reportId":null,"type_dictText":null,"updateTime":null,"remark":null,"pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/tmpImage20201126144658695680_1606378619080.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/tmpImage20201126144705517211_1606378627590.jpg","type":null,"createBy":"13886943851","createTime":"2020-11-26 16:17:17","updateBy":null,"sysOrgCode":null,"id":"1331874655228710914","reportReasonId_dictText":"涉嫌暴力，色情"},{"reportReasonId":"1331525246905257986","reportReasonContent":"测试","reportId":null,"type_dictText":null,"updateTime":null,"remark":null,"pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/tmpImage20201126150032790321_1606379434030.jpg","type":null,"createBy":"13886943851","createTime":"2020-11-26 16:30:36","updateBy":null,"sysOrgCode":null,"id":"1331878003570954241","reportReasonId_dictText":"涉嫌传销"}]
         * total : 2
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
        private List<ReportData> records;

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

        public List<ReportData> getRecords() {
            return records;
        }

        public void setRecords(List<ReportData> records) {
            this.records = records;
        }

    }
}
