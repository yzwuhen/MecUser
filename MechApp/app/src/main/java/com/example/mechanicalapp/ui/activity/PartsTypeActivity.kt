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
import com.example.mechanicalapp.ui.data.MecTypeBean
import com.example.mechanicalapp.ui.data.MecTypeChildData
import com.example.mechanicalapp.ui.data.MecTypeData
import com.example.mechanicalapp.ui.mvp.impl.PartsTypePresenter
import com.example.mechanicalapp.ui.mvp.v.TypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class PartsTypeActivity : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    TypeView<MecTypeBean> {


    private var mLeftAdapter: PartsTypeLeftAdapter? = null
    private var mRightAdapter: PartsTypeRightAdapter? = null
    var mLeftList: MutableList<MecTypeData> = ArrayList<MecTypeData>()
    private var index:Int =0
    private var mRightList: MutableList<MecTypeChildData> = ArrayList<MecTypeChildData>()
    private var mPresenter: PartsTypePresenter?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()

        mLeftAdapter = PartsTypeLeftAdapter(this, mLeftList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = PartsTypeRightAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,3)
        recycler_list_right.adapter = mRightAdapter


        tv_title.text="配件类型"

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
            R.id.tv_type->{
                if (index!=position){
                    mLeftList[index].isSelect =false
                    mLeftAdapter?.notifyItemChanged(index)
                    mLeftList[position].isSelect =true
                    mLeftAdapter?.notifyItemChanged(position)

                    mRightList.clear()
                    mRightList.addAll(mLeftList[position].partsList)
                    mRightAdapter?.notifyDataSetChanged()
                    index = position
                }
            }
            R.id.ly_type->callback(mRightList[position].name,mRightList[position].id)
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

    override fun refreshLeftUI(bean: MecTypeBean?) {
        mLeftList.clear()
        if (bean!=null&&bean?.code==200){
            mLeftList.addAll(bean?.result)
            if (mLeftList.size>0){
                mLeftList[0].isSelect =true
                mRightList.addAll(bean.result[0].partsList)

            }
        }
        mLeftAdapter?.notifyDataSetChanged()
        mRightAdapter?.notifyDataSetChanged()

    }

}