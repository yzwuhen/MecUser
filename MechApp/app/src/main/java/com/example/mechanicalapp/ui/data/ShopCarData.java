package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class ShopCarData implements Serializable {
    /**
     * amount : null
     * quantity : 1
     * productId : 4
     * type_dictText : null
     * updateTime : null
     * title : null
     * type : null
     * productName : 苹果999
     * picture : null
     * skuName : 颜色:黄,尺码:M
     * createBy : null
     * createTime : null
     * updateBy : null
     * price : 100
     * sysOrgCode : null
     * id : 1330901212186374146
     * stock : 97
     * skuId : 16061452639243882418
     */

    private Object amount;
    private int quantity;
    private String productId;
    private Object type_dictText;
    private Object updateTime;
    private Object title;
    private Object type;
    private String productName;
    private String picture;
    private String skuName;
    private Object createBy;
    private Object createTime;
    private Object updateBy;
    private int price;
    private Object sysOrgCode;
    private String id;
    private int stock;
    private String skuId;
    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Object getType_dictText() {
        return type_dictText;
    }

    public void setType_dictText(Object type_dictText) {
        this.type_dictText = type_dictText;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
        this.createBy = createBy;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Object updateBy) {
        this.updateBy = updateBy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(Object sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
}
