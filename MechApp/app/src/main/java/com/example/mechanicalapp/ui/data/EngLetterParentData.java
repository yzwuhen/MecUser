package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class EngLetterParentData implements Serializable {
    private String key;
    private List<EngineerData> data;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<EngineerData> getData() {
        return data;
    }

    public void setData(List<EngineerData> data) {
        this.data = data;
    }
}
