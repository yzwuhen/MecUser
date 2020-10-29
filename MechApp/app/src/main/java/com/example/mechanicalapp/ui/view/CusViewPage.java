package com.example.mechanicalapp.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by yz_wuhen on 2017/9/6.
 */

public class CusViewPage extends ViewPager {

    private boolean enabled;

    public CusViewPage(Context context) {
        super(context);
    }


    public CusViewPage(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    //设置viewpage是否允许滑动
    public boolean setTouchEvent(boolean enabled){

        return  this.enabled=enabled;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }
        return enabled;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return enabled;
    }

}
