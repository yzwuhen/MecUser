package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class GoodsData implements Serializable {


    /**
     * id : 12
     * createBy : admin
     * createTime : 2020-10-29 20:57:20
     * updateBy : admin
     * updateTime : 2020-10-29 22:27:07
     * sysOrgCode : A01A03
     * title : 茶叶
     * img : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/我的_1603976214129.jpg
     * price : 234
     * scale : 234
     * stockNum : 100
     * productCategory : 1320751194684731393
     * productDetailInfo : <p>234</p>
     * isHot : 1
     * isOn : 1
     * isBaoyou : 1
     * skuList : null
     * skuNames : [["颜色:红","颜色:黄"],["尺码:X","尺码:M"]]
     * pid : null
     * freightRules : 1
     * weight : null
     * status : 0
     * skuItems : null
     * storeId : null
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String title;
    private String img;
    private int price;
    private int scale;
    private int stockNum;
    private String productCategory;
    private String productDetailInfo;
    private int isHot;
    private int isOn;
    private int isBaoyou;
    private Object skuList;
    private String skuNames;
    private Object pid;
    private String freightRules;
    private Object weight;
    private String status;
    private Object skuItems;
    private Object storeId;

    private boolean isSelect;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDetailInfo() {
        return productDetailInfo;
    }

    public void setProductDetailInfo(String productDetailInfo) {
        this.productDetailInfo = productDetailInfo;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }

    public int getIsOn() {
        return isOn;
    }

    public void setIsOn(int isOn) {
        this.isOn = isOn;
    }

    public int getIsBaoyou() {
        return isBaoyou;
    }

    public void setIsBaoyou(int isBaoyou) {
        this.isBaoyou = isBaoyou;
    }

    public Object getSkuList() {
        return skuList;
    }

    public void setSkuList(Object skuList) {
        this.skuList = skuList;
    }

    public String getSkuNames() {
        return skuNames;
    }

    public void setSkuNames(String skuNames) {
        this.skuNames = skuNames;
    }

    public Object getPid() {
        return pid;
    }

    public void setPid(Object pid) {
        this.pid = pid;
    }

    public String getFreightRules() {
        return freightRules;
    }

    public void setFreightRules(String freightRules) {
        this.freightRules = freightRules;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getSkuItems() {
        return skuItems;
    }

    public void setSkuItems(Object skuItems) {
        this.skuItems = skuItems;
    }

    public Object getStoreId() {
        return storeId;
    }

    public void setStoreId(Object storeId) {
        this.storeId = storeId;
    }
}
