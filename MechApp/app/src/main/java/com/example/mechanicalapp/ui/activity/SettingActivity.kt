package com.example.mechanicalapp.ui.activity

import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import cn.jpush.android.api.JPushInterface
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.UserInfo
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.MyDataCleanManager
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.auth.AuthService
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.layout_title.*


class SettingActivity : BaseActivity<NetData>(), View.OnClickListener, PopUtils.onViewListener {

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null
    private var dataSize: String? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_setting
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "设置"

        ly_modify_phone.setOnClickListener(this)
        ly_shock.setOnClickListener(this)
        ly_voice.setOnClickListener(this)
        ly_modify_pwd.setOnClickListener(this)
        ly_clear.setOnClickListener(this)
        ly_update.setOnClickListener(this)
        ly_about_us.setOnClickListener(this)
        ly_reset_user.setOnClickListener(this)
        ly_login_out.setOnClickListener(this)
        tv_agreement.setOnClickListener(this)
        tv_privacy.setOnClickListener(this)

        try {
            dataSize = MyDataCleanManager.getTotalCacheSize(applicationContext)
            tv_cache.text = dataSize
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

    override fun onClick(v: View?) {


        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_shock -> shock()
            R.id.ly_voice -> voice()
            R.id.ly_modify_phone -> jumpActivity(null, ModifyPhoneGetCodeActivity::class.java)
            R.id.ly_modify_pwd -> jumpActivity(null, ModifyPwdActivity::class.java)
            R.id.ly_clear -> clearAppCache()
            R.id.ly_update -> updateApp()
            R.id.ly_about_us -> jumpActivity(null, AboutUsActivity::class.java)
            R.id.ly_reset_user -> resetUser()
            R.id.ly_login_out -> loginout()
            R.id.tv_agreement -> jumpActivity(null, AgreementActivity::class.java)
            R.id.tv_privacy -> jumpActivity(null, PrivacyActivity::class.java)
            R.id.tv_pop_sure -> dismiss()
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
        }
    }

    private fun showPop(i: Int) {

        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }
        if (i == 0) {
            popInfo?.text = "注销账号？"
            popCancel?.text = "取消"
            popSure?.text = "确定"
        } else {
            popInfo?.text = "退出登录？"
            popCancel?.text = "取消"
            popSure?.text = "确定"
        }

        this?.let { PopUtils.showPopupWindow(ly_left, it) }

    }

    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    private fun dismiss() {
        PopUtils.dismissPop(this)
        App.getInstance().token = ""
        App.getInstance().setUser(UserInfo())
        Hawk.delete(Configs.TOKEN)
        Hawk.delete(Configs.USER_INFO)
        NIMClient.getService(AuthService::class.java).logout()
        JPushInterface.deleteAlias(App.getInstance().applicationContext,0)
        finish()
    }

    private fun loginout() {
        showPop(1)
    }

    private fun resetUser() {
        showPop(0)
    }

    private fun updateApp() {

    }

    private fun clearAppCache() {

        MyDataCleanManager.clearAllCache(this)
        tv_cache.text = "0B"
    }

    private fun voice() {
        iv_voice.isSelected = !iv_voice.isSelected

    }

    private fun shock() {
        iv_shock.isSelected = !iv_shock.isSelected
    }
}