package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class NotificationData implements Serializable {


    /**
     * repairOrder : {"orderId":"1353637566942916609","orderNum":"120210125173519979812","status":"1","statusName":"待上门"}
     */

    private RepairOrderBean repairOrder;

    public RepairOrderBean getRepairOrder() {
        return repairOrder;
    }

    public void setRepairOrder(RepairOrderBean repairOrder) {
        this.repairOrder = repairOrder;
    }

    public static class RepairOrderBean {
        /**
         * orderId : 1353637566942916609
         * orderNum : 120210125173519979812
         * status : 1
         * statusName : 待上门
         */

        private String orderId;
        private String orderNum;
        private int status;
        private String statusName;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStatusName() {
            return statusName;
        }

        public void setStatusName(String statusName) {
            this.statusName = statusName;
        }
    }
}
