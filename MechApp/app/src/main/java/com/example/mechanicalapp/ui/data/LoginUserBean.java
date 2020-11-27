package com.example.mechanicalapp.ui.data;

import java.util.List;

public class LoginUserBean extends NetData {

    /**
     * success : true
     * result : {"multi_depart":1,"userInfo":{"id":"9782f2efca204780accf686c6aa5da6e","username":"13751773402","nickName":null,"realname":"yz","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","birthday":"2020-10-16","sex":1,"email":"95454151@qq.com","phone":"13751773402","orgCode":"A02","orgCodeTxt":null,"status":1,"delFlag":0,"workNo":"0001","post":"devleader","telephone":null,"createBy":"admin","createTime":"2020-10-24 22:45:20","updateBy":null,"updateTime":null,"activitiSync":1,"userIdentity":1,"departIds":"","thirdType":null,"relTenantIds":"1","clientId":null,"mecApproveType":"1","userType":0,"isPerson":null,"isEnterprise":null,"isRepair":null},"sysAllDictItems":null,"departs":[{"id":"6d35e179cd814e3299bd588ea7daed3f","parentId":"","departName":"北京卓尔互动","departNameEn":null,"departNameAbbr":null,"departOrder":0,"description":null,"orgCategory":"1","orgType":"1","orgCode":"A02","mobile":null,"fax":null,"address":null,"memo":null,"status":null,"delFlag":"0","createBy":"admin","createTime":"2019-02-26 16:36:39","updateBy":"admin","updateTime":"2020-05-02 18:21:22"}],"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ3NDAwNTgsInVzZXJuYW1lIjoiMTM3NTE3NzM0MDIifQ.ESZdnVyGsMWwogNjuLSBbtDUzXZMQHePYqRGn8S0ZQU"}
     * timestamp : 1606443025477
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
         * multi_depart : 1
         * userInfo : {"id":"9782f2efca204780accf686c6aa5da6e","username":"13751773402","nickName":null,"realname":"yz","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","birthday":"2020-10-16","sex":1,"email":"95454151@qq.com","phone":"13751773402","orgCode":"A02","orgCodeTxt":null,"status":1,"delFlag":0,"workNo":"0001","post":"devleader","telephone":null,"createBy":"admin","createTime":"2020-10-24 22:45:20","updateBy":null,"updateTime":null,"activitiSync":1,"userIdentity":1,"departIds":"","thirdType":null,"relTenantIds":"1","clientId":null,"mecApproveType":"1","userType":0,"isPerson":null,"isEnterprise":null,"isRepair":null}
         * sysAllDictItems : null
         * departs : [{"id":"6d35e179cd814e3299bd588ea7daed3f","parentId":"","departName":"北京卓尔互动","departNameEn":null,"departNameAbbr":null,"departOrder":0,"description":null,"orgCategory":"1","orgType":"1","orgCode":"A02","mobile":null,"fax":null,"address":null,"memo":null,"status":null,"delFlag":"0","createBy":"admin","createTime":"2019-02-26 16:36:39","updateBy":"admin","updateTime":"2020-05-02 18:21:22"}]
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ3NDAwNTgsInVzZXJuYW1lIjoiMTM3NTE3NzM0MDIifQ.ESZdnVyGsMWwogNjuLSBbtDUzXZMQHePYqRGn8S0ZQU
         */

        private int multi_depart;
        private UserInfo userInfo;
        private Object sysAllDictItems;
        private String token;
        private List<DepartsBean> departs;

        public int getMulti_depart() {
            return multi_depart;
        }

        public void setMulti_depart(int multi_depart) {
            this.multi_depart = multi_depart;
        }

        public UserInfo getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
        }

        public Object getSysAllDictItems() {
            return sysAllDictItems;
        }

        public void setSysAllDictItems(Object sysAllDictItems) {
            this.sysAllDictItems = sysAllDictItems;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<DepartsBean> getDeparts() {
            return departs;
        }

        public void setDeparts(List<DepartsBean> departs) {
            this.departs = departs;
        }


        public static class DepartsBean {
            /**
             * id : 6d35e179cd814e3299bd588ea7daed3f
             * parentId :
             * departName : 北京卓尔互动
             * departNameEn : null
             * departNameAbbr : null
             * departOrder : 0
             * description : null
             * orgCategory : 1
             * orgType : 1
             * orgCode : A02
             * mobile : null
             * fax : null
             * address : null
             * memo : null
             * status : null
             * delFlag : 0
             * createBy : admin
             * createTime : 2019-02-26 16:36:39
             * updateBy : admin
             * updateTime : 2020-05-02 18:21:22
             */

            private String id;
            private String parentId;
            private String departName;
            private Object departNameEn;
            private Object departNameAbbr;
            private int departOrder;
            private Object description;
            private String orgCategory;
            private String orgType;
            private String orgCode;
            private Object mobile;
            private Object fax;
            private Object address;
            private Object memo;
            private Object status;
            private String delFlag;
            private String createBy;
            private String createTime;
            private String updateBy;
            private String updateTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getDepartName() {
                return departName;
            }

            public void setDepartName(String departName) {
                this.departName = departName;
            }

            public Object getDepartNameEn() {
                return departNameEn;
            }

            public void setDepartNameEn(Object departNameEn) {
                this.departNameEn = departNameEn;
            }

            public Object getDepartNameAbbr() {
                return departNameAbbr;
            }

            public void setDepartNameAbbr(Object departNameAbbr) {
                this.departNameAbbr = departNameAbbr;
            }

            public int getDepartOrder() {
                return departOrder;
            }

            public void setDepartOrder(int departOrder) {
                this.departOrder = departOrder;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public String getOrgCategory() {
                return orgCategory;
            }

            public void setOrgCategory(String orgCategory) {
                this.orgCategory = orgCategory;
            }

            public String getOrgType() {
                return orgType;
            }

            public void setOrgType(String orgType) {
                this.orgType = orgType;
            }

            public String getOrgCode() {
                return orgCode;
            }

            public void setOrgCode(String orgCode) {
                this.orgCode = orgCode;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public Object getFax() {
                return fax;
            }

            public void setFax(Object fax) {
                this.fax = fax;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getMemo() {
                return memo;
            }

            public void setMemo(Object memo) {
                this.memo = memo;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
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

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
