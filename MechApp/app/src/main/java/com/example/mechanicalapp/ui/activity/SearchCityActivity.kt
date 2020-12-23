package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.CityAdapter
import com.example.mechanicalapp.ui.adapter.SearchCityAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.CityListBean
import com.example.mechanicalapp.ui.data.HomeCityData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.CityPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.SideBarView
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_search_city.*
import kotlinx.android.synthetic.main.layout_search_title.*

class SearchCityActivity : BaseCusActivity(), View.OnClickListener, TextView.OnEditorActionListener,OnItemClickListener,
    OnItemClickLevelListener, SideBarView.OnClickListener, NetDataView<NetData> {

    private var mCityAdapter: CityAdapter? = null
    private var mCityLinearLayoutManager: LinearLayoutManager? = null

    private var mPresenter: CityPresenter? = null
    private var mCityList = ArrayList<List<CityListBean.ResultBean.GroupListBean>>()
    private var mHostCityList = ArrayList<HomeCityData>()

    private var mSearchList =ArrayList<HomeCityData>()
    private var mSearchAdapter : SearchCityAdapter?=null
    private val items = listOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    )

    override fun getLayoutId(): Int {
        return R.layout.activity_search_city;
    }

    override fun initView() {
        super.initView()


        sb_letter.setContentDataList(items)
        sb_letter.setEqualItemSpace(true)
        sb_letter.setOnSidleClickListener(this)

        iv_back.setOnClickListener(this)
        ly_search.setOnClickListener(this)

        mPresenter = CityPresenter(this)
        mPresenter?.getCityList()

        et_search.setOnEditorActionListener(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }


    override fun onClick(view: View?) {
        if (view?.id == R.id.iv_back) {
            finish()
        }
//        else if (view?.id == R.id.ly_search){
//            jumpActivity(null,HistorySearchActivity::class.java)
//        }
    }

    private fun callback(homeCityData: HomeCityData) {
        Hawk.put(Configs.VISIT, homeCityData)
        var intent = Intent()
        var bundle = Bundle()
        bundle.putSerializable(Configs.SCREEN_RESULT_Extra, homeCityData)
        intent.putExtras(bundle)
        setResult(Configs.CITY_RESULT_CODE, intent)
        finish()

    }

    override fun onItemClick(view: View, position: Int, childPosition: Int) {

        if (position > 2) {
            when (view?.id) {
                R.id.ly_city_root -> callback(mCityList[position - 3][1].data[childPosition])
            }
        } else if (position == 2) {
            callback(mHostCityList[childPosition])
        } else if (position == 1) {
            if (Hawk.contains(Configs.VISIT)) {
                callback(Hawk.get(Configs.VISIT))
            } else {
                callback(App.getInstance().homeCityData)
            }
        } else if (position == 0) {
            callback(App.getInstance().homeCityData)
        }
    }


    override fun onItemDown(position: Int, itemContent: String?) {
        if (position < mCityList.size) {
            ry_city.scrollToPosition(position + 2)
        }
    }

    override fun onItemMove(position: Int, itemContent: String?) {
        if (position < mCityList.size) {
            ry_city.scrollToPosition(position + 3)
        }
    }

    override fun onItemUp(position: Int, itemContent: String?) {
    }

    override fun refreshUI(data: NetData?) {

        if (data != null && data is CityListBean) {

            mCityList.clear()
            mCityList.addAll(data.result.groupList)
            mHostCityList.clear()
            mHostCityList.addAll(data.result.hotList)

            mCityLinearLayoutManager = LinearLayoutManager(this)
            mCityLinearLayoutManager?.orientation = LinearLayoutManager.VERTICAL

            mCityAdapter = CityAdapter(this, mCityList, data.result.hotList, this)

            ry_city.layoutManager = mCityLinearLayoutManager

            ry_city.adapter = mCityAdapter
        }
    }

    override fun loadMore(data: NetData?) {
    }

    override fun onEditorAction(tv: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            search(et_search.text.toString())
            return true
        }
        return false
    }

    private fun search(toString: String) {
        if (ry_city.visibility == View.VISIBLE) {
            ry_city.visibility = View.GONE
            sb_letter.visibility = View.GONE
            recycle_list.visibility = View.VISIBLE
        }

        if (mSearchAdapter==null){
            mSearchAdapter = SearchCityAdapter(this,mSearchList,this)
            recycle_list.layoutManager =LinearLayoutManager(this)
            recycle_list.adapter =mSearchAdapter
        }
        mSearchList.clear()
        if (mCityList.size>0){
            for (ml in mCityList){
                if ( ml.isNotEmpty()){
                    for (childList in ml){
                        if (childList.data!=null&&childList.data.isNotEmpty()){
                            for (city in childList.data){
                                if (city.name.contains(toString)){
                                    mSearchList.add(city)
                                }
                            }
                        }
                    }
                }

            }
        }
        mSearchAdapter?.notifyDataSetChanged()
    }

    override fun onItemClick(view: View, position: Int) {
        callback(mSearchList[position])
    }

}