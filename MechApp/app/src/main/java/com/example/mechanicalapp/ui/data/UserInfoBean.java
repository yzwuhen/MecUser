package com.example.mechanicalapp.ui.data;

import java.util.List;

//第三方用户得信息
public class UserInfoBean  extends NetData {


    /**
     * success : true
     * result : {"mecMarketOldMechanicsNum":9,"mecMarketMechanicsNum":12,"mecMarketPartsNum":7,"mecMarketRedcruitNum":1,"isPerson":"1","isEnterprise":null,"companyName":"","avatar":"http://minio.jeecg.com/otatest/temp/lgo33_1583397323099.png","mecMarketOldMechanics":null,"mecMarketMechanics":null,"mecMarketParts":[{"priceUnit_dictText":"元/小时","city":"","isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑1","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"1","isTop_dictText":null,"brand":"","isTalk":"1","priceUnit":"2","address":"2","gpsLon":"","bussiessType":1,"contactName":"2","updateTime":"2020-11-26 16:13:59","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":13,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":"","isOn_dictText":"是","gpsLat":"","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑4","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"2","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-26 15:06:52","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":3,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑7","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"3","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑1","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"4","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑3","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"5","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑5","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"6","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑1","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"7","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"}],"mecMarketRecruit":null,"name":"管理员","userName":"admin"}
     * timestamp : 1606378601897
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * mecMarketOldMechanicsNum : 9
         * mecMarketMechanicsNum : 12
         * mecMarketPartsNum : 7
         * mecMarketRedcruitNum : 1
         * isPerson : 1
         * isEnterprise : null
         * companyName :
         * avatar : http://minio.jeecg.com/otatest/temp/lgo33_1583397323099.png
         * mecMarketOldMechanics : null
         * mecMarketMechanics : null
         * mecMarketParts : [{"priceUnit_dictText":"元/小时","city":"","isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑1","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"1","isTop_dictText":null,"brand":"","isTalk":"1","priceUnit":"2","address":"2","gpsLon":"","bussiessType":1,"contactName":"2","updateTime":"2020-11-26 16:13:59","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":13,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":"","isOn_dictText":"是","gpsLat":"","sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑4","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"2","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-26 15:06:52","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":3,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑7","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"3","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑1","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"4","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑3","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"5","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":1,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑5","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"6","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"},{"priceUnit_dictText":"元/小时","city":null,"isVerify_dictText":"是","pic":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/1603903127813_1603903252472.jpg","title":"佩剑1","partsType":"modlecode3","cateName":null,"content":"2","isVerify":"1","isPerson":"1","orderTime":"2020-10-31","updateBy":"admin","price":"22","isOn":"1","id":"7","isTop_dictText":null,"brand":null,"isTalk":"1","priceUnit":"2","address":"2","gpsLon":null,"bussiessType":2,"contactName":"2","updateTime":"2020-11-05 20:16:35","avatar":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/timg_1603550694985.jpg","realname":"老陈","createBy":"admin","viewNum":null,"createTime":"2020-10-31 19:23:04","cateId":null,"isTop":null,"isOn_dictText":"是","gpsLat":null,"sysOrgCode":"A01A03","isEnterprise":null,"contactPhone":"12333233333"}]
         * mecMarketRecruit : null
         * name : 管理员
         * userName : admin
         */

        private int mecMarketOldMechanicsNum;
        private int mecMarketMechanicsNum;
        private int mecMarketPartsNum;
        private int mecMarketRedcruitNum;
        private String isPerson;
        private Object isEnterprise;
        private String companyName;
        private String avatar;
        private List<MecSellData> mecMarketOldMechanics;
        private List<MecLeaseData> mecMarketMechanics;
        private List<RecruitData> mecMarketRecruit;
        private String name;
        private String userName;
        private List<PartsData> mecMarketParts;

        public int getMecMarketOldMechanicsNum() {
            return mecMarketOldMechanicsNum;
        }

        public void setMecMarketOldMechanicsNum(int mecMarketOldMechanicsNum) {
            this.mecMarketOldMechanicsNum = mecMarketOldMechanicsNum;
        }

        public int getMecMarketMechanicsNum() {
            return mecMarketMechanicsNum;
        }

        public void setMecMarketMechanicsNum(int mecMarketMechanicsNum) {
            this.mecMarketMechanicsNum = mecMarketMechanicsNum;
        }

        public int getMecMarketPartsNum() {
            return mecMarketPartsNum;
        }

        public void setMecMarketPartsNum(int mecMarketPartsNum) {
            this.mecMarketPartsNum = mecMarketPartsNum;
        }

        public int getMecMarketRedcruitNum() {
            return mecMarketRedcruitNum;
        }

        public void setMecMarketRedcruitNum(int mecMarketRedcruitNum) {
            this.mecMarketRedcruitNum = mecMarketRedcruitNum;
        }

        public String getIsPerson() {
            return isPerson;
        }

        public void setIsPerson(String isPerson) {
            this.isPerson = isPerson;
        }

        public Object getIsEnterprise() {
            return isEnterprise;
        }

        public void setIsEnterprise(Object isEnterprise) {
            this.isEnterprise = isEnterprise;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public List<MecSellData> getMecMarketOldMechanics() {
            return mecMarketOldMechanics;
        }

        public void setMecMarketOldMechanics(List<MecSellData> mecMarketOldMechanics) {
            this.mecMarketOldMechanics = mecMarketOldMechanics;
        }

        public List<MecLeaseData> getMecMarketMechanics() {
            return mecMarketMechanics;
        }

        public void setMecMarketMechanics(List<MecLeaseData> mecMarketMechanics) {
            this.mecMarketMechanics = mecMarketMechanics;
        }

        public List<RecruitData> getMecMarketRecruit() {
            return mecMarketRecruit;
        }

        public void setMecMarketRecruit(List<RecruitData> mecMarketRecruit) {
            this.mecMarketRecruit = mecMarketRecruit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public List<PartsData> getMecMarketParts() {
            return mecMarketParts;
        }

        public void setMecMarketParts(List<PartsData> mecMarketParts) {
            this.mecMarketParts = mecMarketParts;
        }
    }
}
