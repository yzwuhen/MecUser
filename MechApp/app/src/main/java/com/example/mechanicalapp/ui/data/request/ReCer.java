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
    private String companyId;
    private String companyAddress;
    private String socialPic;

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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
