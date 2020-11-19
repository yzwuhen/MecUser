package com.example.mechanicalapp.ui.data;

import java.io.Serializable;
import java.util.List;

public class MecTypeData implements Serializable {
    private String id;
    private String cateName;
    private String cateLogo;
    private String pid;
    private String hasChild;
    private boolean isSelect;
    private List<MecTypeChildData> childList;
    private List<MecTypeChildData> partsList;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateLogo() {
        return cateLogo;
    }

    public void setCateLogo(String cateLogo) {
        this.cateLogo = cateLogo;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHasChild() {
        return hasChild;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public List<MecTypeChildData> getChildList() {
        return childList;
    }

    public void setChildList(List<MecTypeChildData> childList) {
        this.childList = childList;
    }

    public List<MecTypeChildData> getPartsList() {
        return partsList;
    }

    public void setPartsList(List<MecTypeChildData> partsList) {
        this.partsList = partsList;
    }
}
