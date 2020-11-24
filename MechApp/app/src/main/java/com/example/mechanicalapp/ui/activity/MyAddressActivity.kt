package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MyAddressAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CityData
import com.example.mechanicalapp.ui.data.MyAddressBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReAddress
import com.example.mechanicalapp.ui.mvp.impl.AddressPresenterImpl
import com.example.mechanicalapp.ui.mvp.v.AddressView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_my_address.*
import kotlinx.android.synthetic.main.item_address.view.*
import kotlinx.android.synthetic.main.layout_title.*

class MyAddressActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener, AddressView {

    private var mMyAddressAdapter: MyAddressAdapter? = null
    var mList: MutableList<ReAddress> = ArrayList<ReAddress>()

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopWindow: PopupWindow? = null

    private var mPresenter: AddressPresenterImpl? = null

    private var delIndex=0
    private var editIndex=0
    private var type =0
    override fun getLayoutId(): Int {

        return R.layout.activity_my_address
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的地址"

        type = intent.getIntExtra("type",0)
        mMyAddressAdapter = MyAddressAdapter(this, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mMyAddressAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        //  spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)


        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as AddressPresenterImpl).getAddressList()
            }

            override fun onLoadmore() {
            }
        })



        tv_btn.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        mPresenter?.getAddressList()
    }
    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }


    override fun initPresenter() {
        mPresenter = AddressPresenterImpl(this)
        //  mPresenter?.getAddressList()
    }

    override fun showCity(list: List<CityData>) {

    }

    override fun showData(netData: NetData?) {
        if (netData != null && netData is MyAddressBean) {
            mList.clear()
            mList.addAll(netData.result.records)
            mMyAddressAdapter?.notifyDataSetChanged()
        }else{
            ToastUtils.showText(netData?.message)
            spring_list?.callFresh()
        }
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
            R.id.tv_del -> del(position)
            R.id.tv_edit -> edit(position)
            R.id.tv_check->checkDefalut(position)
            R.id.ly_root->callBaclk(position)
        }

    }

    private fun callBaclk(position: Int) {

        if (type==1){
            var intent  = Intent()
            var bundle = Bundle()
            bundle.putSerializable(Configs.SCREEN_RESULT_Extra,mList[position])
            intent.putExtras(bundle)
            setResult(Configs.ADDRESS_LIST_SELECT_RESULT,intent)
            finish()
        }
    }

    private fun checkDefalut(position: Int) {
        if (mList[position].isDefault==1){
            mList[position].isDefault=0
        }else{
            mList[position].isDefault=1
        }
        mPresenter?.editAddress(mList[position])
    }

    private fun edit(position: Int) {
        editIndex =position
        var bundle = Bundle()

        if (position == -1) {
            bundle.putInt("address_type", 0)
        } else {
            bundle.putInt("address_type", 1)
            bundle.putSerializable("data",mList[position])
        }
        jumpActivity(bundle, AddressActivity::class.java)

    }

    private fun del(position: Int) {
        delIndex =position
        if (mPopWindow == null) {
            mPopWindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }
        popInfo?.text = "确认要删除该地址？"
        popCancel?.text = "取消"
        popSure?.text = "确定"

        this?.let { PopUtils.showPopupWindow(tv_title, it) }

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_pop_sure -> {
                PopUtils.dismissPop(this)
                mPresenter?.delAddress(mList[delIndex])
            }
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.tv_btn -> edit(-1)
        }
    }

    override fun getView(view: View?) {
        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)

    }
}