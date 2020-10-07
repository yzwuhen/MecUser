package com.example.mechanicalapp.ui.adapter;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mechanicalapp.App;
import com.example.mechanicalapp.ui.data.BannerData;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageAdapter extends BannerAdapter<BannerData, ImageAdapter.BannerViewHolder> {

    public ImageAdapter(List<BannerData> mDatas) {
        //设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
        super(mDatas);
    }

    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }



    @Override
    public void onBindView(BannerViewHolder holder, BannerData data, int position, int size) {
       // holder.imageView.setImageResource(data.getImg_path());
//        Glide.with(holder.itemView)
//                .load(data.getImg_path())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
//                .into(holder.imageView);
        BannerViewHolder bannerViewHolder = holder;
        Log.v("sssss","sssssssssss======$"+data.getImg_path());
        Glide.with(App.getInstance().getApplicationContext()).load(data.getImg_path()).into(bannerViewHolder.imageView);
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}