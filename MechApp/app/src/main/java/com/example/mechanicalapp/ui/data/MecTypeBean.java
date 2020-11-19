package com.example.mechanicalapp.ui.data;

import java.util.List;

public class MecTypeBean extends NetData {


    /**
     * success : true
     * result : [{"id":"1321476604976406530","createBy":"admin","createTime":"2020-10-28 23:39:09","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"挖掘机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/wjj@3x_1603899540776.png","pid":"0","hasChild":"1","isHot":"1","orderNum":null,"childList":[{"id":"1323668504007696385","createBy":"admin","createTime":"2020-11-04 00:48:58","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"挖掘机子类","cateLogo":"","pid":"1321476604976406530","hasChild":"0","isHot":"0","orderNum":null}]},{"id":"1321476906857242625","createBy":"admin","createTime":"2020-10-28 23:40:21","updateBy":"admin","updateTime":"2020-10-28 23:43:07","sysOrgCode":"A01A03","cateName":"旋挖机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/xwj@2x_1603899605710.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477081252208641","createBy":"admin","createTime":"2020-10-28 23:41:02","updateBy":"admin","updateTime":"2020-10-28 23:43:12","sysOrgCode":"A01A03","cateName":"推土机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/ttj@3x_1603899658162.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477237339037697","createBy":"admin","createTime":"2020-10-28 23:41:39","updateBy":"admin","updateTime":"2020-10-28 23:43:19","sysOrgCode":"A01A03","cateName":"汽车吊","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/qcd@3x_1603899696531.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477349591195650","createBy":"admin","createTime":"2020-10-28 23:42:06","updateBy":"admin","updateTime":"2020-10-28 23:43:25","sysOrgCode":"A01A03","cateName":"泵车","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/bc@3x_1603899722887.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477554315173890","createBy":"admin","createTime":"2020-10-28 23:42:55","updateBy":"admin","updateTime":"2020-10-28 23:43:31","sysOrgCode":"A01A03","cateName":"装载机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/zzj@3x_1603899770080.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]}]
     * timestamp : 1605755142308
     */

    private List<MecTypeData> result;

    public List<MecTypeData> getResult() {
        return result;
    }

    public void setResult(List<MecTypeData> result) {
        this.result = result;
    }
}
