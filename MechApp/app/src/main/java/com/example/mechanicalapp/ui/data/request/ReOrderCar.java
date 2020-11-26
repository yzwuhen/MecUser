package com.example.mechanicalapp.ui.data.request;

import com.example.mechanicalapp.ui.data.ShopCarData;

import java.util.List;

public class ReOrderCar {
    private String memo;
    private List<ShopCarData> shoppingCardList;
    private String receiverId;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public List<ShopCarData> getShoppingCardList() {
        return shoppingCardList;
    }

    public void setShoppingCardList(List<ShopCarData> shoppingCardList) {
        this.shoppingCardList = shoppingCardList;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
}
