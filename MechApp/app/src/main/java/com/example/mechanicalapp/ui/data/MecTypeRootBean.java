package com.example.mechanicalapp.ui.data;

import java.util.List;

public class MecTypeRootBean extends NetData {

    /**
     * success : true
     * result : [{"id":"1321476604976406530","createBy":"admin","createTime":"2020-10-28 23:39:09","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"挖掘机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/wjj@3x_1603899540776.png","pid":"0","hasChild":"1","isHot":"1","orderNum":null,"childList":[{"id":"1323668504007696385","createBy":"admin","createTime":"2020-11-04 00:48:58","updateBy":null,"updateTime":null,"sysOrgCode":"A01A03","cateName":"挖掘机子类","cateLogo":"","pid":"1321476604976406530","hasChild":"0","isHot":"0","orderNum":null}]},{"id":"1321476906857242625","createBy":"admin","createTime":"2020-10-28 23:40:21","updateBy":"admin","updateTime":"2020-12-05 17:34:51","sysOrgCode":"A01A03","cateName":"旋挖机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/xwj@2x_1603899605710.png","pid":"0","hasChild":"1","isHot":"1","orderNum":null,"childList":[{"id":"1335155662237327362","createBy":null,"createTime":"2020-12-05 17:34:51","updateBy":null,"updateTime":null,"sysOrgCode":null,"cateName":"旋挖机1","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/5c204792-874c-4007-9ee3-e507f94cbc23_1607160878289.png","pid":"1321476906857242625","hasChild":null,"isHot":"0","orderNum":1}]},{"id":"1321477081252208641","createBy":"admin","createTime":"2020-10-28 23:41:02","updateBy":"admin","updateTime":"2020-10-28 23:43:12","sysOrgCode":"A01A03","cateName":"推土机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/ttj@3x_1603899658162.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477237339037697","createBy":"admin","createTime":"2020-10-28 23:41:39","updateBy":"admin","updateTime":"2020-10-28 23:43:19","sysOrgCode":"A01A03","cateName":"汽车吊","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/qcd@3x_1603899696531.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477349591195650","createBy":"admin","createTime":"2020-10-28 23:42:06","updateBy":"admin","updateTime":"2020-10-28 23:43:25","sysOrgCode":"A01A03","cateName":"泵车","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/bc@3x_1603899722887.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1321477554315173890","createBy":"admin","createTime":"2020-10-28 23:42:55","updateBy":"admin","updateTime":"2020-10-28 23:43:31","sysOrgCode":"A01A03","cateName":"装载机","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/zzj@3x_1603899770080.png","pid":"0","hasChild":"0","isHot":"1","orderNum":null,"childList":[]},{"id":"1335892276320264194","createBy":null,"createTime":"2020-12-07 18:21:53","updateBy":null,"updateTime":null,"sysOrgCode":null,"cateName":"足球","cateLogo":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/temp/4826f8b9-a011-44f8-9cfc-71ea1302cfe4_1607336505630.jpg","pid":"0","hasChild":null,"isHot":"1","orderNum":1,"childList":[]}]
     * timestamp : 1607354737423
     */

    private List<MecTypeParentData> result;

    public List<MecTypeParentData> getResult() {
        return result;
    }

    public void setResult(List<MecTypeParentData> result) {
        this.result = result;
    }

}
