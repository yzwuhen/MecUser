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
import java.math.RoundingMode;
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

    public static double getNum(double num){

        if (num==0){
            return 0;
        }
        if (num>0&&num<=0.5){
            return 0.5;
        }
        if (num>0.5&&num<=1){
            return 1;
        }
        if (num>1&&num<=1.5){
            return 1.5;
        }
        if (num>1.5&&num<=2){
            return 2;
        }
        if (num>2&&num<=2.5){
            return 2.5;
        }
        if (num>2.5&&num<=3){
            return 3;
        }if (num>3&&num<=3.5){
            return 3.5;
        }if (num>3.5&&num<=4){
            return 4;
        }if (num>4&&num<=4.5){
            return 4.5;
        }
        if (num>4.5&&num<=5){
            return 5;
        }
        if (num>5&&num<=5.5){
            return 5.5;
        }
        if (num>5.5&&num<=6){
            return 6;
        }
        if (num>6&&num<=6.5){
            return 6.5;
        }
        if (num>6.5&&num<=7){
            return 7;
        }
        if (num>7&&num<=7.5){
            return 7.5;
        }
        if (num>7.5&&num<=8){
            return 8;
        }
        if (num>8&&num<=8.5){
            return 8.5;
        }

        if (num>8.5&&num<=9){
            return 9;
        }
        if (num>9&&num<=9.5){
            return 9.5;
        }

        return 10;
    }
}
