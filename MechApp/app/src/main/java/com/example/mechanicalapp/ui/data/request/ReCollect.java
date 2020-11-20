package com.example.mechanicalapp.ui.data.request;

public class ReCollect {
    private String storeId;
    private int  type;//0 ->商品 1->维修厂 2->配件 3->二手（买卖） 4-> 机械 5-》招聘

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
