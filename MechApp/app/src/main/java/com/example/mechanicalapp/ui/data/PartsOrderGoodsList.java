package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

/**
 * 订单的商品了i列表
 */
public class PartsOrderGoodsList implements Serializable {

    private int productSum;
    private Object thumbnail;
    private int quantity;
    private String orderId;
    private String productSkuImg;
    private Object freight;
    private Object weight;
    private Object updateTime;
    private Object isBaoyou;
    private String skuName;
    private int totalSum;
    private String createBy;
    private Object isDelivery;
    private String createTime;
    private Object updateBy;
    private int price;
    private String prodName;
    private String sysOrgCode;
    private String id;
    private String mecProductSkuId;
    private String start="3";

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public int getProductSum() {
        return productSum;
    }

    public void setProductSum(int productSum) {
        this.productSum = productSum;
    }

    public Object getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Object thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductSkuImg() {
        return productSkuImg;
    }

    public void setProductSkuImg(String productSkuImg) {
        this.productSkuImg = productSkuImg;
    }

    public Object getFreight() {
        return freight;
    }

    public void setFreight(Object freight) {
        this.freight = freight;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getIsBaoyou() {
        return isBaoyou;
    }

    public void setIsBaoyou(Object isBaoyou) {
        this.isBaoyou = isBaoyou;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Object getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Object isDelivery) {
        this.isDelivery = isDelivery;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMecProductSkuId() {
        return mecProductSkuId;
    }

    public void setMecProductSkuId(String mecProductSkuId) {
        this.mecProductSkuId = mecProductSkuId;
    }
}
