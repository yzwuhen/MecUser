package com.example.mechanicalapp.ui.data;

import com.example.mechanicalapp.ui.data.request.ReAddress;

import java.util.List;

public class MyAddressBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"area":"广东省广州市白云区","isDefault_dictText":"是","updateTime":"2020-11-20 11:18:59","adress":"太和镇106国道","createBy":"13886943851","isDefault":"1","areaId":"440111","createTime":"2020-11-20 10:47:33","updateBy":"13886943851","phone":"13886943851","name":"锅碗瓢盆","sysOrgCode":null,"id":"1329617347241172993"},{"area":"吉林省长春市南关区","isDefault_dictText":"否","updateTime":null,"adress":"测试地址","createBy":"13886943851","isDefault":"0","areaId":"220102","createTime":"2020-11-20 11:34:09","updateBy":null,"phone":"13886943851","name":"哈哈","sysOrgCode":null,"id":"1329629073185562626"},{"area":"广西壮族自治区,南宁市,马山县","isDefault_dictText":"否","updateTime":null,"adress":"额我问了一下","createBy":"13751773402","isDefault":"0","areaId":"450124","createTime":"2020-11-22 16:12:12","updateBy":null,"phone":"13336","name":"默写","sysOrgCode":"A02","id":"1330423821953454081"},{"area":"湖北省,市辖区,通州区","isDefault_dictText":"否","updateTime":null,"adress":"墨鱼丸","createBy":"13751773402","isDefault":"0","areaId":"110112","createTime":"2020-11-22 16:14:56","updateBy":null,"phone":"6999996","name":"你现在","sysOrgCode":"A02","id":"1330424510804971522"}],"total":4,"size":30,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1606032961434
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
         * records : [{"area":"广东省广州市白云区","isDefault_dictText":"是","updateTime":"2020-11-20 11:18:59","adress":"太和镇106国道","createBy":"13886943851","isDefault":"1","areaId":"440111","createTime":"2020-11-20 10:47:33","updateBy":"13886943851","phone":"13886943851","name":"锅碗瓢盆","sysOrgCode":null,"id":"1329617347241172993"},{"area":"吉林省长春市南关区","isDefault_dictText":"否","updateTime":null,"adress":"测试地址","createBy":"13886943851","isDefault":"0","areaId":"220102","createTime":"2020-11-20 11:34:09","updateBy":null,"phone":"13886943851","name":"哈哈","sysOrgCode":null,"id":"1329629073185562626"},{"area":"广西壮族自治区,南宁市,马山县","isDefault_dictText":"否","updateTime":null,"adress":"额我问了一下","createBy":"13751773402","isDefault":"0","areaId":"450124","createTime":"2020-11-22 16:12:12","updateBy":null,"phone":"13336","name":"默写","sysOrgCode":"A02","id":"1330423821953454081"},{"area":"湖北省,市辖区,通州区","isDefault_dictText":"否","updateTime":null,"adress":"墨鱼丸","createBy":"13751773402","isDefault":"0","areaId":"110112","createTime":"2020-11-22 16:14:56","updateBy":null,"phone":"6999996","name":"你现在","sysOrgCode":"A02","id":"1330424510804971522"}]
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
        private List<ReAddress> records;

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

        public List<ReAddress> getRecords() {
            return records;
        }

        public void setRecords(List<ReAddress> records) {
            this.records = records;
        }
    }
}
