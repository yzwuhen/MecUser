package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class GoodsDetails implements Serializable {

    /**
     * commentNum : 12
     * product : {"images":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg","price":234,"statusName":"在售","scale":324,"id":"4","detail":"<p>234<\/p>","title":"苹果999","status":"0"}
     * skuList : [{"id":"16038070877750329019","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:红,尺码:L","isDefault":null,"isActive":"N","stock":100,"marketPrice":null,"price":100,"sn":null,"picture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"},{"id":"16038070877751252347","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:红,尺码:XL","isDefault":null,"isActive":"N","stock":200,"marketPrice":null,"price":100,"sn":null,"picture":"https://p0.ssl.qhimgs1.com/sdr/400__/t01ec8974d062d0bcd6.jpg"},{"id":"16038070877752848955","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:黄,尺码:L","isDefault":null,"isActive":"N","stock":100,"marketPrice":null,"price":100,"sn":null,"picture":"https://p3.ssl.qhimgs1.com/sdr/400__/t017e2ddd05f182078d.jpg"},{"id":"16038070877753522841","createBy":"admin","createTime":"2020-10-27 21:58:17","updateBy":"admin","updateTime":"2020-10-29 19:03:42","sysOrgCode":"A01A03","mecProductId":"4","mecProductName":"苹果999","name":"颜色:黄,尺码:XL","isDefault":null,"isActive":"N","stock":400,"marketPrice":null,"price":100,"sn":null,"picture":"https://p0.ssl.qhimgs1.com/sdr/400__/t0184de37c47e6a7096.jpg"}]
     * skuNameList : [{"typeName":"颜色","nameList":["红,1","黄,1"]},{"typeName":"尺码","nameList":["X,1","M,0"]}]
     * comment : {"id":"2","createBy":"admin","createTime":"2020-09-22 21:24:35","updateBy":"admin","updateTime":"2020-09-22 21:27:02","sysOrgCode":"A01","mecProdId":"4","mecProdTitle":"666","mecProductSkuId":"2","mecProductSkuName":"红色,X","content":"sfsdfssfsdfssfsdfssfsdfssfsdfs","star":"1","commentUserId":"1","commentUserPhone":"13685487458","commentUserName":"张娜","commentUserHeader":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg"}
     */

    private int commentNum;
    private GoodsProduct product;
    private CommentData comment;
    private List<SkuListBean> skuList;
    private List<SkuNameListBean> skuNameList;

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public GoodsProduct getProduct() {
        return product;
    }

    public void setProduct(GoodsProduct product) {
        this.product = product;
    }

    public CommentData getComment() {
        return comment;
    }

    public void setComment(CommentData comment) {
        this.comment = comment;
    }

    public List<SkuListBean> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<SkuListBean> skuList) {
        this.skuList = skuList;
    }

    public List<SkuNameListBean> getSkuNameList() {
        return skuNameList;
    }

    public void setSkuNameList(List<SkuNameListBean> skuNameList) {
        this.skuNameList = skuNameList;
    }

    public static class SkuListBean implements Serializable{
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

    public static class SkuNameListBean {
        /**
         * typeName : 颜色
         * nameList : ["红,1","黄,1"]
         */

        private String typeName;
        private List<String> nameList;
        private List<Spec> mSpecList;

        public List<Spec> getmSpecList() {
            return mSpecList;
        }

        public void setmSpecList(List<Spec> mSpecList) {
            this.mSpecList = mSpecList;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public List<String> getNameList() {
            return nameList;
        }

        public void setNameList(List<String> nameList) {
            this.nameList = nameList;
        }
    }
}
