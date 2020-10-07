package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.CityAdapter
import com.example.mechanicalapp.ui.adapter.LetterAdapter
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.activity_search_city.*
import kotlinx.android.synthetic.main.layout_search_title.*

class SearchCityActivity :BaseActivity<NetData>() , OnItemClickListener,View.OnClickListener {

    private var mCityAdapter : CityAdapter?=null
    private var mLetterAdapter : LetterAdapter?=null
    private var mCityLinearLayoutManager :LinearLayoutManager ?=null
    private var mLetterLinearLayoutManager :LinearLayoutManager ?=null

    private var mCityList :MutableList<String> ?=null
    private val items = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Z"
    )


    override fun getLayoutId(): Int {
        return R.layout.activity_search_city;
    }

    override fun initView() {
        super.initView()
        mCityLinearLayoutManager = LinearLayoutManager(this)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL


        mLetterLinearLayoutManager = LinearLayoutManager(this)
        mLetterLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL

        mCityList = ArrayList<String>()
        mCityList?.add("广州")
        mCityList?.add("深圳")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("深圳")
        mCityList?.add("广州")
        mCityList?.add("珠海")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("深圳")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("广州")
        mCityList?.add("广州")

        mLetterAdapter = LetterAdapter(this, items,this)

        mCityAdapter = CityAdapter(this, mCityList as MutableList<String>,this)

        ry_city.layoutManager = mCityLinearLayoutManager
        cy_letter.layoutManager = mLetterLinearLayoutManager

        ry_city.adapter =mCityAdapter
        cy_letter.adapter = mLetterAdapter

        iv_back.setOnClickListener(this)
        ly_search.setOnClickListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hiedLoading() {
        TODO("Not yet implemented")
    }

    override fun showData(t: NetData) {
        TODO("Not yet implemented")
    }


    override fun onClick(view: View?) {
        if (view?.id==R.id.iv_back){
            finish()
        }
        else if (view?.id == R.id.ly_search){
            jumpActivity(null,HistorySearchActivity::class.java)
        }

    }

    override fun onItemClick(view: View, position: Int) {

    }
}