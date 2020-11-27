package com.example.mechanicalapp.ui.data.request;

import android.text.TextUtils;

public class ReReport {

    /**
     * createBy :
     * createTime :
     * id :
     * pic :
     * remark :
     * reportId :
     * reportReasonContent :
     * reportReasonId :
     * sysOrgCode :
     * type :
     * updateBy :
     * updateTime :
     */

    private String pic;
    private String reportId;
    private String reportReasonContent;
    private String reportReasonId;
    private int type;



    public String getPic() {
        return TextUtils.isEmpty(pic)?"":pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportReasonContent() {
        return reportReasonContent;
    }

    public void setReportReasonContent(String reportReasonContent) {
        this.reportReasonContent = reportReasonContent;
    }

    public String getReportReasonId() {
        return reportReasonId;
    }

    public void setReportReasonId(String reportReasonId) {
        this.reportReasonId = reportReasonId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
