package com.example.mechanicalapp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;;
import android.widget.ImageView;


import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.mechanicalapp.R;

import java.lang.ref.WeakReference;


/**
 * Created by zhangguorong on 2017/8/8.
 */

public class ImageLoadUtils {


    public static void loadImageCenterCrop(Context mContext, ImageView imageView, Object url, int norImage){
        WeakReference<ImageView> weakReference = new WeakReference<ImageView>(imageView);
        if (url==null){
            return;
        }

        RequestOptions requestOptions = new RequestOptions();
        /*
        *
        * DiskCacheStrategy.NONE
        * 不缓存文件DiskCacheStrategy.SOURCE
        * 只缓存原图DiskCacheStrategy.RESULT
        * 只缓存最终加载的图（默认的缓存策略）DiskCacheStrategy.ALL  同时缓存原图和结果图
        * */
        requestOptions.placeholder(norImage).centerCrop().error(norImage).diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext).load(url).apply(requestOptions).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(weakReference.get());

    }
    public static void loadImage(Context mContext, ImageView imageView, String url, int norImage){
        WeakReference<ImageView> weakReference = new WeakReference<ImageView>(imageView);
        if (url==null){
            return;
        }

//        Glide.with(mContext).load(url).into(weakReference.get());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(norImage).error(norImage).diskCacheStrategy(DiskCacheStrategy.RESOURCE);

        Glide.with(mContext).load(url).apply(requestOptions).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                return false;
            }

        }).into(weakReference.get());

    }

    public static void loadGifImage(Context mContext, ImageView imageView, int norImage){
        WeakReference<ImageView> weakReference = new WeakReference<ImageView>(imageView);

        Glide.with(mContext).asGif().load(norImage).into(weakReference.get());

    }

    public static void loadCircle(Context mContext, ImageView imageView, String url){

        Glide.with(mContext).load(url)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .error(R.mipmap.user_default)
                .into(imageView);
    }

}
