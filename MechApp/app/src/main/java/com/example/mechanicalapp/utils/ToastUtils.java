package com.example.mechanicalapp.utils;

import android.widget.Toast;

import com.example.mechanicalapp.App;


public class ToastUtils {
    public static void showText( String s) {
            Toast.makeText(App.getInstance().getApplicationContext(), s, Toast.LENGTH_SHORT)
                    .show();
    }

}
