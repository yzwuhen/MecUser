package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class CityData implements Serializable {
    private String code;
    private String name;
    private List<CityData> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityData> getChildren() {
        return children;
    }

    public void setChildren(List<CityData> children) {
        this.children = children;
    }
}
