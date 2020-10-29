package com.example.mechanicalapp.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mechanicalapp.R;
import com.example.mechanicalapp.ui.mvp.p.BasePresenter;

public abstract class BaseCusFragment extends Fragment {

    protected View mView;
    protected FrameLayout mContanier;
    protected Context mContext;
    public BasePresenter mPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = View.inflate(getContext(), R.layout.act_base, null);
        mContext = getContext();
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContanier = getViews(R.id.fl_root);
        mContanier.addView(View.inflate(getContext(), getLayoutId(), null));
        initView();
    }

    protected void initView() {

    }
    /**
     * 跳转到其他界面
     */
    public void jumpActivity(Bundle bundle,
                             @SuppressWarnings("rawtypes") Class targetActivity) {
        Intent intent = new Intent();
        intent.setClass(mContext, targetActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转到其他界面返回
     */

    public void jumpActivityForReSult(Integer result,
                                      @SuppressWarnings("rawtypes") Class targetActivity){

        Intent intent = new Intent();
        intent.setClass(mContext, targetActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        startActivityForResult(intent,result);
    }


    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }


    /**
     * @param viewId 根据id获取view对象
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T getViews(int viewId) {
        return (T) mView.findViewById(viewId);
    }

    protected abstract int getLayoutId();
}
