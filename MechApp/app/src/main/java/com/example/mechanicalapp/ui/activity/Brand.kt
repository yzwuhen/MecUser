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
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.BrandData
import com.example.mechanicalapp.ui.mvp.impl.MecModelPresenter
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import kotlinx.android.synthetic.main.activity_brand.*
import kotlinx.android.synthetic.main.layout_title.*

class Brand : BaseCusActivity() , OnItemClickListener, View.OnClickListener,MecAttrsView<BrandData> {

    private var mBrandAdapter: BrandAdapter? = null
    private var mLetterAdapter: LetterAdapter? = null
    private var mCityLinearLayoutManager: LinearLayoutManager? = null
    private var mLetterLinearLayoutManager: LinearLayoutManager? = null
    private var mPresenter: MecModelPresenter?=null
    private var mBrandList: MutableList<BrandData> = ArrayList<BrandData>()
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

        mLetterAdapter = LetterAdapter(this, items, this)

        mBrandAdapter = BrandAdapter(this, mBrandList, this)

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

    override fun err()  {
    }


    override fun onClick(view: View?) {
//        if (view?.id == R.id.iv_back) {
//            finish()
//        }
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限","0")
        }
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.ly_city_root->callback(mBrandList[position].brandName,mBrandList[position].id)
        }
    }

    private fun callback(extra: String,id:String) {

        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,extra)
        bundle.putString(Configs.SCREEN_RESULT_ID,id)
        intent.putExtras(bundle)
        setResult(Configs.EC_BRAND_RESULT_CODE,intent)
        finish()
    }

    override fun refreshUI(list: List<BrandData>) {
        mBrandList.clear()
        mBrandList.addAll(list)
        mBrandAdapter?.notifyDataSetChanged()

    }

    override fun loadMore(list: List<BrandData>) {
        mBrandList.addAll(list)
        mBrandAdapter?.notifyDataSetChanged()
    }
}