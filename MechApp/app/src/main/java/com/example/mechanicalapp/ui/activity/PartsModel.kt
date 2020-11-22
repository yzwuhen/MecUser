package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.ui.view.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EcModelAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecModelData
import com.example.mechanicalapp.ui.mvp.impl.PartsTypePresenter
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import kotlinx.android.synthetic.main.activity_ec_model.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsModel : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    MecAttrsView<MecModelData> {


    private var mAdapter: EcModelAdapter?=null
    var mList: MutableList<MecModelData> = ArrayList<MecModelData>()

    private var mPresenter: PartsTypePresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_ec_model

    }

    override fun initView() {
        super.initView()


        mAdapter = EcModelAdapter(this, mList, this)

        recycler_list.layoutManager = GridLayoutManager(this,3)
        recycler_list.addItemDecoration(MyDecoration(2))
        recycler_list.adapter = mAdapter

        tv_title.text="型号"

        tv_unlimited.setOnClickListener(this)
        iv_back.setOnClickListener(this)

        mPresenter = PartsTypePresenter(this,this)
        mPresenter?.getPartsModelList()
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }


    override fun onItemClick(view: View, position: Int) {
        callback(mList[position].modelName,mList[position].id)
    }
    private fun callback(extra: String,id:String) {

        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,extra)
        bundle.putString(Configs.SCREEN_RESULT_ID,id)
        intent.putExtras(bundle)
        setResult(Configs.EC_MODEL_RESULT_CODE,intent)
        finish()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限","0")
        }

    }


    override fun refreshUI(list: List<MecModelData>) {
        mList.clear()
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<MecModelData>) {
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }
}