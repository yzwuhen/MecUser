package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class CommentBean extends NetData {

    /**
     * success : true
     * result : {"pages":{"records":[{"id":"10","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"5","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"},{"id":"11","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"5","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"}],"total":4,"size":2,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":2},"num":4}
     * timestamp : 1605883262933
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
         * pages : {"records":[{"id":"10","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"5","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"},{"id":"11","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"5","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"}],"total":4,"size":2,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":2}
         * num : 4
         */

        private PagesBean pages;

        public PagesBean getPages() {
            return pages;
        }

        public void setPages(PagesBean pages) {
            this.pages = pages;
        }



        public static class PagesBean implements Serializable {
            /**
             * records : [{"id":"10","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"5","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"},{"id":"11","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"5","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"}]
             * total : 4
             * size : 2
             * current : 1
             * orders : []
             * optimizeCountSql : true
             * hitCount : false
             * searchCount : true
             * pages : 2
             */

            private Integer total;
            private Integer size;
            private Integer current;
            private Boolean optimizeCountSql;
            private Boolean hitCount;
            private Boolean searchCount;
            private Integer pages;
            private List<CommentData> records;

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

            public List<CommentData> getRecords() {
                return records;
            }

            public void setRecords(List<CommentData> records) {
                this.records = records;
            }


        }
    }
}
