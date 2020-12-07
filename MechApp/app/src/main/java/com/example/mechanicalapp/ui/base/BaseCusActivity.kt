package com.example.mechanicalapp.ui.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.utils.Density
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.act_base.*

abstract class BaseCusActivity : AppCompatActivity() {
    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE",
        "android.permission.CAMERA",
        "android.permission.ACCESS_COARSE_LOCATION",
        "android.permission.ACCESS_FINE_LOCATION"
    )

    private var mLoadingView: View? = null
    private var mEmptyView: View? = null
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
            } else {
                hasPermissions()
            }
        } catch (e: Exception) {
            Log.v("sss", "sssss授权错误$e")
            e.printStackTrace()
        }
    }

    /**
     * 跳转到其他界面返回===> 携带参数过去 上面涉及太多 新添加一个
     * 主要是跳转是否需要显示不限 ，不考虑其它情况先了
     */
    open fun jumpActivityForResult(
        result: Int,
        type: Int,
        targetActivity: Class<*>?
    ) {
        val intent = Intent()
        intent.setClass(this, targetActivity!!)

        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        intent.putExtra("type", type)
        startActivityForResult(intent, result)
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
    open fun openCall(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
    open fun hasPermissions() {

    }
    open fun jumThreeMap(lat: String?, lon: String?, name: String?){

        try {
//            val intent = Intent.getIntent(
//                "androidamap://navi?sourceApplication=&poiname=${name}&lat=${lat}&lon=${lon}&dev=0"
//            )
            val intent = Intent.getIntent(
                ("intent://map/direction?destination=latlng:${lat},${lon}|name:${name}&mode=driving&" +  //选择导航方式 此处为驾驶
                        "region=" +  //
                        "&src=#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end"
            ))
            startActivity(intent)
        }catch (e: java.lang.Exception){

            Log.v("sssss", "ssssssssss$e")
            ToastUtils.showText("跳转失败")
        }

    }

    open fun isLocationEnabled(context: Context): Boolean {
        var locationMode = 0
        val locationProviders: String
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            locationMode = try {
                Settings.Secure.getInt(context.contentResolver, Settings.Secure.LOCATION_MODE)
            } catch (e: SettingNotFoundException) {
                e.printStackTrace()
                return false
            }
            locationMode != Settings.Secure.LOCATION_MODE_OFF
        } else {
            locationProviders = Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED
            )
            !TextUtils.isEmpty(locationProviders)
        }
    }


    open fun showLoadView() {
        if (mLoadingView == null) {
            mLoadingView = View.inflate(this, R.layout.loading_view, null)
        }
        if (mLoadingView?.parent == null) {
            fl_root.addView(mLoadingView)
        }
    }
    open fun showEmptyView(){
        if (mEmptyView == null) {
            mEmptyView = View.inflate(this, R.layout.empty_view, null)
        }
        if (mEmptyView?.parent == null) {
            fl_root.addView(mEmptyView)
        }
    }
    open fun hideEmptyView(){
        if (mEmptyView != null) {
            if (mEmptyView?.parent != null) {
                fl_root.removeView(mEmptyView)
            }
        }
    }

    open fun hideLoadingView() {
        if (mLoadingView != null) {
            if (mLoadingView?.parent != null) {
                fl_root.removeView(mLoadingView)
            }
        }
    }


    abstract fun getLayoutId(): Int
    abstract fun initPresenter()
}