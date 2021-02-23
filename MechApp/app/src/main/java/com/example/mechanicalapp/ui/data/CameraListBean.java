package com.example.mechanicalapp.ui.data;

import java.util.List;

public class CameraListBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"serialNum":"","webcamAreaName":"区域1","webcamNum":"sfsdfsfs","updateTime":"2020-11-08 14:48:24","status_dictText":"已分配","webcamAreaChannelName":"圆通","checkCode":"","repairFactoryName":"维修厂1","createBy":"admin","webcamAreaChannelId":"1325264156229296129","createTime":"2020-11-08 13:19:30","updateBy":"admin","webcamUrl":"","repairFactoryId":"1","name":"摄像头22","sysOrgCode":"A01A03","id":"1325306930987204609","status":"1","webcamAreaId":"1325262509709123586"}],"total":1,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1613617351577
     */

    private boolean success;
    private ResultBean result;
    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        /**
         * records : [{"serialNum":"","webcamAreaName":"区域1","webcamNum":"sfsdfsfs","updateTime":"2020-11-08 14:48:24","status_dictText":"已分配","webcamAreaChannelName":"圆通","checkCode":"","repairFactoryName":"维修厂1","createBy":"admin","webcamAreaChannelId":"1325264156229296129","createTime":"2020-11-08 13:19:30","updateBy":"admin","webcamUrl":"","repairFactoryId":"1","name":"摄像头22","sysOrgCode":"A01A03","id":"1325306930987204609","status":"1","webcamAreaId":"1325262509709123586"}]
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
        private List<CameraListData> records;

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

        public List<CameraListData> getRecords() {
            return records;
        }

        public void setRecords(List<CameraListData> records) {
            this.records = records;
        }
    }
}
