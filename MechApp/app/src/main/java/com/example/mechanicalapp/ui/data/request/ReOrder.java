package com.example.mechanicalapp.ui.data.request;

import java.util.List;

public class ReOrder {
    private String memo;
    private List<ReOrderItemList> orderItemList;
    private String receiverId;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<ReOrderItemList> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<ReOrderItemList> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}
