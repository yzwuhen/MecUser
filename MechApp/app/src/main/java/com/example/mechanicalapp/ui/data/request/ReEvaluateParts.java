package com.example.mechanicalapp.ui.data.request;

public class ReEvaluateParts {
    private String mecProdId;
    private String mecProductSkuId;
    private String mecProductSkuName;
    private String star;
    private String content;

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
