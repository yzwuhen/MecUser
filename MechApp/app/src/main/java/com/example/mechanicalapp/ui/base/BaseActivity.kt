package com.example.mechanicalapp.ui.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.utils.Density
import kotlinx.android.synthetic.main.act_base.*

abstract  class BaseActivity<T> : AppCompatActivity() ,BaseView<T>{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_base)
        Density.setDensity(App.getInstance(),this)
        setRequestedOrientation(
            ActivityInfo
            .SCREEN_ORIENTATION_PORTRAIT)
//        flRoot = findViewById(R.id.fl_root) as FrameLayout
        initView()
        initPresenter()
    }

    open fun initView() {

        fl_root?.addView(View.inflate(this, getLayoutId(), null))
    }
    protected open fun <T : View?> getViewTo(viewId: Int): T {
        return findViewById<View>(viewId) as T
    }

    /**
     * 跳转到其他界面
     */
    open fun jumpActivity(
        bundle: Bundle?,
        targetActivity: Class<*>?
    ) {
        val intent = Intent()
        intent.setClass(this, targetActivity!!)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    /**
     * 跳转到其他界面返回
     */
    open fun jumpActivityForReSult(
        result: Int,
        targetActivity: Class<*>?
    ) {
        val intent = Intent()
        intent.setClass(this, targetActivity!!)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivityForResult(intent,result)
    }




    abstract fun getLayoutId(): Int
    abstract fun initPresenter()
}