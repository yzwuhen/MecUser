package com.example.mechanicalapp.ui.data.request;

public class ReAddCar {


    /**
     * amount : 0
     * createBy :
     * createTime :
     * id :
     * picture :
     * price : 0
     * productId :
     * productName :
     * quantity : 0
     * skuId :
     * skuName :
     * stock : 0
     * sysOrgCode :
     * title :
     * type :
     * updateBy :
     * updateTime :
     */

    private String productId;
    private int quantity;//数量
    private String skuId;
    private int type =0;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
