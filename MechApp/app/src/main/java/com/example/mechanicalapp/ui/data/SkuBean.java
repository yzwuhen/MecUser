package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class SkuBean implements Serializable {
    private int num;
    private SkuListData skuListData;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public SkuListData getSkuListData() {
        return skuListData;
    }

    public void setSkuListData(SkuListData skuListData) {
        this.skuListData = skuListData;
    }
}
