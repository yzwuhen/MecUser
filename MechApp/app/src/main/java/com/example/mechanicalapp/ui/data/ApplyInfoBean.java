package com.example.mechanicalapp.ui.data;

import com.example.mechanicalapp.ui.data.request.ReCer;

import java.util.List;

public class ApplyInfoBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"socialPic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg_1605753336511.bin","sex_dictText":null,"city":null,"idCard":null,"companyName":"岁的法国","idCardFrontPic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg-1_1605753321114.bin","content":null,"socialNo":null,"repaireType":null,"updateBy":null,"apporveStatus":null,"apporveType_dictText":"企业用户认证","id":"1329251973756657665","idCardBackPic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg-2_1605753331330.bin","apporveStatus_dictText":null,"componentType":null,"gpsLon":null,"sex":null,"updateTime":null,"repairPic":null,"createBy":"13751773402","companyId":"12312312312","createTime":"2020-11-19 10:35:42","companyAddress":"123123123123123","gpsLat":null,"name":"12313","apporveType":"3","sysOrgCode":"A02","contactPhone":null}],"total":1,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1608636635482
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
         * records : [{"socialPic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg_1605753336511.bin","sex_dictText":null,"city":null,"idCard":null,"companyName":"岁的法国","idCardFrontPic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg-1_1605753321114.bin","content":null,"socialNo":null,"repaireType":null,"updateBy":null,"apporveStatus":null,"apporveType_dictText":"企业用户认证","id":"1329251973756657665","idCardBackPic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg-2_1605753331330.bin","apporveStatus_dictText":null,"componentType":null,"gpsLon":null,"sex":null,"updateTime":null,"repairPic":null,"createBy":"13751773402","companyId":"12312312312","createTime":"2020-11-19 10:35:42","companyAddress":"123123123123123","gpsLat":null,"name":"12313","apporveType":"3","sysOrgCode":"A02","contactPhone":null}]
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
        private List<ReCer> records;

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

        public List<ReCer> getRecords() {
            return records;
        }

        public void setRecords(List<ReCer> records) {
            this.records = records;
        }


    }
}
