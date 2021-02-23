package com.example.mechanicalapp.utils;

import android.content.Context;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.lang.ref.WeakReference;

/**
 * Created by yz_wuhen on 2017/8/29.
 *
 * 刷新控件
 */

public class RefreshHeaderUtils {

    public static SpringView.DragHander getHeaderView(Context context){
        WeakReference<Context> weakReference = new WeakReference<Context>(context);

        return new RefreshHeaderView(weakReference.get());
    }

    public static SpringView.DragHander getFooterView(Context context){
        WeakReference<Context> weakReference = new WeakReference<Context>(context);

        return new RefreshFooterView(weakReference.get());
    }
}
