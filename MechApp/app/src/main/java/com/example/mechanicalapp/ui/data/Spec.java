package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class Spec implements Serializable {
    private String specName;
    private boolean isSelect;

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
