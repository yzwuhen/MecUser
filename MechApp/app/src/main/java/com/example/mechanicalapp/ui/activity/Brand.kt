package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.BrandAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.BrandData
import com.example.mechanicalapp.ui.mvp.impl.MecModelPresenter
import com.example.mechanicalapp.ui.mvp.v.MecAttrsView
import com.example.mechanicalapp.ui.view.SideBarView
import kotlinx.android.synthetic.main.activity_brand.*
import kotlinx.android.synthetic.main.layout_title.*

class Brand : BaseCusActivity() , OnItemClickListener, SideBarView.OnClickListener, View.OnClickListener,MecAttrsView<BrandData> {

    private var mBrandAdapter: BrandAdapter? = null
    private var mCityLinearLayoutManager: LinearLayoutManager? = null
    private var mPresenter: MecModelPresenter?=null
    private var mBrandList: MutableList<BrandData> = ArrayList<BrandData>()
    private var mLetterList = ArrayList<String>()
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
        tv_title.text ="机械品牌"

        mCityLinearLayoutManager = LinearLayoutManager(this)
        mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL




        mBrandAdapter = BrandAdapter(this, mBrandList, this)

        ry_brand.layoutManager = mCityLinearLayoutManager

        ry_brand.adapter = mBrandAdapter

        iv_back.setOnClickListener(this)
        tv_unlimited.setOnClickListener(this)

        sb_letter.setContentDataList(items)
        sb_letter.setEqualItemSpace(true)
        sb_letter.setOnSidleClickListener(this)

        mPresenter = MecModelPresenter(this,this)
        mPresenter?.getMecBrandList()

        var type = intent.getIntExtra("type",0)
        if (type==1){
            tv_unlimited.visibility =View.GONE
        }
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }


    override fun onItemDown(position: Int, itemContent: String?) {

    }

    override fun onItemMove(position: Int, itemContent: String?) {

    }

    override fun onItemUp(position: Int, itemContent: String?) {
    }
    override fun onClick(view: View?) {
//        if (view?.id == R.id.iv_back) {
//            finish()
//        }
        when(view?.id){
            R.id.iv_back->finish()
            R.id.tv_unlimited->callback("不限",null)
        }
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.ly_city_root->callback(mBrandList[position].brandName,mBrandList[position].id)
        }
    }

    private fun callback(extra: String,id:String?) {

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

//        for (position in mBrandList.indices){
//
//            if (position == 0) {
//                if (TextUtils.isEmpty(mBrandList[position].brandFirst)){
//                    mLetterList.add("*")
//                }else{
//                    mLetterList.add(mBrandList[position].brandFirst)
//                }
//            } else {
//                if (mBrandList[position].brandFirst != mBrandList[position - 1].brandFirst) {
//                    if (TextUtils.isEmpty(mBrandList[position].brandFirst)){
//                        mLetterList.add("*")
//                    }else{
//                        mLetterList.add(mBrandList[position].brandFirst)
//                    }
//                }
//            }
//
//        }
//        sb_letter.setContentDataList(mLetterList)
//        sb_letter.setEqualItemSpace(true)
//        sb_letter.setOnSidleClickListener(this)
    }

    override fun loadMore(list: List<BrandData>) {
        mBrandList.addAll(list)
        mBrandAdapter?.notifyDataSetChanged()
    }
}