package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_report.*
import kotlinx.android.synthetic.main.layout_title.*

class SuggestActivity:BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{

    private var mPicAdapter : PicAdapter?=null

    private var mPicList :MutableList<String> ?=null

    override fun getLayoutId(): Int {

        return R.layout.activity_suggest

    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="意见反馈"

        mPicList = ArrayList<String>()
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")

        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)
        ry_pic.layoutManager = GridLayoutManager(this,3)
        ry_pic.adapter = mPicAdapter
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
        }
    }

    override fun onItemClick(view: View, position: Int) {


    }
}