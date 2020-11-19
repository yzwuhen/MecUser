package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MyMecAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.MyMecPresenter
import kotlinx.android.synthetic.main.activity_my_mec.*
import kotlinx.android.synthetic.main.layout_title.*

class MyMecListActivity : BaseActivity<NetData>(),OnItemClickListener ,View.OnClickListener{


    private var mMyMecAdapter: MyMecAdapter? = null

     private var mList: MutableList<String> = ArrayList<String>()

    private var mPresenter: MyMecPresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_my_mec
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的设备列表"

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        recycler_list.layoutManager = GridLayoutManager(this, 3)
        mMyMecAdapter = MyMecAdapter(this, mList, this)
        recycler_list.addItemDecoration(MyDecoration(3))
        recycler_list.adapter = mMyMecAdapter

        ly_search.setOnClickListener(this)
        tv_add_mec.setOnClickListener(this)
    }

    override fun initPresenter() {
        mPresenter = MyMecPresenter(this)
        mPresenter?.getMecList()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onItemClick(view: View, position: Int) {


        jumpActivity(null,MyMecDetailsActivity::class.java)
    }

    private fun jump() {

        var bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,6)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.iv_back->finish()
            R.id.ly_search->jump()
            R.id.tv_add_mec->jumpActivity(null,AddMecActivity::class.java)
        }
    }
}