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
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_brand.*
import kotlinx.android.synthetic.main.layout_search_title.*

class Brand : BaseActivity<NetData>() , OnItemClickListener, View.OnClickListener {

    private var mBrandAdapter: BrandAdapter? = null
    private var mLetterAdapter: LetterAdapter? = null
    private var mCityLinearLayoutManager: LinearLayoutManager? = null
    private var mLetterLinearLayoutManager: LinearLayoutManager? = null

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
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }


    override fun onClick(view: View?) {
        if (view?.id == R.id.iv_back) {
            finish()
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
        bundle.putString(Configs.EC_RESULT_Extra,extra)
        intent.putExtras(bundle)
        setResult(Configs.EC_BRAND_RESULT_CODE,intent)
        finish()
    }
}