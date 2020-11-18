package com.example.mechanicalapp.ui.data;

public class IntegralBean extends NetData {

    /**
     * success : true
     * result : {"id":"1327536960469729281","createBy":"13751773402","createTime":"2020-11-14 17:00:50","updateBy":"13751773402","updateTime":"2020-11-18 15:45:45","sysOrgCode":"A02","points":99885,"isSignIn":0,"signInDay":null}
     * timestamp : 1605692688376
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
         * id : 1327536960469729281
         * createBy : 13751773402
         * createTime : 2020-11-14 17:00:50
         * updateBy : 13751773402
         * updateTime : 2020-11-18 15:45:45
         * sysOrgCode : A02
         * points : 99885
         * isSignIn : 0
         * signInDay : null
         */

        private String id;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String sysOrgCode;
        private int points;
        private int isSignIn;
        private int signInDay;

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

        public String getSysOrgCode() {
            return sysOrgCode;
        }

        public void setSysOrgCode(String sysOrgCode) {
            this.sysOrgCode = sysOrgCode;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getIsSignIn() {
            return isSignIn;
        }

        public void setIsSignIn(int isSignIn) {
            this.isSignIn = isSignIn;
        }

        public int getSignInDay() {
            return signInDay;
        }

        public void setSignInDay(int signInDay) {
            this.signInDay = signInDay;
        }
    }
}
