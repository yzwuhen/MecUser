package com.example.mechanicalapp.ui.base

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.utils.Density
import kotlinx.android.synthetic.main.act_base.*


abstract  class BaseActivity<T> : AppCompatActivity() ,BaseView<T>{
    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE",
        "android.permission.CAMERA","android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_FINE_LOCATION"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_base)
        Density.setDensity(App.getInstance(), this)
        setRequestedOrientation(
            ActivityInfo
                .SCREEN_ORIENTATION_PORTRAIT
        )
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
        startActivityForResult(intent, result)
    }

    open fun verifyStoragePermissions(activity: Activity?) {
        try {
            //检测是否有写的权限
            val permission = ActivityCompat.checkSelfPermission(
                activity!!,
                "android.permission.WRITE_EXTERNAL_STORAGE"
            )
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
                )
            }else{
                hasPermissions()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            0 -> if (grantResults.isNotEmpty() && grantResults[0] === PackageManager.PERMISSION_GRANTED) {
                hasPermissions()
               // Toast.makeText(this, "申请成功", Toast.LENGTH_SHORT).show()
            } else {
                //Toast.makeText(this, "拒绝权限", Toast.LENGTH_SHORT).show()
            }
        }

    }

    open fun hasPermissions() {


    }


    abstract fun getLayoutId(): Int
    abstract fun initPresenter()
}