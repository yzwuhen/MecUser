package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class GoodsDetails implements Serializable {
    /**
     * id : 4
     * createBy : admin
     * createTime : 2020-09-30 14:43:12
     * updateBy : admin
     * updateTime : 2020-10-29 19:03:42
     * sysOrgCode : A01
     * title : 苹果999
     * img : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg
     * price : 234
     * scale : 324
     * stockNum : 324
     * productCategory : 1320750703951163393
     * productDetailInfo : <p>234</p>
     * isHot : 1
     * isOn : 1
     * isBaoyou : 0
     * skuList : [{"id":"16038070877750329019","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:红,尺码:L","isDefault":null,"isActive":"N","stock":100,"marketPrice":null,"price":100,"sn":null,"picture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"},{"id":"16038070877751252347","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:红,尺码:XL","isDefault":null,"isActive":"N","stock":200,"marketPrice":null,"price":100,"sn":null,"picture":"https://p0.ssl.qhimgs1.com/sdr/400__/t01ec8974d062d0bcd6.jpg"},{"id":"16038070877752848955","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:黄,尺码:L","isDefault":null,"isActive":"N","stock":100,"marketPrice":null,"price":100,"sn":null,"picture":"https://p3.ssl.qhimgs1.com/sdr/400__/t017e2ddd05f182078d.jpg"},{"id":"16038070877753522841","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:黄,尺码:XL","isDefault":null,"isActive":"N","stock":400,"marketPrice":null,"price":100,"sn":null,"picture":"https://p0.ssl.qhimgs1.com/sdr/400__/t0184de37c47e6a7096.jpg"}]
     * skuNames : [["颜色:红","颜色:黄"],["尺码:X","尺码:M"]]
     * pid : 1320750703951163393
     * freightRules : 1311661883934846978,1311661992240164866,1311678504644571137
     * weight : 1
     * status : 0
     * skuItems : [["颜色:红","颜色:黄"],["尺码:X","尺码:M"]]
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
    private String skuNames;
    private String pid;
    private String freightRules;
    private int weight;
    private String status;
    private List<SkuListBean> skuList;
    private List<List<String>> skuItems;

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

    public String getSkuNames() {
        return skuNames;
    }

    public void setSkuNames(String skuNames) {
        this.skuNames = skuNames;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getFreightRules() {
        return freightRules;
    }

    public void setFreightRules(String freightRules) {
        this.freightRules = freightRules;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SkuListBean> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuListBean> skuList) {
        this.skuList = skuList;
    }

    public List<List<String>> getSkuItems() {
        return skuItems;
    }

    public void setSkuItems(List<List<String>> skuItems) {
        this.skuItems = skuItems;
    }

    public static class SkuListBean {
        /**
         * id : 16038070877750329019
         * createBy : admin
         * createTime : 2020-10-27 21:58:17
         * updateBy : admin
         * updateTime : 2020-10-29 19:03:42
         * sysOrgCode : A01A03
         * mecProductId : 4
         * mecProductName : 苹果999
         * name : 颜色:红,尺码:L
         * isDefault : null
         * isActive : N
         * stock : 100
         * marketPrice : null
         * price : 100
         * sn : null
         * picture : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg
         */

        private String id;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String sysOrgCode;
        private String mecProductId;
        private String mecProductName;
        private String name;
        private Object isDefault;
        private String isActive;
        private int stock;
        private Object marketPrice;
        private int price;
        private Object sn;
        private String picture;

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

        public String getMecProductId() {
            return mecProductId;
        }

        public void setMecProductId(String mecProductId) {
            this.mecProductId = mecProductId;
        }

        public String getMecProductName() {
            return mecProductName;
        }

        public void setMecProductName(String mecProductName) {
            this.mecProductName = mecProductName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Object isDefault) {
            this.isDefault = isDefault;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public Object getMarketPrice() {
            return marketPrice;
        }

        public void setMarketPrice(Object marketPrice) {
            this.marketPrice = marketPrice;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Object getSn() {
            return sn;
        }

        public void setSn(Object sn) {
            this.sn = sn;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }

}
