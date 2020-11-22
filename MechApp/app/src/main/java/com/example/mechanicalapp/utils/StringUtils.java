package com.example.mechanicalapp.utils;


import android.content.res.AssetManager;
import android.text.TextUtils;

import com.example.mechanicalapp.App;
import com.example.mechanicalapp.ui.data.NetData;
import com.example.mechanicalapp.ui.mvp.NetSubscribe;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

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

    public static void getJson(String fileName,NetSubscribe<String> netSubscribe) {

        Observable<String> observable =Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                //将json数据变成字符串
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    //获取assets资源管理器
                    AssetManager assetManager = App.getInstance().getApplicationContext().getAssets();
                    //通过管理器打开文件并读取
                    BufferedReader bf = new BufferedReader(new InputStreamReader(
                            assetManager.open(fileName)));
                    String line;
                    while ((line = bf.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                netSubscribe.onNext(stringBuilder.toString());
            }
        });
        observable.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
        ).subscribe(netSubscribe);
    }
}
