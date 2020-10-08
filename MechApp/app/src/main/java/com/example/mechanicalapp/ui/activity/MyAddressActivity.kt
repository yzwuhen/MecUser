package com.example.mechanicalapp.ui.activity

import android.location.Address
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MyAddressAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_my_address.*
import kotlinx.android.synthetic.main.layout_title.*

class MyAddressActivity:BaseActivity<NetData>(),OnItemClickListener,View.OnClickListener ,PopUtils.onViewListener{

    private var mMyAddressAdapter: MyAddressAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopWindow: PopupWindow? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_my_address
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的地址"


        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mMyAddressAdapter = MyAddressAdapter(this, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mMyAddressAdapter

        tv_btn.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.tv_del->del(position)
            R.id.tv_edit->edit(position)

        }

    }

    private fun edit(position: Int) {

        var bundle=Bundle()

        if (position==-1){
            bundle.putInt("address_type",0)
        }else{
            bundle.putInt("address_type",1)
        }
        jumpActivity(bundle,AddressActivity::class.java)

    }

    private fun del(position: Int) {

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

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_pop_sure -> PopUtils.dismissPop(this)
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.tv_btn->edit(-1)
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