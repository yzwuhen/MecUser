package com.example.mechanicalapp.ui.data.request;

import android.text.TextUtils;

/**
 * 添加清单
 */
public class ReAddList {


    /**
     * aoumt : 0
     * createBy :
     * createTime :
     * id :
     * name :
     * partsHandleType :
     * partsHandleTypeName :
     * partsId :
     * partsModelCode :
     * partsModelId :
     * partsNum : 0
     * partsPicture :
     * partsPrice : 0
     * partsType :
     * partsUnit :
     * remark :
     * repairHours : 0
     * repairOrderId :
     * repairPrice : 0
     * status :
     * statusName :
     * sysOrgCode :
     * tarvelDate :
     * travelLiveFee : 0
     * travelMealFee : 0
     * travelOtherFee : 0
     * travelTrafficFee : 0
     * type :
     * typeName :
     * updateBy :
     * updateTime :
     */

    private String aoumt;
    private String createBy;
    private String createTime;
    private String id;
    private String name;
    private String partsHandleType;
    private String partsHandleTypeName;
    private String partsId;
    private String partsModelCode;
    private String partsModelId;
    private int partsNum;
    private String partsPicture;
    private String partsPrice;
    private String partsType;
    private String partsUnit;
    private String remark;
    private String repairHours;
    private String repairOrderId;
    private String repairPrice;
    private String status;
    private String statusName;
    private String sysOrgCode;
    private String tarvelDate;
    private String travelLiveFee;
    private String travelMealFee;
    private String travelOtherFee;
    private String travelTrafficFee;
    private String type;
    private String typeName;
    private String updateBy;
    private String updateTime;

    private boolean isShow;
    private boolean isAdd;

    private String partsTypeName;
    private String partsModelName;
    private String stock;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPartsTypeName() {
        return partsTypeName;
    }

    public void setPartsTypeName(String partsTypeName) {
        this.partsTypeName = partsTypeName;
    }

    public String getPartsModelName() {
        return partsModelName;
    }

    public void setPartsModelName(String partsModelName) {
        this.partsModelName = partsModelName;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }

    public String getAoumt() {
        return aoumt;
    }

    public void setAoumt(String aoumt) {
        this.aoumt = aoumt;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartsHandleType() {
        return partsHandleType;
    }

    public void setPartsHandleType(String partsHandleType) {
        this.partsHandleType = partsHandleType;
    }

    public String getPartsHandleTypeName() {
        return TextUtils.isEmpty(partsHandleTypeName)?"":partsHandleTypeName;
    }

    public void setPartsHandleTypeName(String partsHandleTypeName) {
        this.partsHandleTypeName = partsHandleTypeName;
    }

    public String getPartsId() {
        return partsId;
    }

    public void setPartsId(String partsId) {
        this.partsId = partsId;
    }

    public String getPartsModelCode() {
        return partsModelCode;
    }

    public void setPartsModelCode(String partsModelCode) {
        this.partsModelCode = partsModelCode;
    }

    public String getPartsModelId() {
        return partsModelId;
    }

    public void setPartsModelId(String partsModelId) {
        this.partsModelId = partsModelId;
    }

    public int getPartsNum() {
        return partsNum;
    }

    public void setPartsNum(int partsNum) {
        this.partsNum = partsNum;
    }

    public String getPartsPicture() {
        return partsPicture;
    }

    public void setPartsPicture(String partsPicture) {
        this.partsPicture = partsPicture;
    }

    public String getPartsPrice() {
        return TextUtils.isEmpty(partsPrice)?"0":partsPrice;
    }

    public void setPartsPrice(String partsPrice) {
        this.partsPrice = partsPrice;
    }

    public String getPartsType() {
        return partsType;
    }

    public void setPartsType(String partsType) {
        this.partsType = partsType;
    }

    public String getPartsUnit() {
        return partsUnit;
    }

    public void setPartsUnit(String partsUnit) {
        this.partsUnit = partsUnit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRepairHours() {
        return repairHours;
    }

    public void setRepairHours(String repairHours) {
        this.repairHours = repairHours;
    }

    public String getRepairOrderId() {
        return repairOrderId;
    }

    public void setRepairOrderId(String repairOrderId) {
        this.repairOrderId = repairOrderId;
    }

    public String getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(String repairPrice) {
        this.repairPrice = repairPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getSysOrgCode() {
        return sysOrgCode;
    }

    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    public String getTarvelDate() {
        return tarvelDate;
    }

    public void setTarvelDate(String tarvelDate) {
        this.tarvelDate = tarvelDate;
    }

    public String getTravelLiveFee() {
        return travelLiveFee;
    }

    public void setTravelLiveFee(String travelLiveFee) {
        this.travelLiveFee = travelLiveFee;
    }

    public String getTravelMealFee() {
        return travelMealFee;
    }

    public void setTravelMealFee(String travelMealFee) {
        this.travelMealFee = travelMealFee;
    }

    public String getTravelOtherFee() {
        return travelOtherFee;
    }

    public void setTravelOtherFee(String travelOtherFee) {
        this.travelOtherFee = travelOtherFee;
    }

    public String getTravelTrafficFee() {
        return travelTrafficFee;
    }

    public void setTravelTrafficFee(String travelTrafficFee) {
        this.travelTrafficFee = travelTrafficFee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    private int travelPrice;
    public int getTravelPrice(){

        if (!TextUtils.isEmpty(travelTrafficFee)){
            travelPrice +=Integer.valueOf(travelTrafficFee);
        }
        if (!TextUtils.isEmpty(travelLiveFee)){
            travelPrice +=Integer.valueOf(travelLiveFee);
        }
        if (!TextUtils.isEmpty(travelMealFee)){
            travelPrice +=Integer.valueOf(travelMealFee);
        }
        if (!TextUtils.isEmpty(travelOtherFee)){
            travelPrice +=Integer.valueOf(travelOtherFee);
        }

        return travelPrice;
    }

    public int getWorkPrice(){
        if (!TextUtils.isEmpty(repairHours)&&!TextUtils.isEmpty(repairPrice)){
            return Integer.valueOf(getRepairHours())*Integer.valueOf(getRepairPrice());
        }
        return 0;
    }
}
