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

        if (TextUtils.isEmpty(App.getInstance().token)){
            tv_user_nick.visibility =View.GONE
            iv_sex.visibility=View.GONE
            iv_user_sr.visibility =View.GONE
            tv_phone.visibility=View.GONE
        }else{
            tv_user_nick.visibility =View.VISIBLE
            iv_sex.visibility=View.VISIBLE
            iv_user_sr.visibility =View.VISIBLE
            tv_phone.visibility=View.VISIBLE
        }

        tv_user_nick.text = App.getInstance().userInfo.realname
        tv_phone.text = App.getInstance().userInfo.phone
        if (App.getInstance().userInfo.isEnterprise=="1"){
            tv_company.visibility =View.VISIBLE
                  tv_company.text =App.getInstance().userInfo.realname
        }else{
            tv_company.visibility =View.GONE
        }
        if (App.getInstance().userInfo.sex==1){
            iv_sex.setImageResource(R.mipmap.sex_man)
        }else{
            iv_sex.setImageResource(R.mipmap.sex_women)
        }

        if (TextUtils.isEmpty(App.getInstance().userInfo.avatar)){
            iv_user_pic.setImageResource(R.mipmap.user_default)
        }else{
            ImageLoadUtils.loadImageCenterCrop(
                mContext,
                iv_user_pic,
                App.getInstance().userInfo.avatar,
                R.mipmap.user_default
            )
        }
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
            R.id.iv_user_pic ->  if (isLogin()) {
                jumpActivity(null, UserDataActivity::class.java)
            }
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