package com.example.mechanicalapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mechanicalapp.App;
import com.example.mechanicalapp.R;
import com.example.mechanicalapp.ui.data.BannerData;
import com.example.mechanicalapp.utils.ImageLoadUtils;
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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_layout,parent,false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindView(BannerViewHolder holder, BannerData data, int position, int size) {
        BannerViewHolder bannerViewHolder = holder;
        if (data.getImg().endsWith("mp4")){
            ImageLoadUtils.loadVideo(App.getInstance().getApplicationContext(),bannerViewHolder.imageView,data.getImg());
            bannerViewHolder.ivIcon.setVisibility(View.VISIBLE);
        }else {
            bannerViewHolder.ivIcon.setVisibility(View.GONE);
            ImageLoadUtils.loadImageCenterCrop(App.getInstance().getApplicationContext(),bannerViewHolder.imageView,data.getImg(),R.mipmap.ic_launcher);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView ivIcon;
        public BannerViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.iv_banner);
            ivIcon = view.findViewById(R.id.iv_video);
        }
    }
}