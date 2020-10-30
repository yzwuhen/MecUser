package com.example.mechanicalapp.ui.data

class LoginCodeBean : NetData() {

    /**
     * success : true
     * result : {"multi_depart":0,"userInfo":{"id":"1","username":"16620164051","realname":"16620164051","avatar":null,"birthday":null,"sex":null,"email":null,"phone":"16620164051","orgCode":null,"orgCodeTxt":null,"status":1,"delFlag":0,"workNo":null,"post":null,"telephone":null,"createBy":null,"createTime":"2020-10-16 20:49:24","updateBy":null,"updateTime":null,"activitiSync":0,"userIdentity":null,"departIds":null,"thirdType":null,"relTenantIds":null,"clientId":null,"mecApproveType":"1","userType":1},"sysAllDictItems":null,"departs":[],"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ2MDcyODMsInVzZXJuYW1lIjoiMTY2MjAxNjQwNTEifQ.9hwW0_bUktFcR3xGpFtXV3zjynh53stGEbOtEHLrMOg"}
     * timestamp : 1603959283950
     */
     var success = false
     var result: ResultBean? = null

    class ResultBean {
        /**
         * multi_depart : 0
         * userInfo : {"id":"1","username":"16620164051","realname":"16620164051","avatar":null,"birthday":null,"sex":null,"email":null,"phone":"16620164051","orgCode":null,"orgCodeTxt":null,"status":1,"delFlag":0,"workNo":null,"post":null,"telephone":null,"createBy":null,"createTime":"2020-10-16 20:49:24","updateBy":null,"updateTime":null,"activitiSync":0,"userIdentity":null,"departIds":null,"thirdType":null,"relTenantIds":null,"clientId":null,"mecApproveType":"1","userType":1}
         * sysAllDictItems : null
         * departs : []
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQ2MDcyODMsInVzZXJuYW1lIjoiMTY2MjAxNjQwNTEifQ.9hwW0_bUktFcR3xGpFtXV3zjynh53stGEbOtEHLrMOg
         */
        var multi_depart = 0
        var userInfo: UserInfoBean? = null
        var sysAllDictItems: Any? = null
        var token: String? = null
        var departs: List<*>? = null


    }


}