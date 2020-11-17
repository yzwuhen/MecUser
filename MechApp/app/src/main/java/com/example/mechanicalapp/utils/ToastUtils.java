package com.example.mechanicalapp.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.mechanicalapp.App;


public class ToastUtils {
    public static void showText( String s) {
        if (!TextUtils.isEmpty(s)){
            Toast.makeText(App.getInstance().getApplicationContext(), s, Toast.LENGTH_SHORT).show();
        }
    }

}
