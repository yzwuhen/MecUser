package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.HistoryAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.widget.FlowLayout
import com.example.mechanicalapp.ui.widget.TagFlowLayout
import com.example.mechanicalapp.utils.StringUtils
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_history_search.*
import kotlinx.android.synthetic.main.layout_search_title.*


class HistorySearchActivity : BaseActivity<NetData>(), TagFlowLayout.OnTagClickListener,TextView.OnEditorActionListener,
    View.OnClickListener {

    private var mHisToryFl: TagFlowLayout? = null
    private var tvDeleteHistory: TextView? = null
    private var mHistoryAdapter: HistoryAdapter? = null

    private var mHistoryList: MutableList<String> = ArrayList<String>()

    //0 机械出租 1 机械求租 2 机械出售 3 机械求购  4配件出租 5 配件求租 6维修厂 7搜索我的设备 8 搜索维修订单 9 工程师 10home搜索  11 搜索商品
    //12 求职 13 招聘
    private var type: Int = 0

    override fun getLayoutId(): Int {

        return R.layout.activity_history_search
    }

    override fun initPresenter() {


    }

    override fun initView() {
        super.initView()

        type = intent.getIntExtra(Configs.HISTORY_TYPE, 0)
        mHistoryList.addAll(Hawk.get(StringUtils.getHawkKey(type),ArrayList<String>()))
        if (mHistoryList.size>0){
            showHisFl()
        }
        et_search.setOnEditorActionListener(this)
        iv_back.setOnClickListener(this)
    }
    override fun onEditorAction(tv: TextView?, actionId: Int, event: KeyEvent?): Boolean {

        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            jumpAct(et_search.text.toString())
            mHistoryList.add(et_search.text.toString())
            Hawk.put(StringUtils.getHawkKey(type),mHistoryList)
            return true
        }
        return false
    }
    //0 机械出租 1 机械求租 2 机械出售 3 机械求购  4配件出租 5 配件求租 6维修厂 7搜索我的设备 8 搜索维修订单 9 工程师 10home搜索  11 搜索商品
    //12 求职 13 招聘
    private fun jumpAct(searchText: String) {

        var bundle: Bundle = Bundle()
        bundle.putInt(Configs.SEARCH_RESULT_TYPE, type)

        bundle.putString(Configs.SEARCH_RESULT_TITLE,searchText)
        if (type==0){
            jumpActivity(bundle, ResultMecLeaseActivity::class.java)
        }else if (type==1){
            jumpActivity(bundle, ResultMecAskActivity::class.java)
        }
        else if (type==2){
            jumpActivity(bundle, ResultMecSellActivity::class.java)
        }
        else if (type==3){
            jumpActivity(bundle, ResultMecBuyActivity::class.java)
        }

        else if (type==4){
            jumpActivity(bundle, ResultPartsLeaseActivity::class.java)
        }
        else if (type==5){
            jumpActivity(bundle, ResultPartsAskActivity::class.java)
        }
        else if (type==6){
            jumpActivity(bundle, ResultFactoryActivity::class.java)
        }
        else if (type==7){
            jumpActivity(bundle, SearchMecResult::class.java)
        }
        else if (type==10){
            jumpActivity(bundle, SearchAllActivity::class.java)
        }
        //11 商品可能用不到jumpActivity(bundle, SearchGoodsResult::class.java)
        else if (type==12){
            jumpActivity(bundle, ResultRecruitActivity::class.java)
        }
        else if (type==13){
            jumpActivity(bundle, ResultJobWantActivity::class.java)
        }

        finish()
    }

    private fun showHisFl() {
        if (mHisToryFl == null) {
            stub_history.inflate()
            mHisToryFl = findViewById<View>(R.id.tag_history_fl) as TagFlowLayout
            tvDeleteHistory = getViewTo(R.id.tv_history_delete)
            mHistoryAdapter = HistoryAdapter(mHistoryList)
            mHisToryFl?.setAdapter(mHistoryAdapter)
            tvDeleteHistory?.setOnClickListener(this)
            mHisToryFl?.setOnTagClickListener(this)
        }
    }

    override fun onTagClick(view: View?, position: Int, parent: FlowLayout?): Boolean {

        jumpAct(mHistoryList[position])

        return false
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.iv_back ->finish()
            R.id.tv_history_delete->{
                Hawk.delete(Hawk.get(StringUtils.getHawkKey(type)))
                mHistoryList.clear()
                mHistoryAdapter?.notifyDataChanged()
            }
        }

    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }


}