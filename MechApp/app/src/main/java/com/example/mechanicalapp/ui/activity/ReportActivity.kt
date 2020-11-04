package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_report.*
import kotlinx.android.synthetic.main.layout_search_et.iv_back
import kotlinx.android.synthetic.main.layout_title.*

class ReportActivity: BaseActivity<NetData>() , OnItemClickListener,View.OnClickListener,
    PopUtils.onViewListener {

    private var mPicAdapter :PicAdapter?=null

    private var mPicList :MutableList<String> ?=null
    private var mStringList :MutableList<String> = ArrayList<String>()
    private var popRecy : RecyclerView?=null
    private var mScreenAdapter :ScreenAdapter ?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_report
    }

    override fun initView() {
        super.initView()
        mPicList = ArrayList<String>()
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")


        mStringList?.add("信息内容不真实")
        mStringList?.add("发布涉黄内容")
        mStringList?.add("违法违规")
        mStringList?.add("不友善内容")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)

        ry_pic.layoutManager =GridLayoutManager(this,3)
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="举报"
        tv_report_reason.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_report_reason->showInput()
        }
    }

    private fun showInput() {

        this?.let { PopUtils.init(this, it,this) }
        PopUtils.showPopupWindow(tv_report_reason)
    }

    override fun getView(view: View?) {

        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this,mStringList,this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {

    }
}