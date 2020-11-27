package com.example.mechanicalapp.ui.fragment.mine

import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.*
import com.example.mechanicalapp.ui.adapter.MineMenuAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : BaseFragment<NetData>(), OnItemClickListener, View.OnClickListener {

    private var mineMenuAdapter: MineMenuAdapter? = null

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_mine
    }

    override fun onResume() {
        super.onResume()
        showInfo()
    }

    private fun showInfo() {
        tv_user_nick.text = App.getInstance().userInfo.realname
        tv_phone.text = App.getInstance().userInfo.phone
        tv_company.text =App.getInstance().userInfo.realname
        ImageLoadUtils.loadImageCenterCrop(
            mContext,
            iv_user_pic,
            App.getInstance().userInfo.avatar,
            R.mipmap.ic_launcher
        )
    }

    override fun initView() {
        super.initView()

        mineMenuAdapter = MineMenuAdapter(mContext, this)
        recycle_list.layoutManager = GridLayoutManager(mContext, 4)
        recycle_list.adapter = mineMenuAdapter

        tv_edit.setOnClickListener(this)
        ly_integral.setOnClickListener(this)
        ly_collected.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        ly_release.setOnClickListener(this)
        iv_user_pic.setOnClickListener(this)
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {

        when (position) {
            0 ->
                if (isLogin()) {
                    jumpActivity(null, PersonalCertification::class.java)
                }
            1 ->
                if (isLogin()) {
                    jumpActivity(null, CompanyCertifyActivity::class.java)
                }
            2 ->
                if (isLogin()) {
                    jumpActivity(null, MyMecListActivity::class.java)
                }
            3 -> if (isLogin()) {
                jumpActivity(null, MyLookActivity::class.java)
            }
            4 -> if (isLogin()) {
                jumpActivity(null, OrderCenterActivity::class.java)
            }
            5 ->  if (isLogin()) {
                jumpActivity(null, PartsOrderActivity::class.java)
            }
            6 ->  if (isLogin()) {
                jumpActivity(null, FactoryApplyActivity::class.java)
            }
            7 -> jumpActivity(null, SettingActivity::class.java)
            9 -> if (isLogin()) {
                jumpActivity(null, SuggestActivity::class.java)
            }
        }
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.iv_user_pic -> jumpActivity(null, LoginActivity::class.java)
            R.id.tv_edit -> {
                if (isLogin()) {
                    jumpActivity(null, UserDataActivity::class.java)
                }
            }
            R.id.ly_address -> {
                if (isLogin()) {
                    jumpActivity(null, MyAddressActivity::class.java)
                }
            }
            R.id.ly_integral -> {
                if (isLogin()) {
                    jumpActivity(null, MyIntegralActivity::class.java)
                }
            }
            R.id.ly_collected -> {
                if (isLogin()) {
                    jumpActivity(null, MyCollectActivity::class.java)
                }
            }
            R.id.ly_release -> {
                if (isLogin()) {
                    jumpActivity(null, MyReleaseActivity::class.java)
                }
            }
        }

    }

    private fun isLogin(): Boolean {
        if (TextUtils.isEmpty(App.getInstance().token)) {
            //ToastUtils.showText("请先登录")
            jumpActivity(null,LoginActivity::class.java)
            return false
        }
        return true
    }
}