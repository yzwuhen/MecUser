package com.example.mechanicalapp.utils;


import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;

import com.example.mechanicalapp.App;
import com.example.mechanicalapp.config.Configs;
import com.example.mechanicalapp.ui.activity.SearchGoodsResult;
import com.example.mechanicalapp.ui.data.NetData;
import com.example.mechanicalapp.ui.mvp.NetSubscribe;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;

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
    //0 机械出租 1 机械求租 2 机械出售 3 机械求购  4配件出租 5 配件求租 6维修厂 7搜索我的设备 8 搜索维修订单 9 工程师 10home搜索  11 搜索商品
    //12 求职 13 招聘
   public static String getHawkKey(int type){
        switch (type){
            case 0:
                return Configs.HISTORY_MEC_LEASE;
            case 1:
                return Configs.HISTORY_MEC_ASK;
            case 2:
                return Configs.HISTORY_MEC_SELL;
            case 3:
                return Configs.HISTORY_MEC_BUY;
            case 4:
                return Configs.HISTORY_PARTS_LEASE;
            case 5:
                return Configs.HISTORY_PARTS_ASK;
            case 6:
                return Configs.HISTORY_FACTORY;
            case 7:
                return Configs.HISTORY_MY_MEC;
            case 8:
                return Configs.HISTORY_REPAIR;
            case 9:
                return Configs.HISTORY_WORKER;
            case 10:
                return Configs.HISTORY_HOME;
            case 11:
                return Configs.HISTORY_GOODS;
            case 12:
                return Configs.HISTORY_RECRUIT;
            case 13:
                return Configs.HISTORY_JOB_WANT;

        }
       return Configs.HISTORY_MEC_LEASE;
   }

    /**
     * 获取指定文件大小
     * @param file
     * @return
     * @throws Exception
     */
    public static long getFileSize(File file) throws Exception
    {
        long size = 0;
        if (file.exists()){
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        }
        else{
            file.createNewFile();
            Log.e("获取文件大小","文件不存在!");
        }
        return size;
    }
    /**
     * 获取指定文件夹
     * @param f
     * @return
     * @throws Exception
     */
    public static long getFileSizes(File f) throws Exception
    {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++){
            if (flist[i].isDirectory()){
                size = size + getFileSizes(flist[i]);
            }
            else{
                size =size + getFileSize(flist[i]);
            }
        }
        return size;
    }

    /**
     * 转换文件大小
     * @param fileS
     * @return
     */
    public static String FormetFileSize(long fileS)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize="0B";
        if(fileS==0){
            return wrongSize;
        }
        if (fileS < 1024){
            fileSizeString = df.format((double) fileS) + "B";
        }
        else if (fileS < 1048576){
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        }
        else {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        }
//        else if (fileS < 1073741824){
//            fileSizeString = df.format((double) fileS / 1048576) + "MB";
//        }
//        else{
//            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
//        }
        return fileSizeString;
    }

    public static int getRingDuring(String mUri){
        try {
            MediaMetadataRetriever media = new MediaMetadataRetriever();
            media.setDataSource(mUri);
            String duration = media.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION); //
            return Integer.parseInt(duration);
        }catch (Exception e){
            return 0;
        }

    }
}
