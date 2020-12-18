package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.EngineerAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.EngListBean
import com.example.mechanicalapp.ui.data.EngineerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.ResultPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_search_engineer.*
import kotlinx.android.synthetic.main.layout_search_et.*

class ResultEngineerActivity  : BaseCusActivity(), OnItemClickListener, TextView.OnEditorActionListener,
    NetDataView<NetData> {

    private var mAdapter: EngineerAdapter? = null
    var mList: MutableList<EngineerData> = ArrayList<EngineerData>()
    private var mPresenter: ResultPresenter? = null
    private var title = ""
    override fun getLayoutId(): Int {
        return R.layout.activity_search_engineer
    }

    override fun initView() {
        super.initView()

        title = intent.getStringExtra(Configs.SEARCH_RESULT_TITLE).toString()
        et_search.setText(title)

        mAdapter = EngineerAdapter(this, mList,  this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mAdapter

        iv_back.setOnClickListener(View.OnClickListener { finish() })


        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                mPresenter?.resetPage()
                mPresenter?.getEngList()
            }

            override fun onLoadmore() {
                mPresenter?.getEngList()
            }
        })
        et_search.setOnEditorActionListener(this)
    }

    override fun onEditorAction(tv: TextView?, actionId: Int, event: KeyEvent?): Boolean {

        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            search(et_search.text.toString())
            return true
        }
        return false
    }

    private fun search(toString: String) {
        mPresenter?.setTitle(toString)
        mPresenter?.getEngList()
    }
    override fun initPresenter() {

        mPresenter = ResultPresenter(this)
        mPresenter?.setTitle(title)
        mPresenter?.getEngList()
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {
        val bundle = Bundle()
        bundle.putString(Configs.MEC_ID, mList[position].id)
        jumpActivity(bundle, GoodsDetailsActivity::class.java)

    }


    override fun refreshUI(data: NetData?) {
        if (data is EngListBean) {
            mList.clear()
            if (data.result != null && data.result.records != null) {
                mList.addAll(data.result.records)
            }
            mAdapter?.notifyDataSetChanged()
            tv_list_count.text ="共为您找到${data.result.total}条搜索结果"
        }
        if (mList.size == 0) {
            showEmptyView()
        } else {
            hideEmptyView()
        }

    }

    override fun loadMore(data: NetData?) {
        if (data is EngListBean) {
            if (data.result != null && data.result.records != null) {
                mList.addAll(data.result.records)
                mAdapter?.notifyDataSetChanged()
            }
        }
    }
}