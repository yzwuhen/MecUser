package com.example.mechanicalapp.ui.data;

import java.util.List;

public class MyMecListBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"purchaseDate":"2020-11-24","facDate":"2020-11-21","modelId":"1326574064199434242","city":"深圳市","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/IMG_20201015_21164354_1605941694672.jpg,","cateName":"挖掘机","isPerson":null,"titile":"默写","updateBy":null,"briefDesc":"哦哦","price":0,"isNew_dictText":null,"id":"1330042031782772738","brandName":"长城","gpsLon":"113.939388","address":"广东省深圳市 宝安区","updateTime":null,"isNew":null,"workTime":"69","modelName":"awd-663","createBy":"13751773402","createTime":"2020-11-21 14:55:06","cateId":"1321476604976406530","brandId":"1","gpsLat":"22.681693","sysOrgCode":"A02","isEnterprise":null}],"total":1,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1605941715461
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
         * records : [{"purchaseDate":"2020-11-24","facDate":"2020-11-21","modelId":"1326574064199434242","city":"深圳市","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/IMG_20201015_21164354_1605941694672.jpg,","cateName":"挖掘机","isPerson":null,"titile":"默写","updateBy":null,"briefDesc":"哦哦","price":0,"isNew_dictText":null,"id":"1330042031782772738","brandName":"长城","gpsLon":"113.939388","address":"广东省深圳市 宝安区","updateTime":null,"isNew":null,"workTime":"69","modelName":"awd-663","createBy":"13751773402","createTime":"2020-11-21 14:55:06","cateId":"1321476604976406530","brandId":"1","gpsLat":"22.681693","sysOrgCode":"A02","isEnterprise":null}]
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
        private List<MecData> records;

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

        public List<MecData> getRecords() {
            return records;
        }

        public void setRecords(List<MecData> records) {
            this.records = records;
        }


    }
}
