package com.example.mechanicalapp.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.mechanicalapp.R;
import com.example.mechanicalapp.ui.data.BannerData;
import com.example.mechanicalapp.ui.adapter.ImageAdapter;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yz_wuhen on 2019/10/5/005.
 */

public class BannerView extends LinearLayout implements View.OnClickListener {

    private Context mContext;

    private Banner mBanner;
    private List<BannerData> mList ;

    public BannerView(Context context) {
        super(context);
        initView(context);
    }

    public BannerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BannerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }



    private void initView(Context context) {
        mContext = context;
        this.setClipChildren(false);
        this.setClipToPadding(false);
        View.inflate(mContext, R.layout.view_banner, this);

        mBanner = findViewById(R.id.item_banner);
        mList = new ArrayList<>();


    }

    public void  setData(List<BannerData> banner){

        mList.clear();
        mList.addAll(banner);
        mBanner.setAdapter(new ImageAdapter(mList))
                .setIndicator(new CircleIndicator(mContext));

    }

    @Override
    public void onClick(View v) {

    }


}
