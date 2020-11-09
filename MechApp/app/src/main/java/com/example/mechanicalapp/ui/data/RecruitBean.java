package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class RecruitBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"gpsId":null,"city":null,"recruitType_dictText":"招聘","compamyAddress":null,"content":null,"isPerson":null,"price_dictText":"","orderTime":null,"updateBy":null,"price":5000,"isOn":"1","jobEx":1,"company":null,"id":"1","jobType_dictText":"挖掘机工程师","isTop_dictText":null,"jobType":"1","gpsLon":null,"contactName":"尼才","recruitType":"1","updateTime":"2020-10-31 20:24:31","needNumber":100,"jobAddress":null,"createBy":null,"createTime":"2020-10-31 20:24:29","isTop":null,"gpsLat":null,"sysOrgCode":null,"isEnterprise":null,"jobTittle":"高级维修工程师招聘","contactPhone":"1355555555"},{"gpsId":null,"city":null,"recruitType_dictText":"招聘","compamyAddress":null,"content":null,"isPerson":null,"price_dictText":"","orderTime":null,"updateBy":null,"price":5000,"isOn":"1","jobEx":1,"company":null,"id":"21","jobType_dictText":"挖掘机工程师","isTop_dictText":null,"jobType":"1","gpsLon":null,"contactName":"尼才","recruitType":"1","updateTime":"2020-10-31 20:24:31","needNumber":100,"jobAddress":null,"createBy":null,"createTime":"2020-10-31 20:24:29","isTop":null,"gpsLat":null,"sysOrgCode":null,"isEnterprise":null,"jobTittle":"高级维修工程师招聘","contactPhone":"1355555555"}],"total":2,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1604934365580
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * records : [{"gpsId":null,"city":null,"recruitType_dictText":"招聘","compamyAddress":null,"content":null,"isPerson":null,"price_dictText":"","orderTime":null,"updateBy":null,"price":5000,"isOn":"1","jobEx":1,"company":null,"id":"1","jobType_dictText":"挖掘机工程师","isTop_dictText":null,"jobType":"1","gpsLon":null,"contactName":"尼才","recruitType":"1","updateTime":"2020-10-31 20:24:31","needNumber":100,"jobAddress":null,"createBy":null,"createTime":"2020-10-31 20:24:29","isTop":null,"gpsLat":null,"sysOrgCode":null,"isEnterprise":null,"jobTittle":"高级维修工程师招聘","contactPhone":"1355555555"},{"gpsId":null,"city":null,"recruitType_dictText":"招聘","compamyAddress":null,"content":null,"isPerson":null,"price_dictText":"","orderTime":null,"updateBy":null,"price":5000,"isOn":"1","jobEx":1,"company":null,"id":"21","jobType_dictText":"挖掘机工程师","isTop_dictText":null,"jobType":"1","gpsLon":null,"contactName":"尼才","recruitType":"1","updateTime":"2020-10-31 20:24:31","needNumber":100,"jobAddress":null,"createBy":null,"createTime":"2020-10-31 20:24:29","isTop":null,"gpsLat":null,"sysOrgCode":null,"isEnterprise":null,"jobTittle":"高级维修工程师招聘","contactPhone":"1355555555"}]
         * total : 2
         * size : 30
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * searchCount : true
         * pages : 1
         */

        private Integer total;
        private Integer size;
        private Integer current;
        private Boolean optimizeCountSql;
        private Boolean hitCount;
        private Boolean searchCount;
        private Integer pages;
        private List<RecruitData> records;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getCurrent() {
            return current;
        }

        public void setCurrent(Integer current) {
            this.current = current;
        }

        public Boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(Boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public Boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(Boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(Boolean searchCount) {
            this.searchCount = searchCount;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public List<RecruitData> getRecords() {
            return records;
        }

        public void setRecords(List<RecruitData> records) {
            this.records = records;
        }


    }
}
