package com.example.mechanicalapp.ui.data.request;

import java.io.Serializable;

public class ReScreenData implements Serializable {
    private String priceStart;
    private String priceEnd;
    private String engAgeStart;//机龄
    private String engAgeEnd;
    private String workTimeStart;
    private String workTimeEnd;

    public String getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(String priceStart) {
        this.priceStart = priceStart;
    }

    public String getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(String priceEnd) {
        this.priceEnd = priceEnd;
    }

    public String getEngAgeStart() {
        return engAgeStart;
    }

    public void setEngAgeStart(String engAgeStart) {
        this.engAgeStart = engAgeStart;
    }

    public String getEngAgeEnd() {
        return engAgeEnd;
    }

    public void setEngAgeEnd(String engAgeEnd) {
        this.engAgeEnd = engAgeEnd;
    }

    public String getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(String workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }
}
