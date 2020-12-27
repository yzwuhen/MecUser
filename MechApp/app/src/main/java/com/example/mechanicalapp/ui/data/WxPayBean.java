package com.example.mechanicalapp.ui.data;

import com.google.gson.annotations.SerializedName;

public class WxPayBean extends NetData {

    /**
     * success : true
     * result : {"msg":{"appid":"wxcee9e76d06d68a8f","noncestr":"6MflMcy0mCJFxenS","package":"Sign=WXPay","partnerid":"1604614018","prepayid":"wx16113849008578795e19f2b3ed8cb10000","sign":"834C71E910DDEFF1F41AC9C9D8AD341E","timestamp":1608089929},"code":"200"}
     * timestamp : 1608089929043
     */

    private boolean success;
    private ResultBean result;
    private long timestamp;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class ResultBean {
        /**
         * msg : {"appid":"wxcee9e76d06d68a8f","noncestr":"6MflMcy0mCJFxenS","package":"Sign=WXPay","partnerid":"1604614018","prepayid":"wx16113849008578795e19f2b3ed8cb10000","sign":"834C71E910DDEFF1F41AC9C9D8AD341E","timestamp":1608089929}
         * code : 200
         */

        private MsgBean msg;
        @SerializedName("code")
        private String codeX;

        public MsgBean getMsg() {
            return msg;
        }

        public void setMsg(MsgBean msg) {
            this.msg = msg;
        }

        public String getCodeX() {
            return codeX;
        }

        public void setCodeX(String codeX) {
            this.codeX = codeX;
        }

        public static class MsgBean {
            /**
             * appid : wxcee9e76d06d68a8f
             * noncestr : 6MflMcy0mCJFxenS
             * package : Sign=WXPay
             * partnerid : 1604614018
             * prepayid : wx16113849008578795e19f2b3ed8cb10000
             * sign : 834C71E910DDEFF1F41AC9C9D8AD341E
             * timestamp : 1608089929
             */

            private String appid;
            private String noncestr;
            @SerializedName("package")
            private String packageX;
            private String partnerid;
            private String prepayid;
            private String sign;
            private String timestamp;

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
