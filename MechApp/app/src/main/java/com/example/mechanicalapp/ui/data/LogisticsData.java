package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class LogisticsData implements Serializable {

    /**
     * LogisticCode : YT5169544100040
     * ShipperCode : YTO
     * Traces : [{"AcceptStation":"【浙江省绍兴市诸暨市公司】 已收件 取件人: 朱奕磊 (13989512987)","AcceptTime":"2021-01-02 20:40:14"},{"AcceptStation":"【浙江省绍兴市诸暨市公司】 已打包","AcceptTime":"2021-01-02 20:43:57"},{"AcceptStation":"【浙江省绍兴市诸暨市】 已发出 下一站 【上虞转运中心公司】","AcceptTime":"2021-01-02 20:55:24"},{"AcceptStation":"【上虞转运中心公司】 已收入","AcceptTime":"2021-01-03 00:10:05"},{"AcceptStation":"【上虞转运中心】 已发出 下一站 【广州转运中心公司】","AcceptTime":"2021-01-03 00:12:07"},{"AcceptStation":"【广州转运中心公司】 已收入","AcceptTime":"2021-01-03 23:11:45"},{"AcceptStation":"【广州转运中心】 已发出 下一站 【广东省广州市白云区新龙归公司】","AcceptTime":"2021-01-03 23:30:44"},{"AcceptStation":"【广东省广州市白云区新龙归公司】 已收入","AcceptTime":"2021-01-04 07:22:41"},{"AcceptStation":"【广东省广州市白云区新龙归公司】 派件中  派件人: 叶钧华 电话 16620002402  如有疑问，请联系：0753-5818808","AcceptTime":"2021-01-04 10:24:40"},{"AcceptStation":"快件已暂存至广州南村聚龙北一巷63号店菜鸟驿站，如有疑问请联系13143391775","AcceptTime":"2021-01-04 12:00:06"},{"AcceptStation":"客户签收人: 已签收，签收人凭取货码签收。 已签收  感谢使用圆通速递，期待再次为您服务 如有疑问请联系：16620002402，投诉电话：0753-5818808","AcceptTime":"2021-01-04 19:40:40"}]
     * State : 3
     * EBusinessID : 1650321
     * Success : true
     */

    private String LogisticCode;
    private String ShipperCode;
    private String State;
    private String EBusinessID;
    private boolean Success;
    private List<TracesBean> Traces;

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String LogisticCode) {
        this.LogisticCode = LogisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String ShipperCode) {
        this.ShipperCode = ShipperCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public List<TracesBean> getTraces() {
        return Traces;
    }

    public void setTraces(List<TracesBean> Traces) {
        this.Traces = Traces;
    }

    public static class TracesBean implements Serializable{
        /**
         * AcceptStation : 【浙江省绍兴市诸暨市公司】 已收件 取件人: 朱奕磊 (13989512987)
         * AcceptTime : 2021-01-02 20:40:14
         */

        private String AcceptStation;
        private String AcceptTime;

        public String getAcceptStation() {
            return AcceptStation;
        }

        public void setAcceptStation(String AcceptStation) {
            this.AcceptStation = AcceptStation;
        }

        public String getAcceptTime() {
            return AcceptTime;
        }

        public void setAcceptTime(String AcceptTime) {
            this.AcceptTime = AcceptTime;
        }
    }
}
