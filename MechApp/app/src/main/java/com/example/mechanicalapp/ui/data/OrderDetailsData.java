package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class OrderDetailsData implements Serializable {


    /**
     * id : 1338387637587709953
     * createBy : 13751773402
     * createTime : 2020-12-14 15:37:33
     * updateBy : 16620164051
     * updateTime : 2020-12-14 17:36:33
     * sysOrgCode : A02
     * repairFactoryId : 1332262998391255042
     * repairFactoryName : 锅碗瓢盆
     * repairFactoryAddress : 广州市天河区天河路228号正佳广场6楼
     * orderNum : 120201214153733406951
     * repairType : null
     * repairTypeName : null
     * orderSum : null
     * payTime : null
     * payType : null
     * payTypeName : null
     * status : 3
     * statusName : 待付款
     * progress : null
     * progressName : null
     * repairId : null
     * repairName : null
     * customerId : null
     * customerName : yz
     * customerPhone : 1333333
     * productId : null
     * productModel : ad533
     * productModelId : 1326573901854703617
     * productType : 挖掘机子类
     * productTypeId : 1323668504007696385
     * productBrandId : 1321490471452721153
     * productBrand : 玛莎拉蒂
     * orderDesc : 故障描述
     * receiveTime : 2020-12-14 15:58:27
     * reachTime : 2020-12-14 16:41:06
     * startRepairTime : null
     * finishedRepairTime : null
     * engineerIds : 5
     * adress : 广东省深圳市 宝安区西乡街道
     * lng : 113.883902
     * lat : 22.580897
     * companyName : yz公司
     * city : null
     * mecRepaireFactory : {"id":"1332262998391255042","createBy":null,"createTime":"2020-11-27 18:00:26","updateBy":null,"updateTime":"2020-12-10 12:30:51","sysOrgCode":null,"name":"锅碗瓢盆","responsePersonId":null,"responsePersonName":null,"responsePersonPhone":"13886943851","repaireType":"挖掘机子类","componentType":"配件1","address":"广州市天河区天河路228号正佳广场6楼","lng":"113.327011","lat":"23.131704","isApprove":null,"businessLicense":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/448318f3-c7d5-4fdf-9243-af159deaa606_1606471217052.jpg","factoryPicture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/34b653f1-d531-4dc3-bd7d-4d2fdd7fbe07_1606471224514.jpg","introduction":"添加维修厂测试，添加维修厂测试","userId":null,"companyName":"广州一帆风顺维修厂","companyId":null,"isTop":null,"city":"广州市","star":3,"viewNum":11}
     * mecRepairEngineer : [{"id":"5","createBy":"admin","createTime":"2020-10-14 23:59:38","updateBy":"admin","updateTime":"2020-10-16 21:25:36","sysOrgCode":"A01A03","headPicture":"temp/timg22_1602691158438.jpg","name":"龙哥哥","repairFactoryId":"1","repairFactoryName":"维修厂1","phone":"16620164051","repairNum":222,"repairAge":22,"post":"2","userId":null}]
     */

    private String id;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private String sysOrgCode;
    private String repairFactoryId;
    private String repairFactoryName;
    private String repairFactoryAddress;
    private String orderNum;
    private String repairType;
    private String repairTypeName;
    private double orderSum;
    private Object payTime;
    private Object payType;
    private Object payTypeName;
    private String status;
    private String statusName;
    private String progress;
    private String progressName;
    private String repairId;
    private String repairName;
    private String customerId;
    private String customerName;
    private String customerPhone;
    private Object productId;
    private String productModel;
    private String productModelId;
    private String productType;
    private String productTypeId;
    private String productBrandId;
    private String productBrand;
    private String orderDesc;
    private String receiveTime;
    private String reachTime;
    private Object startRepairTime;
    private Object finishedRepairTime;
    private String engineerIds;
    private String adress;
    private String lng;
    private String lat;
    private String companyName;
    private Object city;
    private MecRepaireFactoryBean mecRepaireFactory;
    private List<MecRepairEngineerBean> mecRepairEngineer;
    private String shareUrl;

    public String getShareUrl() {
        return shareUrl;
    }

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

    public String getRepairFactoryId() {
        return repairFactoryId;
    }

    public void setRepairFactoryId(String repairFactoryId) {
        this.repairFactoryId = repairFactoryId;
    }

    public String getRepairFactoryName() {
        return repairFactoryName;
    }

    public void setRepairFactoryName(String repairFactoryName) {
        this.repairFactoryName = repairFactoryName;
    }

    public String getRepairFactoryAddress() {
        return repairFactoryAddress;
    }

    public void setRepairFactoryAddress(String repairFactoryAddress) {
        this.repairFactoryAddress = repairFactoryAddress;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public Object getPayTime() {
        return payTime;
    }

    public void setPayTime(Object payTime) {
        this.payTime = payTime;
    }

    public Object getPayType() {
        return payType;
    }

    public void setPayType(Object payType) {
        this.payType = payType;
    }

    public Object getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(Object payTypeName) {
        this.payTypeName = payTypeName;
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

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Object getProductId() {
        return productId;
    }

    public void setProductId(Object productId) {
        this.productId = productId;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(String productModelId) {
        this.productModelId = productModelId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(String productBrandId) {
        this.productBrandId = productBrandId;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime;
    }

    public Object getStartRepairTime() {
        return startRepairTime;
    }

    public void setStartRepairTime(Object startRepairTime) {
        this.startRepairTime = startRepairTime;
    }

    public Object getFinishedRepairTime() {
        return finishedRepairTime;
    }

    public void setFinishedRepairTime(Object finishedRepairTime) {
        this.finishedRepairTime = finishedRepairTime;
    }

    public String getEngineerIds() {
        return engineerIds;
    }

    public void setEngineerIds(String engineerIds) {
        this.engineerIds = engineerIds;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public MecRepaireFactoryBean getMecRepaireFactory() {
        return mecRepaireFactory;
    }

    public void setMecRepaireFactory(MecRepaireFactoryBean mecRepaireFactory) {
        this.mecRepaireFactory = mecRepaireFactory;
    }

    public List<MecRepairEngineerBean> getMecRepairEngineer() {
        return mecRepairEngineer;
    }

    public void setMecRepairEngineer(List<MecRepairEngineerBean> mecRepairEngineer) {
        this.mecRepairEngineer = mecRepairEngineer;
    }

    public static class MecRepaireFactoryBean implements Serializable{
        /**
         * id : 1332262998391255042
         * createBy : null
         * createTime : 2020-11-27 18:00:26
         * updateBy : null
         * updateTime : 2020-12-10 12:30:51
         * sysOrgCode : null
         * name : 锅碗瓢盆
         * responsePersonId : null
         * responsePersonName : null
         * responsePersonPhone : 13886943851
         * repaireType : 挖掘机子类
         * componentType : 配件1
         * address : 广州市天河区天河路228号正佳广场6楼
         * lng : 113.327011
         * lat : 23.131704
         * isApprove : null
         * businessLicense : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/448318f3-c7d5-4fdf-9243-af159deaa606_1606471217052.jpg
         * factoryPicture : https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/34b653f1-d531-4dc3-bd7d-4d2fdd7fbe07_1606471224514.jpg
         * introduction : 添加维修厂测试，添加维修厂测试
         * userId : null
         * companyName : 广州一帆风顺维修厂
         * companyId : null
         * isTop : null
         * city : 广州市
         * star : 3
         * viewNum : 11
         */

        private String id;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String sysOrgCode;
        private String name;
        private String responsePersonId;
        private String responsePersonName;
        private String responsePersonPhone;
        private String repaireType;
        private String componentType;
        private String address;
        private String lng;
        private String lat;
        private String isApprove;
        private String businessLicense;
        private String factoryPicture;
        private String introduction;
        private String userId;
        private String companyName;
        private String companyId;
        private String isTop;
        private String city;
        private int star;
        private int viewNum;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResponsePersonId() {
            return responsePersonId;
        }

        public void setResponsePersonId(String responsePersonId) {
            this.responsePersonId = responsePersonId;
        }

        public String getResponsePersonName() {
            return responsePersonName;
        }

        public void setResponsePersonName(String responsePersonName) {
            this.responsePersonName = responsePersonName;
        }

        public String getResponsePersonPhone() {
            return responsePersonPhone;
        }

        public void setResponsePersonPhone(String responsePersonPhone) {
            this.responsePersonPhone = responsePersonPhone;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getIsApprove() {
            return isApprove;
        }

        public void setIsApprove(String isApprove) {
            this.isApprove = isApprove;
        }

        public String getBusinessLicense() {
            return businessLicense;
        }

        public void setBusinessLicense(String businessLicense) {
            this.businessLicense = businessLicense;
        }

        public String getFactoryPicture() {
            return factoryPicture;
        }

        public void setFactoryPicture(String factoryPicture) {
            this.factoryPicture = factoryPicture;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
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

        public String getIsTop() {
            return isTop;
        }

        public void setIsTop(String isTop) {
            this.isTop = isTop;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }

        public int getViewNum() {
            return viewNum;
        }

        public void setViewNum(int viewNum) {
            this.viewNum = viewNum;
        }
    }

    public static class MecRepairEngineerBean implements Serializable {
        /**
         * id : 5
         * createBy : admin
         * createTime : 2020-10-14 23:59:38
         * updateBy : admin
         * updateTime : 2020-10-16 21:25:36
         * sysOrgCode : A01A03
         * headPicture : temp/timg22_1602691158438.jpg
         * name : 龙哥哥
         * repairFactoryId : 1
         * repairFactoryName : 维修厂1
         * phone : 16620164051
         * repairNum : 222
         * repairAge : 22
         * post : 2
         * userId : null
         */

        private String id;
        private String createBy;
        private String createTime;
        private String updateBy;
        private String updateTime;
        private String sysOrgCode;
        private String headPicture;
        private String name;
        private String repairFactoryId;
        private String repairFactoryName;
        private String phone;
        private int repairNum;
        private int repairAge;
        private String post;
        private String post_dictText;
        private Object userId;

        public String getPost_dictText() {
            return post_dictText;
        }

        public void setPost_dictText(String post_dictText) {
            this.post_dictText = post_dictText;
        }

        private String engineerImId;

        public String getEngineerImId() {
            return engineerImId;
        }

        public void setEngineerImId(String engineerImId) {
            this.engineerImId = engineerImId;
        }

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

        public String getHeadPicture() {
            return headPicture;
        }

        public void setHeadPicture(String headPicture) {
            this.headPicture = headPicture;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRepairFactoryId() {
            return repairFactoryId;
        }

        public void setRepairFactoryId(String repairFactoryId) {
            this.repairFactoryId = repairFactoryId;
        }

        public String getRepairFactoryName() {
            return repairFactoryName;
        }

        public void setRepairFactoryName(String repairFactoryName) {
            this.repairFactoryName = repairFactoryName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getRepairNum() {
            return repairNum;
        }

        public void setRepairNum(int repairNum) {
            this.repairNum = repairNum;
        }

        public int getRepairAge() {
            return repairAge;
        }

        public void setRepairAge(int repairAge) {
            this.repairAge = repairAge;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }
    }
}
