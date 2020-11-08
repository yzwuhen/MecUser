package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.BrandAdapter
import com.example.mechanicalapp.ui.adapter.LetterAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.MecModelPresenter
import com.example.mechanicalapp.ui.mvp.v.MecAtrrsView
import kotlinx.android.synthetic.main.activity_brand.*
import kotlinx.android.synthetic.main.layout_title.*

class Brand : BaseCusActivity() , OnItemClickListener, View.OnClickListener,MecAtrrsView<NetData> {

    private var mBrandAdapter: BrandAdapter? = null
    private var mLetterAdapter: LetterAdapter? = null
    private var mCityLinearLayoutManager: LinearLayoutManager? = null
    private var mLetterLinearLayoutManager: LinearLayoutManager? = null
    private var mPresenter: MecModelPresenter?=null
    private var mCityList: MutableList<String> = ArrayList<String>()
    private val items = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Z"
    )


    override fun getLayoutId(): Int {
        return R.layout.activity_brand;
    }

    override fun initView() {
        super.initView()
        mCityLinearLayoutManager = LinearLayoutManager(this)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL


        mLetterLinearLayoutManager = LinearLayoutManager(this)
        mLetterLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL

//        mCityList = ArrayList<String>()

        mCityList?.add("八达重工1")
        mCityList?.add("八达重工2")
        mCityList?.add("八达重工3")
        mCityList?.add("八达重工4")
        mCityList?.add("八达重工5")
        mCityList?.add("八达重工6")
        mCityList?.add("八达重工7")
        mCityList?.add("八达重工8")
        mCityList?.add("八达重工9")
        mCityList?.add("八达重工0")
        mCityList?.add("八达重工11")
        mCityList?.add("八达重工12")
        mCityList?.add("八达重工13")
        mCityList?.add("八达重工14")
        mCityList?.add("八达重工")



        mLetterAdapter = LetterAdapter(this, items, this)

        mBrandAdapter = BrandAdapter(this, mCityList as MutableList<String>, this)

        ry_brand.layoutManager = mCityLinearLayoutManager
        ry_brand_letter.layoutManager = mLetterLinearLayoutManager

        ry_brand.adapter = mBrandAdapter
        ry_brand_letter.adapter = mLetterAdapter

        iv_back.setOnClickListener(this)
        tv_unlimited.setOnClickListener(this)

        mPresenter = MecModelPresenter(this,this)
        mPresenter?.getMecBrandList()
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }


    override fun onClick(view: View?) {
//        if (view?.id == R.id.iv_back) {
//            finish()
//        }
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限")
        }
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.ly_city_root->callback(mCityList[position])
        }
    }

    private fun callback(extra: String) {

        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,extra)
        intent.putExtras(bundle)
        setResult(Configs.EC_BRAND_RESULT_CODE,intent)
        finish()
    }
}