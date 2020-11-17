package com.example.mechanicalapp.utils;


import android.text.TextUtils;

import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;

public class StringUtils {
    public static String getImgStr(String url) {
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        return url.split(",")[0];
    }


    @Nullable
    public static String getDistance(float calculateLineDistance) {


        DecimalFormat df = new DecimalFormat("#.00");

        String str =df.format(calculateLineDistance/1000);
        return str;
    }
}
