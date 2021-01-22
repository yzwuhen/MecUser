package com.example.mechanicalapp.ui.data;

import java.util.List;

public class FactoryDetailsBean extends NetData {


    /**
     * success : true
     * result : {"commentNum":0,"factory":{"id":"1349565867293151233","createBy":"13886943851","createTime":"2021-01-14 11:55:51","updateBy":"admin","updateTime":"2021-01-22 14:55:27","sysOrgCode":"A01A03","name":"小跑科技","responsePersonId":"13886943851","responsePersonName":"哈哈","responsePersonPhone":"18772726477","repaireType":"4号足球","componentType":"配件1","address":"广州市海珠区赤岗大塘聚德北路自编9号","lng":"113.331258","lat":"23.085796","isApprove":1,"businessLicense":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/f142b900-8daa-45c7-920f-7a107d7bfc56_1610596526627.jpg","factoryPicture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/a451f0c8-ae3b-4e8a-b0d1-37675bb8f043_1610596531740.jpg","introduction":"测试","userId":"1349565867213459457","companyName":null,"companyId":null,"isTop":"0","city":null,"star":3,"viewNum":15,"isFreezed":null,"noticePhone":null,"isNotice":null,"shareUrl":"/share/RepairFactoryDetail?id=1349565867293151233"},"comment":[]}
     * timestamp : 1611302226303
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
         * commentNum : 0
         * factory : {"id":"1349565867293151233","createBy":"13886943851","createTime":"2021-01-14 11:55:51","updateBy":"admin","updateTime":"2021-01-22 14:55:27","sysOrgCode":"A01A03","name":"小跑科技","responsePersonId":"13886943851","responsePersonName":"哈哈","responsePersonPhone":"18772726477","repaireType":"4号足球","componentType":"配件1","address":"广州市海珠区赤岗大塘聚德北路自编9号","lng":"113.331258","lat":"23.085796","isApprove":1,"businessLicense":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/f142b900-8daa-45c7-920f-7a107d7bfc56_1610596526627.jpg","factoryPicture":"https://mechanical-gang-oss.oss-cn-shenzhen.aliyuncs.com/upload/a451f0c8-ae3b-4e8a-b0d1-37675bb8f043_1610596531740.jpg","introduction":"测试","userId":"1349565867213459457","companyName":null,"companyId":null,"isTop":"0","city":null,"star":3,"viewNum":15,"isFreezed":null,"noticePhone":null,"isNotice":null,"shareUrl":"/share/RepairFactoryDetail?id=1349565867293151233"}
         * comment : []
         */

        private int commentNum;
        private FactoryDetailData factory;
        private List<FactoryCommentData> comment;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public FactoryDetailData getFactory() {
            return factory;
        }

        public void setFactory(FactoryDetailData factory) {
            this.factory = factory;
        }

        public List<FactoryCommentData> getComment() {
            return comment;
        }

        public void setComment(List<FactoryCommentData> comment) {
            this.comment = comment;
        }

    }
}
