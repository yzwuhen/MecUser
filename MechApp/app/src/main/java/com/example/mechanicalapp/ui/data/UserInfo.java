package com.example.mechanicalapp.ui.data;

import android.text.TextUtils;

import java.io.Serializable;

public class UserInfo implements Serializable {

    /**
     * id : 1
     * username : 16620164051
     * realname : 16620164051
     * avatar : null
     * birthday : null
     * sex : null
     * email : null
     * phone : 16620164051
     * orgCode : null
     * orgCodeTxt : null
     * status : 1
     * delFlag : 0
     * workNo : null
     * post : null
     * telephone : null
     * createBy : null
     * createTime : 2020-10-16 20:49:24
     * updateBy : null
     * updateTime : null
     * activitiSync : 0
     * userIdentity : null
     * departIds : null
     * thirdType : null
     * relTenantIds : null
     * clientId : null
     * mecApproveType : 1
     * userType : 1
     */

    private String id;
    private String username;
    private String realname;
    private String avatar;
    private Object birthday;
    private int sex;
    private Object email;
    private String phone;
    private Object orgCode;
    private Object orgCodeTxt;
    private Integer status;
    private Integer delFlag;
    private Object workNo;
    private Object post;
    private Object telephone;
    private Object createBy;
    private String createTime;
    private Object updateBy;
    private Object updateTime;
    private Integer activitiSync;
    private Object userIdentity;
    private Object departIds;
    private Object thirdType;
    private Object relTenantIds;
    private Object clientId;
    private String mecApproveType;
    private Integer userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return TextUtils.isEmpty(username)?"********":username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getPhone() {
        return TextUtils.isEmpty(phone)?"********":phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(Object orgCode) {
        this.orgCode = orgCode;
    }

    public Object getOrgCodeTxt() {
        return orgCodeTxt;
    }

    public void setOrgCodeTxt(Object orgCodeTxt) {
        this.orgCodeTxt = orgCodeTxt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Object getWorkNo() {
        return workNo;
    }

    public void setWorkNo(Object workNo) {
        this.workNo = workNo;
    }

    public Object getPost() {
        return post;
    }

    public void setPost(Object post) {
        this.post = post;
    }

    public Object getTelephone() {
        return telephone;
    }

    public void setTelephone(Object telephone) {
        this.telephone = telephone;
    }

    public Object getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Object createBy) {
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

    public Integer getActivitiSync() {
        return activitiSync;
    }

    public void setActivitiSync(Integer activitiSync) {
        this.activitiSync = activitiSync;
    }

    public Object getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(Object userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Object getDepartIds() {
        return departIds;
    }

    public void setDepartIds(Object departIds) {
        this.departIds = departIds;
    }

    public Object getThirdType() {
        return thirdType;
    }

    public void setThirdType(Object thirdType) {
        this.thirdType = thirdType;
    }

    public Object getRelTenantIds() {
        return relTenantIds;
    }

    public void setRelTenantIds(Object relTenantIds) {
        this.relTenantIds = relTenantIds;
    }

    public Object getClientId() {
        return clientId;
    }

    public void setClientId(Object clientId) {
        this.clientId = clientId;
    }

    public String getMecApproveType() {
        return mecApproveType;
    }

    public void setMecApproveType(String mecApproveType) {
        this.mecApproveType = mecApproveType;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
