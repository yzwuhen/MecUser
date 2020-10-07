package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.EcModelAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_ec_model.*

class EcModel :BaseActivity<NetData>(), OnItemClickListener {


    private var mAdapter:EcModelAdapter ?=null
    var mList: MutableList<String> = ArrayList<String>()
    override fun getLayoutId(): Int {

        return R.layout.activity_ec_model

    }

    override fun initView() {
        super.initView()
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = EcModelAdapter(this, mList, this)

        recycler_list.layoutManager = GridLayoutManager(this,3)
        recycler_list.addItemDecoration(MyDecoration(2))
        recycler_list.adapter = mAdapter
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
        callback("Atlas 3306LC")
    }
    private fun callback(extra: String) {

        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.EC_RESULT_Extra,extra)
        intent.putExtras(bundle)
        setResult(Configs.EC_MODEL_RESULT_CODE,intent)
        finish()
    }
}