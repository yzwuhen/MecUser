package com.example.mechanicalapp.ui.fragment.look

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.RecruitDetailsActivity
import com.example.mechanicalapp.ui.adapter.LookRecruitAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.MyLookPresenter
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*


class LookRecruit : BaseCusFragment(), OnItemClickListener, MyReleaseView<RecruitData> {

    private var mAdapter: LookRecruitAdapter? = null
    var mList: MutableList<RecruitData> = ArrayList<RecruitData>()

    override fun initView() {
        super.initView()
        mAdapter = LookRecruitAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as MyLookPresenter).resetPage()
                (mPresenter as MyLookPresenter).getLookRecruitList(1)
            }

            override fun onLoadmore() {
                (mPresenter as MyLookPresenter).getLookRecruitList(1)
            }
        })


        mPresenter = MyLookPresenter( this)
        (mPresenter as MyLookPresenter).getLookRecruitList(1)
    }

    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }
    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }
    override fun onItemClick(view: View, position: Int) {

        jumpActivity(null, RecruitDetailsActivity::class.java)
    }

    override fun hiedLoading() {
        //  hideLoadingView()
        closeRefreshView()
    }

    override fun err()  {
    }
    override fun showLoading() {
        //  showLoadView()
    }

    override fun refreshUI(list: List<RecruitData>?) {
        mList.clear()
        if (list != null) {
            mList.addAll(list)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<RecruitData>?) {
        if (list != null) {
            mList.addAll(list)
            mAdapter?.notifyDataSetChanged()
        }
    }

    override fun showData(netData: NetData?) {
    }
}