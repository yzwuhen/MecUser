package com.example.mechanicalapp.ui.data;

import java.util.List;

public class CollectFactoryBean extends NetData {
    /**
     * success : true
     * result : {"records":[{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂101","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"10","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂11","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"11","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂4","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"4","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂5","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"5","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂6","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"6","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂7","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"7","lat":null,"introduction":null}],"total":6,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1605596600190
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
         * records : [{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂101","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"10","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂11","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"11","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂4","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"4","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂5","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"5","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂6","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"6","lat":null,"introduction":null},{"businessLicense":null,"componentType":"2","responsePersonName":"王丽","address":"3","lng":null,"companyName":null,"updateTime":null,"userId":null,"isApprove":null,"createBy":"admin","companyId":null,"repaireType":"2","factoryPicture":null,"createTime":"2020-10-14 23:51:24","updateBy":null,"responsePersonId":"3","name":"维修厂7","sysOrgCode":"A01A03","responsePersonPhone":"13652521458","id":"7","lat":null,"introduction":null}]
         * total : 6
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
        private List<FactoryData> records;

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

        public List<FactoryData> getRecords() {
            return records;
        }

        public void setRecords(List<FactoryData> records) {
            this.records = records;
        }
    }
}
