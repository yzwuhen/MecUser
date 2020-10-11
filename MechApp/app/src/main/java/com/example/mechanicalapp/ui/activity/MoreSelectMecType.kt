package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EcTypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.MoreSelMecTypeAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class MoreSelectMecType : BaseActivity<NetData>(), OnItemClickListener ,View.OnClickListener{


    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: MoreSelMecTypeAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    private var callbackkStr:String=""

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

        tv_title.text="机械类型"
        tv_right.text="完成"
        tv_right.visibility =View.VISIBLE

        mLeftAdapter = EcTypeLeftAdapter(this, mList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = MoreSelMecTypeAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = GridLayoutManager(this,3)
        recycler_list_right.adapter = mRightAdapter



        iv_back.setOnClickListener(this)
        tv_right.setOnClickListener(this)

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

        when(view?.id){
            R.id.ly_type->sel(mRightList[position])
        }
    }

    private fun sel(s: String) {
        callbackkStr += s
    }


    private fun callback() {
        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.EC_RESULT_Extra,callbackkStr)
        intent.putExtras(bundle)
        setResult(Configs.EC_TYPE_RESULT_CODE,intent)
        finish()
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_right->callback()
        }

    }
}