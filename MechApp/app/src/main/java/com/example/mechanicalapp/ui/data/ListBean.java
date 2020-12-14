package com.example.mechanicalapp.ui.data;


import com.example.mechanicalapp.ui.data.request.ReAddList;

import java.util.List;

//清单列表
public class ListBean extends NetData {


    /**
     * success : true
     * result : [{"total":200,"data":[{"id":"1335629771459067906","createBy":"16620164051","createTime":"2020-12-07 00:58:47","updateBy":null,"updateTime":null,"sysOrgCode":null,"repairOrderId":"1335606704619925505","type":"1","typeName":null,"name":"螺丝刀","aoumt":200,"partsId":"1","partsModelId":"1325250816702603266","partsModelCode":"k500","partsPicture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg_1604066143047.jpg","partsUnit":"台","partsNum":1,"partsPrice":200,"partsHandleType":"2","partsType":"配件1","partsHandleTypeName":"购买","repairPrice":null,"repairHours":null,"tarvelDate":null,"travelTrafficFee":null,"travelMealFee":null,"travelLiveFee":null,"travelOtherFee":null,"remark":"","status":"0","statusName":"审核中","stock":100}],"type":"配件"},{"total":36,"data":[{"id":"1335625185700675585","createBy":"16620164051","createTime":"2020-12-07 00:40:34","updateBy":"16620164051","updateTime":"2020-12-07 00:40:41","sysOrgCode":null,"repairOrderId":"1335606704619925505","type":"2","typeName":null,"name":"公式","aoumt":36,"partsId":null,"partsModelId":null,"partsModelCode":null,"partsPicture":null,"partsUnit":null,"partsNum":0,"partsPrice":null,"partsHandleType":null,"partsType":null,"partsHandleTypeName":null,"repairPrice":6,"repairHours":6,"tarvelDate":null,"travelTrafficFee":null,"travelMealFee":null,"travelLiveFee":null,"travelOtherFee":null,"remark":"","status":"0","statusName":"审核中","stock":0}],"type":"工时费"},{"total":18,"data":[{"id":"1335627850123902977","createBy":"16620164051","createTime":"2020-12-07 00:51:09","updateBy":null,"updateTime":null,"sysOrgCode":null,"repairOrderId":"1335606704619925505","type":"3","typeName":null,"name":"差旅费","aoumt":18,"partsId":null,"partsModelId":null,"partsModelCode":null,"partsPicture":null,"partsUnit":null,"partsNum":0,"partsPrice":null,"partsHandleType":null,"partsType":null,"partsHandleTypeName":null,"repairPrice":null,"repairHours":null,"tarvelDate":null,"travelTrafficFee":3,"travelMealFee":5,"travelLiveFee":5,"travelOtherFee":5,"remark":"","status":"0","statusName":"审核中","stock":0}],"type":"差旅费"},{"total":0,"data":[{"id":"1335629902916943873","createBy":"16620164051","createTime":"2020-12-07 00:59:18","updateBy":null,"updateTime":null,"sysOrgCode":null,"repairOrderId":"1335606704619925505","type":"4","typeName":null,"name":"项目","aoumt":0,"partsId":null,"partsModelId":null,"partsModelCode":null,"partsPicture":null,"partsUnit":null,"partsNum":0,"partsPrice":null,"partsHandleType":null,"partsType":null,"partsHandleTypeName":null,"repairPrice":null,"repairHours":null,"tarvelDate":null,"travelTrafficFee":null,"travelMealFee":null,"travelLiveFee":null,"travelOtherFee":5,"remark":null,"status":"0","statusName":"审核中","stock":0}],"type":"其他"}]
     * timestamp : 1607273968111
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
         * total : 200
         * data : [{"id":"1335629771459067906","createBy":"16620164051","createTime":"2020-12-07 00:58:47","updateBy":null,"updateTime":null,"sysOrgCode":null,"repairOrderId":"1335606704619925505","type":"1","typeName":null,"name":"螺丝刀","aoumt":200,"partsId":"1","partsModelId":"1325250816702603266","partsModelCode":"k500","partsPicture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/timg_1604066143047.jpg","partsUnit":"台","partsNum":1,"partsPrice":200,"partsHandleType":"2","partsType":"配件1","partsHandleTypeName":"购买","repairPrice":null,"repairHours":null,"tarvelDate":null,"travelTrafficFee":null,"travelMealFee":null,"travelLiveFee":null,"travelOtherFee":null,"remark":"","status":"0","statusName":"审核中","stock":100}]
         * type : 配件
         */

        private int total;
        private String type;
        private List<ReAddList> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ReAddList> getData() {
            return data;
        }

        public void setData(List<ReAddList> data) {
            this.data = data;
        }
    }
}
