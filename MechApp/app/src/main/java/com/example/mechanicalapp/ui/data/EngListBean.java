package com.example.mechanicalapp.ui.data;

import java.util.List;

public class EngListBean extends NetData {

    /**
     * success : true
     * result : {"records":[{"post_dictText":"中级工程师","updateTime":"2020-10-16 21:31:51","userId":null,"headPicture":"temp/timg22_1602691158438.jpg","repairFactoryName":"维修厂1","createBy":"admin","post":"2","createTime":"2020-10-14 22:50:55","updateBy":"admin","phone":"16620164021","repairNum":20,"repairFactoryId":"1","name":"阳气","sysOrgCode":"A01A05","id":"1","repairAge":2},{"post_dictText":"初级工程师","updateTime":null,"userId":null,"headPicture":"temp/电脑_1603033093933.jpg","repairFactoryName":null,"createBy":"admin","post":"1","createTime":"2020-10-18 22:58:40","updateBy":null,"phone":"16620164036","repairNum":25,"repairFactoryId":null,"name":"圆通","sysOrgCode":"A01A03","id":"1317842538901229569","repairAge":3},{"post_dictText":"中级工程师","updateTime":null,"userId":null,"headPicture":"temp/timg22_1602691158438.jpg","repairFactoryName":"维修厂1","createBy":"admin","post":"2","createTime":"2020-10-14 23:34:55","updateBy":null,"phone":"16620164021","repairNum":2,"repairFactoryId":"1","name":"北京天津","sysOrgCode":"A01A03","id":"2","repairAge":2},{"post_dictText":"中级工程师","updateTime":"2020-10-16 21:25:36","userId":null,"headPicture":"temp/timg22_1602691158438.jpg","repairFactoryName":"维修厂1","createBy":"admin","post":"2","createTime":"2020-10-14 23:59:38","updateBy":"admin","phone":"16620164051","repairNum":222,"repairFactoryId":"1","name":"龙哥哥","sysOrgCode":"A01A03","id":"5","repairAge":22}],"total":4,"size":10,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"searchCount":true,"pages":1}
     * timestamp : 1608120942359
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
         * records : [{"post_dictText":"中级工程师","updateTime":"2020-10-16 21:31:51","userId":null,"headPicture":"temp/timg22_1602691158438.jpg","repairFactoryName":"维修厂1","createBy":"admin","post":"2","createTime":"2020-10-14 22:50:55","updateBy":"admin","phone":"16620164021","repairNum":20,"repairFactoryId":"1","name":"阳气","sysOrgCode":"A01A05","id":"1","repairAge":2},{"post_dictText":"初级工程师","updateTime":null,"userId":null,"headPicture":"temp/电脑_1603033093933.jpg","repairFactoryName":null,"createBy":"admin","post":"1","createTime":"2020-10-18 22:58:40","updateBy":null,"phone":"16620164036","repairNum":25,"repairFactoryId":null,"name":"圆通","sysOrgCode":"A01A03","id":"1317842538901229569","repairAge":3},{"post_dictText":"中级工程师","updateTime":null,"userId":null,"headPicture":"temp/timg22_1602691158438.jpg","repairFactoryName":"维修厂1","createBy":"admin","post":"2","createTime":"2020-10-14 23:34:55","updateBy":null,"phone":"16620164021","repairNum":2,"repairFactoryId":"1","name":"北京天津","sysOrgCode":"A01A03","id":"2","repairAge":2},{"post_dictText":"中级工程师","updateTime":"2020-10-16 21:25:36","userId":null,"headPicture":"temp/timg22_1602691158438.jpg","repairFactoryName":"维修厂1","createBy":"admin","post":"2","createTime":"2020-10-14 23:59:38","updateBy":"admin","phone":"16620164051","repairNum":222,"repairFactoryId":"1","name":"龙哥哥","sysOrgCode":"A01A03","id":"5","repairAge":22}]
         * total : 4
         * size : 10
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * searchCount : true
         * pages : 1
         */

        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        private List<EngineerData> records;

        public List<EngineerData> getRecords() {
            return records;
        }

        public void setRecords(List<EngineerData> records) {
            this.records = records;
        }

    }
}
