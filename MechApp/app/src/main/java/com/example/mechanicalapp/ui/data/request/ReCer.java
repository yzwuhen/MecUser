package com.example.mechanicalapp.ui.data.request;

public class ReCer {


    /**
     * apporveStatus :
     * apporveType :
     * companyAddress :
     * companyId :
     * companyName :
     * componentType :
     * contactPhone :
     * content :
     * createBy :
     * createTime :
     * id :
     * idCard :
     * idCardBackPic :
     * idCardFrontPic :
     * name :
     * repairPic :
     * repaireType :
     * sex :
     * socialNo :
     * socialPic :
     * sysOrgCode :
     * updateBy :
     * updateTime :
     */

    private int  apporveType =2;
    private String name;
    private String idCard;
    private String sex;
    private String idCardFrontPic;
    private String idCardBackPic;
    private String companyName;
    private String socialNo;
    private String companyAddress;
    private String socialPic;
    private String componentType;
    private String repaireType;
    private String repairPic;
    private String contactPhone;
    private String city;
    private double gpsLat;
    private double gpsLon;
    private String id;
    private int apporveStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getApporveStatus() {
        return apporveStatus;
    }

    public void setApporveStatus(int apporveStatus) {
        this.apporveStatus = apporveStatus;
    }

    public double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public double getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(double gpsLon) {
        this.gpsLon = gpsLon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getRepairPic() {
        return repairPic;
    }

    public void setRepairPic(String repairPic) {
        this.repairPic = repairPic;
    }

    public String getRepaireType() {
        return repaireType;
    }

    public void setRepaireType(String repaireType) {
        this.repaireType = repaireType;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getApporveType() {
        return apporveType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSocialNo() {
        return socialNo;
    }

    public void setSocialNo(String socialNo) {
        this.socialNo = socialNo;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getSocialPic() {
        return socialPic;
    }

    public void setSocialPic(String socialPic) {
        this.socialPic = socialPic;
    }

    public void setApporveType(int apporveType) {
        this.apporveType = apporveType;
    }

    public String getIdCardFrontPic() {
        return idCardFrontPic;
    }

    public void setIdCardFrontPic(String idCardFrontPic) {
        this.idCardFrontPic = idCardFrontPic;
    }

    public String getIdCardBackPic() {
        return idCardBackPic;
    }

    public void setIdCardBackPic(String idCardBackPic) {
        this.idCardBackPic = idCardBackPic;
    }
}
