package com.example.mechanicalapp.ui.fragment.look

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.AskDetailsActivity
import com.example.mechanicalapp.ui.adapter.LookAskAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.MyLookPresenter
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*

class LookSecondAsk : BaseCusFragment(), OnItemClickListener, MyReleaseView<MecLeaseData> {

    private var mAdapter: LookAskAdapter? = null
    var mList: MutableList<MecLeaseData> = ArrayList<MecLeaseData>()


    override fun initView() {
        super.initView()

        mAdapter = LookAskAdapter(mContext, mList, 2,this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as MyLookPresenter).resetPage()
                (mPresenter as MyLookPresenter).getLookSecondLeaseList(2)
            }

            override fun onLoadmore() {
                (mPresenter as MyLookPresenter).getLookSecondLeaseList(2)
            }
        })


        mPresenter = MyLookPresenter(this)
        (mPresenter as MyLookPresenter).getLookSecondLeaseList(2)
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun onItemClick(view: View, position: Int) {
        val bundle = Bundle()
        bundle.putInt(Configs.MEC_ASK_DETAILS_TYPE, 1)
        jumpActivity(bundle, AskDetailsActivity::class.java)
    }

    override fun hiedLoading() {
      //  hideLoadingView()
        closeRefreshView()
    }

    override fun err() {
    }

    override fun showLoading() {
      //  showLoadView()
    }

    override fun refreshUI(list: List<MecLeaseData>?) {
        mList.clear()
        if (list != null) {
            mList.addAll(list)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<MecLeaseData>?) {
        if (list != null) {
            mList.addAll(list)
            mAdapter?.notifyDataSetChanged()
        }
    }

    override fun showData(netData: NetData?) {
    }
}