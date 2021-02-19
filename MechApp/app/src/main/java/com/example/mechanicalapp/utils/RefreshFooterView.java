package com.example.mechanicalapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.mechanicalapp.R;
import com.liaoinstan.springview.container.BaseFooter;

public class RefreshFooterView extends BaseFooter {
    private Context context;
    private int rotationSrc;
    private TextView footerTitle;
    private ProgressBar footerProgressbar;

    public RefreshFooterView(Context context){
        this(context,R.drawable.progress_small);
    }

    public RefreshFooterView(Context context,int rotationSrc){
        this.context = context;
        this.rotationSrc = rotationSrc;
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.refresh_footer_view, viewGroup, true);
        footerTitle = (TextView) view.findViewById(R.id.default_footer_title);
        footerProgressbar = (ProgressBar) view.findViewById(R.id.default_footer_progressbar);
        footerProgressbar.setIndeterminateDrawable(ContextCompat.getDrawable(context,rotationSrc));
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
    }

    @Override
    public void onDropAnim(View rootView, int dy) {
    }
    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
        if (upORdown) {
            footerTitle.setText("松开刷新");
        } else {
            footerTitle.setText("正在加载更多");
        }
    }

    @Override
    public void onStartAnim() {
        footerTitle.setText("正在加载更多");
    }

    @Override
    public void onFinishAnim() {

    }
}
