package com.example.mechanicalapp.ui.data.request;

public class ReEvaluateParts {
    private String mecProdId;
    private String mecProductSkuId;
    private String mecProductSkuName;
    private String star="3";
    private String content;
    private String mecOrderId;
    private String mecOrderItemId;
    private String commentUserHeader;
    private String commentUserId;
    private String commentUserName;
    private String commentUserPhone;

    public String getCommentUserHeader() {
        return commentUserHeader;
    }

    public void setCommentUserHeader(String commentUserHeader) {
        this.commentUserHeader = commentUserHeader;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentUserPhone() {
        return commentUserPhone;
    }

    public void setCommentUserPhone(String commentUserPhone) {
        this.commentUserPhone = commentUserPhone;
    }

    public String getMecOrderItemId() {
        return mecOrderItemId;
    }

    public void setMecOrderItemId(String mecOrderItemId) {
        this.mecOrderItemId = mecOrderItemId;
    }

    public String getMecOrderId() {
        return mecOrderId;
    }

    public void setMecOrderId(String mecOrderId) {
        this.mecOrderId = mecOrderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMecProdId() {
        return mecProdId;
    }

    public void setMecProdId(String mecProdId) {
        this.mecProdId = mecProdId;
    }

    public String getMecProductSkuId() {
        return mecProductSkuId;
    }

    public void setMecProductSkuId(String mecProductSkuId) {
        this.mecProductSkuId = mecProductSkuId;
    }

    public String getMecProductSkuName() {
        return mecProductSkuName;
    }

    public void setMecProductSkuName(String mecProductSkuName) {
        this.mecProductSkuName = mecProductSkuName;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }
}
