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
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class EcType:BaseActivity<NetData>(), OnItemClickListener ,View.OnClickListener{


    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: EcTypeRightAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    private var mRightList: MutableList<String> = ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()

        mList.add("所有类型")
        mList.add("挖掘机")
        mList.add("推土机")
        mList.add("旋挖机")
        mList.add("汽车吊")
        mList.add("泵车")
        mList.add("装载机")


        mRightList.add("履带式挖掘机")
        mRightList.add("轮式挖掘机")
        mRightList.add("水陆挖掘机")
        mRightList.add("履带式挖掘机")
        mRightList.add("轮式挖掘机")
        mRightList.add("水陆挖掘机")
        mRightList.add("轮式挖掘机")
        mRightList.add("水陆挖掘机")
        mRightList.add("轮式挖掘机")
        mRightList.add("水陆挖掘机")

        mLeftAdapter = EcTypeLeftAdapter(this, mList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = EcTypeRightAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,3)
        recycler_list_right.adapter = mRightAdapter


        tv_title.text="机械类型"

        tv_unlimited.setOnClickListener(this)
        iv_back.setOnClickListener(this)

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }



    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.ly_type->callback(mRightList[position])
        }
    }

    private fun callback(callbackkStr: String) {
        var intent  =Intent()
        var bundle =Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,callbackkStr)
        intent.putExtras(bundle)
        setResult(Configs.EC_TYPE_RESULT_CODE,intent)
        finish()
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限")
        }

    }
}