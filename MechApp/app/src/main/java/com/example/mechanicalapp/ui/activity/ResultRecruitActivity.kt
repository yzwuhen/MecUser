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
import com.example.mechanicalapp.ui.adapter.MorePartsAdapter
import com.example.mechanicalapp.ui.adapter.MoreRecruitAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.ResultPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_search_result.*
import kotlinx.android.synthetic.main.layout_search_et.*

class ResultRecruitActivity  : BaseCusActivity(), OnItemClickListener, View.OnClickListener,
    TextView.OnEditorActionListener, NetDataView<NetData> {
    var mAdapter: MoreRecruitAdapter? = null
    var mList: MutableList<RecruitData> = ArrayList<RecruitData>()
    private var mPresenter: ResultPresenter? = null
    private var title = ""
    override fun getLayoutId(): Int {
        return R.layout.activity_search_result
    }

    override fun initView() {
        super.initView()

        title = intent.getStringExtra(Configs.SEARCH_RESULT_TITLE).toString()
        et_search.setText(title)

        mAdapter = MoreRecruitAdapter(this, mList,  this)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                mPresenter?.resetPage()
                mPresenter?.getRecruitList("1")
            }

            override fun onLoadmore() {
                mPresenter?.getRecruitList("1")
            }
        })

        tv_search.setOnClickListener(this)
        iv_back.setOnClickListener(this)
        et_search.setOnEditorActionListener(this)
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun initPresenter() {
        mPresenter = ResultPresenter(this)
        mPresenter?.setTitle(title)
        mPresenter?.getRecruitList("1")
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.tv_screen -> search(et_search.text.toString())
        }

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
    }

    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
        bundle.putString(Configs.MEC_ID, mList[position].id)
        jumpActivity(bundle,PartsLeaseDetailsActivity::class.java)

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

    override fun refreshUI(data: NetData?) {
        if (data != null && data is RecruitBean) {
            if (data.result != null && data.result.records != null) {
                mList.clear()
                mList.addAll(data.result.records)
                mAdapter?.notifyDataSetChanged()
                tv_result_num.text="共为您找到${data.result.total}条搜索结果"
                if (mList.size == 0) {
                    showEmptyView()
                } else {
                    hideEmptyView()
                }
            }
        }

    }

    override fun loadMore(data: NetData?) {
        if (data != null && data is RecruitBean) {
            if (data.result != null && data.result.records != null) {
                mList.addAll(data.result.records)
                mAdapter?.notifyDataSetChanged()
            }
        }

    }
}