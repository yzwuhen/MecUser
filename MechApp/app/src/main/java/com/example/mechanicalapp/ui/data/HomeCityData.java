package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class HomeCityData implements Serializable {

    /**
     * id : 110100
     * createBy : null
     * createTime : null
     * updateBy : null
     * updateTime : null
     * sysOrgCode : null
     * pid : 110000
     * hasChild : 1
     * name : 北京市
     * mergername : 中国,北京,北京市
     * shortName : 北京
     * cityCode : 010
     * zipCode : 100000
     * lng : 116.405285
     * lat : 39.904989
     * spelling : Beijing
     * type : 2
     * isHot : 1
     */

    private String id;
    private String pid;
    private String hasChild;
    private String name;
    private String mergername;
    private String shortName;
    private String cityCode;
    private String zipCode;
    private String lng;
    private String lat;
    private String spelling;
    private int type;
    private int isHot;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMergername() {
        return mergername;
    }

    public void setMergername(String mergername) {
        this.mergername = mergername;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }
}
