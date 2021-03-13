package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MoreSelMecTypeAdapter
import com.example.mechanicalapp.ui.adapter.TypeLeftAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecTypeBean
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.ui.data.MecTypeData
import com.example.mechanicalapp.ui.mvp.impl.MoreTypePresenter
import com.example.mechanicalapp.ui.mvp.v.TypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class SelPartsType : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    OnItemClickLevelListener,
    TypeView<MecTypeBean> {

    private var mLeftAdapter: TypeLeftAdapter? = null
    private var mRightAdapter: MoreSelMecTypeAdapter? = null
    var mLeftList: MutableList<MecTypeData> = ArrayList<MecTypeData>()
    var mRightList: MutableList<MecTypeChildData> = ArrayList<MecTypeChildData>()
    private var callbackkStr:String=""
    private var mMoreTypePresenter: MoreTypePresenter?=null

    private var leftIndex:Int=0
    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }

    override fun initView() {
        super.initView()

        tv_title.text="配件类型"
        tv_right.text="完成"
        tv_right.visibility = View.VISIBLE

        tv_unlimited.visibility = View.GONE

        mLeftAdapter = TypeLeftAdapter(this, mLeftList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter

        mRightAdapter = MoreSelMecTypeAdapter(this, mRightList, 0,this)
        recycler_list_right.layoutManager = GridLayoutManager(this, 3)
        recycler_list_right.adapter = mRightAdapter


        iv_back.setOnClickListener(this)
        tv_right.setOnClickListener(this)

    }

    override fun initPresenter() {
        mMoreTypePresenter = MoreTypePresenter(this)
        mMoreTypePresenter?.getPartType()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }


    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.tv_type -> selectLeft(position,true)
        }
    }

    private fun selectLeft(position: Int, b: Boolean) {
        try {
            if (leftIndex!=position){
                mLeftList[leftIndex].isSelect= false
                mLeftAdapter?.notifyItemChanged(leftIndex)
                mLeftList[position].isSelect =true
                mLeftAdapter?.notifyItemChanged(position)
                leftIndex =position

                mRightList.clear()
                if (mLeftList[position].partsList!=null){
                    mRightList.addAll(mLeftList[position].partsList)
                }
                mRightAdapter?.notifyDataSetChanged()
            }
        }catch (e: Exception){

        }

    }


    private fun selType(){
        if (mRightList.size>0){
            for (child in mRightList.iterator()){
                if (child.isSelect){
                    callbackkStr += "${child.name},"
                }
            }
        }
        callback()
    }

    private fun callback() {
        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra, callbackkStr)
        intent.putExtras(bundle)
        setResult(Configs.PARTS_TYPE_RESULT_CODE, intent)
        finish()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_right->selType()
        }
    }
    override fun refreshLeftUI(bean: MecTypeBean?) {
        mLeftList.clear()
        if (bean!=null&&bean?.code==200){
            mLeftList.addAll(bean?.result)
            if (mLeftList.size>0){
                mLeftList[0].isSelect =true

                if (mLeftList[0].partsList!=null){
                    mRightList.addAll(mLeftList[0].partsList)
                }
            }
        }
        mLeftAdapter?.notifyDataSetChanged()
        mRightAdapter?.notifyDataSetChanged()

    }

    override fun onItemClick(view: View, position: Int, childPosition: Int) {
        mRightList[childPosition].isSelect = !mRightList[childPosition].isSelect
        mRightAdapter?.notifyItemChanged(childPosition)
    }
}