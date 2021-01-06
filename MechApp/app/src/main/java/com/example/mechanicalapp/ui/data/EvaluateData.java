package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

/**
 * 评价的回显信息
 */
public class EvaluateData implements Serializable {

    /**
     * id : 1344575215706841089
     * createBy : 13751773402
     * createTime : 2020-12-31 17:24:47
     * updateBy : null
     * updateTime : null
     * sysOrgCode : null
     * mecProdId : null
     * mecProdTitle : null
     * mecProductSkuId : 16061453525181615290
     * mecProductSkuName : 红,M
     * content : 12
     * star : 5
     * commentUserId : null
     * commentUserPhone : null
     * commentUserName : null
     * commentUserHeader : null
     * mecOrderId : 020201231103803899930
     * mecOrderItemId : 1331173915724132353
     * total : null
     * goodCount : null
     * midCount : null
     * badCount : null
     * partNum : 1
     * prices : 234
     * totalMoney : 234
     * freight : 0
     */

    private String id;
    private String mecProductSkuName;
    private String content;
    private String star;
    private String mecOrderId;
    private String mecOrderItemId;
    private int partNum;
    private int prices;
    private int totalMoney;
    private int freight;
    private String productSkuImg;
    private String prodName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMecProductSkuName() {
        return mecProductSkuName;
    }

    public void setMecProductSkuName(String mecProductSkuName) {
        this.mecProductSkuName = mecProductSkuName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getMecOrderId() {
        return mecOrderId;
    }

    public void setMecOrderId(String mecOrderId) {
        this.mecOrderId = mecOrderId;
    }

    public String getMecOrderItemId() {
        return mecOrderItemId;
    }

    public void setMecOrderItemId(String mecOrderItemId) {
        this.mecOrderItemId = mecOrderItemId;
    }

    public int getPartNum() {
        return partNum;
    }

    public void setPartNum(int partNum) {
        this.partNum = partNum;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

    public String getProductSkuImg() {
        return productSkuImg;
    }

    public void setProductSkuImg(String productSkuImg) {
        this.productSkuImg = productSkuImg;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
