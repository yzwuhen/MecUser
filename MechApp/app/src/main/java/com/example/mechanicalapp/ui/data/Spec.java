package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class Spec implements Serializable {
    private String specName;
    private boolean isSelect;
    private int specNum;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public int getSpecNum() {
        return specNum;
    }

    public void setSpecNum(int specNum) {
        this.specNum = specNum;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
