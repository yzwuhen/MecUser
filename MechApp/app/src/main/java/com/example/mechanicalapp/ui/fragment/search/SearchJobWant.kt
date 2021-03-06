package com.example.mechanicalapp.ui.fragment.search

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.AskDetailsActivity
import com.example.mechanicalapp.ui.activity.JobWantDetails
import com.example.mechanicalapp.ui.adapter.JobWantAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitBean
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.ui.data.java.EventSearch
import com.example.mechanicalapp.ui.mvp.impl.ResultPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_search_all_result.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SearchJobWant (var title:String?): BaseCusFragment() , OnItemClickListener ,
    NetDataView<NetData> {


    var mList: MutableList<RecruitData> = ArrayList<RecruitData>()
    private var mAdapter: JobWantAdapter? = null
    init {
        EventBus.getDefault().register(this)
    }
    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onFresh(msg: EventSearch) {

        if (mPresenter!=null){
            title =msg.title
            (mPresenter as ResultPresenter).setTitle(title)
            (mPresenter as ResultPresenter).getRecruitList("2")
        }
    }
    override fun getLayoutId(): Int {
        return R.layout.fragment_search_all_result
    }

    override fun initView() {
        super.initView()


        mAdapter = JobWantAdapter(mContext, mList,  this)

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        recycle_list.adapter = mAdapter


        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        // spring_list.footer=RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as ResultPresenter).resetPage()
                (mPresenter as ResultPresenter).getRecruitList("2")
            }

            override fun onLoadmore() {
                (mPresenter as ResultPresenter).getRecruitList("2")
            }
        })
        mPresenter = ResultPresenter(this)
        (mPresenter as ResultPresenter).setTitle(title)
        (mPresenter as ResultPresenter).getRecruitList("2")
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {
        var bundle = Bundle()
        bundle.putString("id", mList[position].id)
        jumpActivity(bundle,JobWantDetails::class.java)
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

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun err() {
    }
}