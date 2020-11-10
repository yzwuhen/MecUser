package com.example.mechanicalapp.ui.data;

import java.util.List;

public class MecTypeChildBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"是","updateTime":null,"pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/wjj@3x_1603899540776.png","cateName":"挖掘机","createBy":"admin","createTime":"2020-10-28 23:39:09","updateBy":null,"hasChild":"1","sysOrgCode":"A01A03","id":"1321476604976406530","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:07","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/xwj@2x_1603899605710.png","cateName":"旋挖机","createBy":"admin","createTime":"2020-10-28 23:40:21","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321476906857242625","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:12","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/ttj@3x_1603899658162.png","cateName":"推土机","createBy":"admin","createTime":"2020-10-28 23:41:02","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477081252208641","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:19","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/qcd@3x_1603899696531.png","cateName":"汽车吊","createBy":"admin","createTime":"2020-10-28 23:41:39","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477237339037697","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:25","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/bc@3x_1603899722887.png","cateName":"泵车","createBy":"admin","createTime":"2020-10-28 23:42:06","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477349591195650","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:31","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/zzj@3x_1603899770080.png","cateName":"装载机","createBy":"admin","createTime":"2020-10-28 23:42:55","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477554315173890","isHot":"1"}],"total":6,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1604992200793
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
         * records : [{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"是","updateTime":null,"pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/wjj@3x_1603899540776.png","cateName":"挖掘机","createBy":"admin","createTime":"2020-10-28 23:39:09","updateBy":null,"hasChild":"1","sysOrgCode":"A01A03","id":"1321476604976406530","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:07","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/xwj@2x_1603899605710.png","cateName":"旋挖机","createBy":"admin","createTime":"2020-10-28 23:40:21","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321476906857242625","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:12","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/ttj@3x_1603899658162.png","cateName":"推土机","createBy":"admin","createTime":"2020-10-28 23:41:02","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477081252208641","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:19","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/qcd@3x_1603899696531.png","cateName":"汽车吊","createBy":"admin","createTime":"2020-10-28 23:41:39","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477237339037697","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:25","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/bc@3x_1603899722887.png","cateName":"泵车","createBy":"admin","createTime":"2020-10-28 23:42:06","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477349591195650","isHot":"1"},{"isHot_dictText":"是","orderNum":null,"hasChild_dictText":"否","updateTime":"2020-10-28 23:43:31","pid":"0","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/zzj@3x_1603899770080.png","cateName":"装载机","createBy":"admin","createTime":"2020-10-28 23:42:55","updateBy":"admin","hasChild":"0","sysOrgCode":"A01A03","id":"1321477554315173890","isHot":"1"}]
         * total : 6
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
        private List<MecTypeChildData> records;

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

        public List<MecTypeChildData> getRecords() {
            return records;
        }

        public void setRecords(List<MecTypeChildData> records) {
            this.records = records;
        }


    }
}
