package com.example.mechanicalapp.ui.fragment.look

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.PartsAskDetailsActivity
import com.example.mechanicalapp.ui.adapter.LookPartsAskAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.MyLookPresenter
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*


class LookPartsAsk: BaseCusFragment(), OnItemClickListener, MyReleaseView<PartsData> {


    private var mAdapter: LookPartsAskAdapter? = null
    var mList: MutableList<PartsData> = ArrayList<PartsData>()

    override fun initView() {
        super.initView()
        mAdapter = LookPartsAskAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter =mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as MyLookPresenter).resetPage()
                (mPresenter as MyLookPresenter).getLookPartsList(2)
            }

            override fun onLoadmore() {
                (mPresenter as MyLookPresenter).getLookPartsList(2)
            }
        })


        mPresenter = MyLookPresenter( this)
        (mPresenter as MyLookPresenter).getLookPartsList(2)
    }
    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun onItemClick(view: View, position: Int) {
        jumpActivity(null, PartsAskDetailsActivity::class.java)
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

    override fun refreshUI(list: List<PartsData>?) {
        mList.clear()
        if (list != null) {
            mList.addAll(list)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<PartsData>?) {
        if (list != null) {
            mList.addAll(list)
            mAdapter?.notifyDataSetChanged()
        }
    }

    override fun showData(netData: NetData?) {
    }
}