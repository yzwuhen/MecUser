package com.example.mechanicalapp.ui.data.request;

import java.io.Serializable;

public class ReOrderItemList implements Serializable {
    private String mecProductSkuId;
    private int quantity;



    public String getMecProductSkuId() {
        return mecProductSkuId;
    }

    public void setMecProductSkuId(String mecProductSkuId) {
        this.mecProductSkuId = mecProductSkuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
