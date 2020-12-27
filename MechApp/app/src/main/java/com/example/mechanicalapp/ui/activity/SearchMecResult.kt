package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MyMecAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecData
import com.example.mechanicalapp.ui.data.MyMecListBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.ResultPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_search_goods_result.*
import kotlinx.android.synthetic.main.layout_search_et.*

/**
 * 我的设备
 */
class SearchMecResult: BaseCusActivity(), OnItemClickListener ,View.OnClickListener,  TextView.OnEditorActionListener,
    NetDataView<NetData> {

    private var mMyMecAdapter: MyMecAdapter? = null
    private var mList: MutableList<MecData> = ArrayList<MecData>()

    private var mPresenter: ResultPresenter?=null
    private var mTitle:String?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_search_goods_result
    }

    override fun initView() {
        super.initView()
        mTitle = intent.getStringExtra(Configs.SEARCH_RESULT_TITLE).toString()

        recycler_list.layoutManager = GridLayoutManager(this, 3)
        mMyMecAdapter = MyMecAdapter(this, mList, this)
        recycler_list.adapter = mMyMecAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                mPresenter?.resetPage()
                mPresenter?.getMecList()
            }

            override fun onLoadmore() {
                mPresenter?.getMecList()
            }
        })
        tv_search.setOnClickListener(this)
        iv_back.setOnClickListener(this)
        et_search.setOnEditorActionListener(this)
    }
    override fun onEditorAction(tv: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            search(et_search.text.toString())
            return true
        }
        return false
    }

    override fun initPresenter() {
        mPresenter = ResultPresenter(this)
        mPresenter?.setTitle(mTitle)
        mPresenter?.getMecList()
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


    override fun err()  {

    }

    override fun onItemClick(view: View, position: Int) {
        var  bundle = Bundle()
        bundle.putString("id",mList[position].id)
        jumpActivity(bundle,MyMecDetailsActivity::class.java)
    }

    override fun refreshUI(data: NetData?) {
        if (data != null && data is MyMecListBean) {
            if (data.result != null && data.result.records != null) {
                mList.clear()
                mList.addAll(data.result.records)
                mMyMecAdapter?.notifyDataSetChanged()
                tv_list_count.text="共为您找到${data.result.total}条搜索结果"
                if (mList.size == 0) {
                    showEmptyView()
                } else {
                    hideEmptyView()
                }
            }
        }
    }

    override fun loadMore(data: NetData?) {
        if (data != null && data is MyMecListBean) {
            if (data.result != null && data.result.records != null) {
                mList.addAll(data.result.records)
                mMyMecAdapter?.notifyDataSetChanged()
            }
        }

    }
    private fun search(toString: String) {
        mPresenter?.setTitle(toString)
        mPresenter?.getMecList()
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.tv_search -> search(et_search.text.toString())
        }
    }
}