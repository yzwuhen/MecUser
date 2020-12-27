package com.example.mechanicalapp.ui.data;

import java.util.List;

public class WorkTypeBean extends NetData {

    /**
     * success : true
     * result : [{"id":"1327629521653858305","createBy":"admin","createTime":"2020-11-14 23:08:38","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"通用工种","ishot":null,"orderNum":null,"pid":"0","hasChild":"1","childList":[{"id":"1327630623413633026","createBy":"admin","createTime":"2020-11-14 23:13:01","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"汽车吊","ishot":null,"orderNum":null,"pid":"1327629521653858305","hasChild":"0"},{"id":"1327630672004644865","createBy":"admin","createTime":"2020-11-14 23:13:13","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"泵车驾驶","ishot":null,"orderNum":null,"pid":"1327629521653858305","hasChild":"0"}]},{"id":"1327629602310324225","createBy":"admin","createTime":"2020-11-14 23:08:58","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"驾驶员","ishot":null,"orderNum":null,"pid":"0","hasChild":"1","childList":[{"id":"1327630527800279042","createBy":"admin","createTime":"2020-11-14 23:12:38","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"旋挖机驾驶员","ishot":null,"orderNum":null,"pid":"1327629602310324225","hasChild":"0"},{"id":"1327630583379001345","createBy":"admin","createTime":"2020-11-14 23:12:52","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"推土机驾驶员","ishot":null,"orderNum":null,"pid":"1327629602310324225","hasChild":"0"}]},{"id":"1327629701140709378","createBy":"admin","createTime":"2020-11-14 23:09:21","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"其他工种","ishot":null,"orderNum":null,"pid":"0","hasChild":"1","childList":[{"id":"1327629814361751553","createBy":"admin","createTime":"2020-11-14 23:09:48","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"挖掘机工种","ishot":null,"orderNum":null,"pid":"1327629701140709378","hasChild":null}]}]
     * timestamp : 1607507716680
     */

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1327629521653858305
         * createBy : admin
         * createTime : 2020-11-14 23:08:38
         * updateBy : null
         * updateTime : null
         * sysOrgCode : A01A03
         * cateName : 通用工种
         * ishot : null
         * orderNum : null
         * pid : 0
         * hasChild : 1
         * childList : [{"id":"1327630623413633026","createBy":"admin","createTime":"2020-11-14 23:13:01","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"汽车吊","ishot":null,"orderNum":null,"pid":"1327629521653858305","hasChild":"0"},{"id":"1327630672004644865","createBy":"admin","createTime":"2020-11-14 23:13:13","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"泵车驾驶","ishot":null,"orderNum":null,"pid":"1327629521653858305","hasChild":"0"}]
         */

        private String id;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private String sysOrgCode;
        private String cateName;
        private Object ishot;
        private Object orderNum;
        private String pid;
        private String hasChild;
        private List<WorkTypeData> childList;
        private boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getSysOrgCode() {
            return sysOrgCode;
        }

        public void setSysOrgCode(String sysOrgCode) {
            this.sysOrgCode = sysOrgCode;
        }

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public Object getIshot() {
            return ishot;
        }

        public void setIshot(Object ishot) {
            this.ishot = ishot;
        }

        public Object getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(Object orderNum) {
            this.orderNum = orderNum;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getHasChild() {
            return hasChild;
        }

        public void setHasChild(String hasChild) {
            this.hasChild = hasChild;
        }

        public List<WorkTypeData> getChildList() {
            return childList;
        }

        public void setChildList(List<WorkTypeData> childList) {
            this.childList = childList;
        }

    }
}
