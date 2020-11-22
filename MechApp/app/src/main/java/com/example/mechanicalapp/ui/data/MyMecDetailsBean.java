package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class MyMecDetailsBean  extends NetData{

    /**
     * success : true
     * result : {"id":"1330042031782772738","createBy":"13751773402","createTime":"2020-11-21 14:55:06","updateBy":null,"updateTime":null,"sysOrgCode":"A02","titile":"默写","cateId":"1321476604976406530","brandId":"1","modelId":"1326574064199434242","price":0,"workTime":"69","facDate":"2020-11-21","gpsLon":"113.939388","gpsLat":"22.681693","isNew":null,"city":"深圳市","isPerson":null,"isEnterprise":null,"cateName":"挖掘机","brandName":"长城","modelName":"awd-663","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/IMG_20201015_21164354_1605941694672.jpg,","briefDesc":"哦哦","purchaseDate":"2020-11-24","address":"广东省深圳市 宝安区"}
     * timestamp : 1605943400688
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * id : 1330042031782772738
         * createBy : 13751773402
         * createTime : 2020-11-21 14:55:06
         * updateBy : null
         * updateTime : null
         * sysOrgCode : A02
         * titile : 默写
         * cateId : 1321476604976406530
         * brandId : 1
         * modelId : 1326574064199434242
         * price : 0
         * workTime : 69
         * facDate : 2020-11-21
         * gpsLon : 113.939388
         * gpsLat : 22.681693
         * isNew : null
         * city : 深圳市
         * isPerson : null
         * isEnterprise : null
         * cateName : 挖掘机
         * brandName : 长城
         * modelName : awd-663
         * pic : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/IMG_20201015_21164354_1605941694672.jpg,
         * briefDesc : 哦哦
         * purchaseDate : 2020-11-24
         * address : 广东省深圳市 宝安区
         */

        private String id;
        private String createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private String sysOrgCode;
        private String titile;
        private String cateId;
        private String brandId;
        private String modelId;
        private int price;
        private String workTime;
        private String facDate;
        private String gpsLon;
        private String gpsLat;
        private Object isNew;
        private String city;
        private Object isPerson;
        private Object isEnterprise;
        private String cateName;
        private String brandName;
        private String modelName;
        private String pic;
        private String briefDesc;
        private String purchaseDate;
        private String address;

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

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getSysOrgCode() {
            return sysOrgCode;
        }

        public void setSysOrgCode(String sysOrgCode) {
            this.sysOrgCode = sysOrgCode;
        }

        public String getTitile() {
            return titile;
        }

        public void setTitile(String titile) {
            this.titile = titile;
        }

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getModelId() {
            return modelId;
        }

        public void setModelId(String modelId) {
            this.modelId = modelId;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getWorkTime() {
            return workTime;
        }

        public void setWorkTime(String workTime) {
            this.workTime = workTime;
        }

        public String getFacDate() {
            return facDate;
        }

        public void setFacDate(String facDate) {
            this.facDate = facDate;
        }

        public String getGpsLon() {
            return gpsLon;
        }

        public void setGpsLon(String gpsLon) {
            this.gpsLon = gpsLon;
        }

        public String getGpsLat() {
            return gpsLat;
        }

        public void setGpsLat(String gpsLat) {
            this.gpsLat = gpsLat;
        }

        public Object getIsNew() {
            return isNew;
        }

        public void setIsNew(Object isNew) {
            this.isNew = isNew;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getIsPerson() {
            return isPerson;
        }

        public void setIsPerson(Object isPerson) {
            this.isPerson = isPerson;
        }

        public Object getIsEnterprise() {
            return isEnterprise;
        }

        public void setIsEnterprise(Object isEnterprise) {
            this.isEnterprise = isEnterprise;
        }

        public String getCateName() {
            return cateName;
        }

        public void setCateName(String cateName) {
            this.cateName = cateName;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public String getPurchaseDate() {
            return purchaseDate;
        }

        public void setPurchaseDate(String purchaseDate) {
            this.purchaseDate = purchaseDate;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
