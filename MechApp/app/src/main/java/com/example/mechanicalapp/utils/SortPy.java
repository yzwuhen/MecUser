package com.example.mechanicalapp.utils;

import com.example.mechanicalapp.ui.data.BrandData;

import java.util.Comparator;

public class SortPy implements Comparator<BrandData> {

    @Override
    public int compare(BrandData brandData, BrandData brandData1) {

        String py1 =  PinyinUtils.getPinYinAllChar(brandData.getBrandName(),0);
        String py2 = PinyinUtils.getPinYinAllChar(brandData1.getBrandName(),0);
        int flag = py1.compareTo(py2);
        return flag;
    }

}
