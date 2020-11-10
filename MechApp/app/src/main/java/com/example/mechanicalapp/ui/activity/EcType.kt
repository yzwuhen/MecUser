package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.EcTypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.EcTypeRightAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.MecModelPresenter
import com.example.mechanicalapp.ui.mvp.v.MecTypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class EcType:BaseCusActivity(), OnItemClickListener ,View.OnClickListener, MecTypeView<BaseData> {


    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: EcTypeRightAdapter? = null
    var mList: MutableList<MecTypeParentData> = ArrayList<MecTypeParentData>()

    private var mRightList: MutableList<MecTypeChildData> = ArrayList<MecTypeChildData>()
    private var mPresenter: MecModelPresenter?=null
    private var index:Int =0;

    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }

    override fun initView() {
        super.initView()

        mLeftAdapter = EcTypeLeftAdapter(this, mList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = EcTypeRightAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,3)
        recycler_list_right.adapter = mRightAdapter


        tv_title.text="机械类型"

        tv_unlimited.setOnClickListener(this)
        iv_back.setOnClickListener(this)
        mPresenter = MecModelPresenter(this,this)
        mPresenter?.getMecTypeList()
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
            R.id.tv_type->{
                if (index!=position){
                    mList[index].isSelect =false
                    mLeftAdapter?.notifyItemChanged(index)
                    mList[position].isSelect =true
                    mLeftAdapter?.notifyItemChanged(position)
                    mPresenter?.getMecTypeChildList(mList[position].id)
                    index = position
                }
            }
            R.id.ly_type->callback(mRightList[position].cateName,mRightList[position].id)
        }
    }

    private fun callback(callbackStr: String,id:String) {
        var intent  =Intent()
        var bundle =Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,callbackStr)
        bundle.putString(Configs.SCREEN_RESULT_ID,id)
        intent.putExtras(bundle)
        setResult(Configs.EC_TYPE_RESULT_CODE,intent)
        finish()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限","0")
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