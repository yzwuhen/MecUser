package com.example.mechanicalapp.ui.data;

import java.io.Serializable;

public class CodeData implements Serializable {
    private boolean isSelect;
    private String itemText;
    private String itemValue;

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
