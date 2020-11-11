package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PartsTypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.PartsTypeRightAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.ui.data.MecTypeParentData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.MecModelPresenter
import com.example.mechanicalapp.ui.mvp.impl.PartsTypePresenter
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import com.example.mechanicalapp.ui.mvp.v.MecTypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsTypeActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    MecTypeView<NetData> {


    private var mLeftAdapter: PartsTypeLeftAdapter? = null
    private var mRightAdapter: PartsTypeRightAdapter? = null
    var mList: MutableList<MecTypeParentData> = ArrayList<MecTypeParentData>()

    private var mRightList: MutableList<MecTypeChildData> = ArrayList<MecTypeChildData>()
    private var mPresenter: PartsTypePresenter?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()

        mLeftAdapter = PartsTypeLeftAdapter(this, mList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = PartsTypeRightAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,3)
        recycler_list_right.adapter = mRightAdapter


        tv_title.text="机械类型"

        tv_unlimited.setOnClickListener(this)
        iv_back.setOnClickListener(this)
        mPresenter = PartsTypePresenter(this,this)
        mPresenter?.getPartsTypeList()
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

        when(view?.id){
            R.id.ly_type->callback(mRightList[position].cateName,mRightList[position].id)
        }
    }

    private fun callback(callbackStr: String,id:String?) {
        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,callbackStr)
        if (!TextUtils.isEmpty(id)){
            bundle.putString(Configs.SCREEN_RESULT_ID,id)
        }
        intent.putExtras(bundle)
        setResult(Configs.EC_TYPE_RESULT_CODE,intent)
        finish()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限",null)
        }

    }


    override fun refreshLeftUI(list: List<MecTypeParentData>) {
        mList.clear()
        mList.addAll(list)
        mList[0].isSelect =true
        mLeftAdapter?.notifyDataSetChanged()
    }

    override fun loadLeftMore(list: List<MecTypeParentData>) {
        mList.addAll(list)
        mLeftAdapter?.notifyDataSetChanged()
    }

    override fun refreshRightUI(list: MutableList<MecTypeChildData>) {
        mRightList.clear()
        mRightList.addAll(list)
        mRightAdapter?.notifyDataSetChanged()
    }

    override fun loadRightMore(list: List<MecTypeChildData>) {
        mRightList.addAll(list)
        mRightAdapter?.notifyDataSetChanged()
    }

}