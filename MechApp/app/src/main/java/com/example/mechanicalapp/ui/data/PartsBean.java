package com.example.mechanicalapp.ui.data;

import java.util.List;

public class PartsBean extends NetData {


    /**
     * success : true
     * result : {"records":[{"city":null,"partsType":"modlecode3","content":"2","isPerson":"1","orderTime":"2020-10-31","fitMachineType":"1","updateBy":"admin","price":"22","isOn":"1","id":"1","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","createBy":"admin","createTime":"2020-10-31 19:23:04","isTop":null,"gpsLat":null,"name":"挖掘机反光镜","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"city":null,"partsType":"modlecode3","content":"2","isPerson":"1","orderTime":"2020-10-31","fitMachineType":"1","updateBy":"admin","price":"22","isOn":"1","id":"3","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","createBy":"admin","createTime":"2020-10-31 19:23:04","isTop":null,"gpsLat":null,"name":"推土机轮胎链条","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"city":null,"partsType":"modlecode3","content":"2","isPerson":"1","orderTime":"2020-10-31","fitMachineType":"1","updateBy":"admin","price":"22","isOn":"1","id":"5","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","createBy":"admin","createTime":"2020-10-31 19:23:04","isTop":null,"gpsLat":null,"name":"挖土机刹车片","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"}],"total":3,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1604929687615
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
         * records : [{"city":null,"partsType":"modlecode3","content":"2","isPerson":"1","orderTime":"2020-10-31","fitMachineType":"1","updateBy":"admin","price":"22","isOn":"1","id":"1","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","createBy":"admin","createTime":"2020-10-31 19:23:04","isTop":null,"gpsLat":null,"name":"挖掘机反光镜","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"city":null,"partsType":"modlecode3","content":"2","isPerson":"1","orderTime":"2020-10-31","fitMachineType":"1","updateBy":"admin","price":"22","isOn":"1","id":"3","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","createBy":"admin","createTime":"2020-10-31 19:23:04","isTop":null,"gpsLat":null,"name":"推土机轮胎链条","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"city":null,"partsType":"modlecode3","content":"2","isPerson":"1","orderTime":"2020-10-31","fitMachineType":"1","updateBy":"admin","price":"22","isOn":"1","id":"5","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","createBy":"admin","createTime":"2020-10-31 19:23:04","isTop":null,"gpsLat":null,"name":"挖土机刹车片","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"}]
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
        private List<PartsData> records;

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

        public List<PartsData> getRecords() {
            return records;
        }

        public void setRecords(List<PartsData> records) {
            this.records = records;
        }


    }
}
