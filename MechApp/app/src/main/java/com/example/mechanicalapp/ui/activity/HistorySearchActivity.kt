package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.adapter.HistoryAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.widget.FlowLayout
import com.example.mechanicalapp.ui.widget.TagFlowLayout
import kotlinx.android.synthetic.main.activity_history_search.*


class HistorySearchActivity :BaseActivity<NetData>(),TagFlowLayout.OnTagClickListener ,View.OnClickListener {

    private var mHisToryFl:TagFlowLayout ?=null
    private var tvDeleteHistory:TextView ?=null
    private var mHistoryAdapter: HistoryAdapter? = null

    private var mHistoryList :MutableList<String> = ArrayList<String>()

    private var type :Int =0

    override fun getLayoutId(): Int {

        return R.layout.activity_history_search
    }

    override fun initPresenter() {


    }

    override fun initView() {
        super.initView()
        mHistoryList.add("1")
        mHistoryList.add("1")
        mHistoryList.add("1")
        mHistoryList.add("1")

        type = intent.getIntExtra(Configs.HISTORY_TYPE,0)

        showHisFl()
    }

    private fun showHisFl() {
        if (mHisToryFl == null) {
            stub_history.inflate()
            mHisToryFl = findViewById<View>(R.id.tag_history_fl) as TagFlowLayout
            tvDeleteHistory = getViewTo(R.id.tv_history_delede)
            mHistoryAdapter = HistoryAdapter(mHistoryList)
            mHisToryFl?.setAdapter(mHistoryAdapter)
            tvDeleteHistory?.setOnClickListener(this)
            mHisToryFl?.setOnTagClickListener(this)
        }
    }

    override fun onTagClick(view: View?, position: Int, parent: FlowLayout?): Boolean {


        var bundle :Bundle = Bundle()
        bundle.putInt(Configs.SEARCH_RESULT_TYPE,type)
        if (type ==3){
            jumpActivity(bundle,SearchGoodsResult::class.java)
        }
        else if (type == 6) {
            jumpActivity(bundle,SearchMecResult::class.java)
        }
        else{
            jumpActivity(bundle,SearchResultActivity::class.java)
        }

//        if (type==0){
//            jumpActivity(null,SearchResultActivity::class.java)
//        }else if (type ==1){
//            jumpActivity(null,SearchResultActivity::class.java)
//        }

        return false
    }

    override fun onClick(p0: View?) {

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
}