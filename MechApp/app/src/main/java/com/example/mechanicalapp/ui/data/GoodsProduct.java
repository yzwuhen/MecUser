package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class GoodsProduct implements Serializable {
    /**
     * images : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603806815224.jpg,https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/电脑_1603806819443.jpg
     * price : 234
     * statusName : 在售
     * scale : 324
     * id : 4
     * detail : <p>234</p>
     * title : 苹果999
     * status : 0
     */

    private String images;
    private int price;
    private String statusName;
    private int scale;
    private String id;
    private String detail;
    private String title;
    private String status;
    private String shareUrl;

    public String getShareUrl() {
        return shareUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
