package com.example.mechanicalapp.ui.data.request;

import java.io.Serializable;

public class ReAddress implements Serializable {


    /**
     * adress :
     * area :
     * areaId :
     * createBy :
     * createTime :
     * id :
     * isDefault :
     * name :
     * phone :
     * sysOrgCode :
     * updateBy :
     * updateTime :
     */

    private String adress;
    private String area;
    private String areaId;
    private String createBy;
    private String id;
    private int isDefault;
    private String name;
    private String phone;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
