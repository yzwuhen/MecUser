package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.GoodsListAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.GoodsData
import com.example.mechanicalapp.ui.data.GoodsListBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.GoodsListPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.MyDecoration
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_search_goods_result.*
import kotlinx.android.synthetic.main.layout_search_et.*

/**
 * 搜索商品结果
 */
class SearchGoodsResult : BaseCusActivity(), OnItemClickListener, TextView.OnEditorActionListener,NetDataView<NetData> {

    private var mAdapter: GoodsListAdapter? = null
    var mList: MutableList<GoodsData> = ArrayList<GoodsData>()
    private var mPresenter: GoodsListPresenter? = null
    private var title=""
    override fun getLayoutId(): Int {
        return R.layout.activity_search_goods_result
    }

    override fun initView() {
        super.initView()

        title = intent.getStringExtra(Configs.SEARCH_RESULT_TITLE).toString()
        et_search.setText(title)

        recycler_list.layoutManager = GridLayoutManager(this, 2)
        mAdapter = GoodsListAdapter(this, mList, this)
        recycler_list.addItemDecoration(MyDecoration(2))
        recycler_list.adapter = mAdapter

        iv_back.setOnClickListener(View.OnClickListener { finish() })


        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as GoodsListPresenter).resetPage()
                (mPresenter as GoodsListPresenter).getGoodsList()
            }

            override fun onLoadmore() {
                (mPresenter as GoodsListPresenter).getGoodsList()
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
        mPresenter?.getGoodsList()
    }
    override fun initPresenter() {

        mPresenter = GoodsListPresenter(this)
        mPresenter?.setTitle(title)
        mPresenter?.getGoodsList()
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
        if (data is GoodsListBean) {
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
        if (data is GoodsListBean) {
            if (data.result != null && data.result.records != null) {
                mList.addAll(data.result.records)
                mAdapter?.notifyDataSetChanged()
            }
        }
    }
}