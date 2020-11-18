package com.example.mechanicalapp.ui.fragment.myrelease

import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.PartsAskDetailsActivity
import com.example.mechanicalapp.ui.adapter.ReleasePartsAskAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.GoodsData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.ui.mvp.impl.MyReleasePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.MyReleaseView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*


class ReleasePartsAsk : BaseCusFragment(), OnItemClickListener, PopUtils.onViewListener,
    View.OnClickListener, MyReleaseView<PartsData> {

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null
    private var mAdapter: ReleasePartsAskAdapter? = null
    var mList: MutableList<PartsData> = ArrayList<PartsData>()

    private var mPosition: Int = 0


    override fun initView() {
        super.initView()
        mAdapter = ReleasePartsAskAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter
        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as MyReleasePresenterImpl).resetPage()
                (mPresenter as MyReleasePresenterImpl).getPartsList(1)
            }

            override fun onLoadmore() {
                (mPresenter as MyReleasePresenterImpl).getPartsList(1)
            }
        })


        mPresenter = MyReleasePresenterImpl(mContext, this)
        (mPresenter as MyReleasePresenterImpl).getPartsList(1)
    }

    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }


    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    private fun showPop(position: Int) {
        mPosition = position
        if (mPopwindow == null) {
            mPopwindow = activity?.let {
                PopUtils.init(
                    mContext,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }

        popInfo?.text = "删除发布信息？"
        popCancel?.text = "取消"
        popSure?.text = "确定"


        activity?.let { PopUtils.showPopupWindow(fl_bottom, it) }

    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.item_root -> {

                jumpActivity(null, PartsAskDetailsActivity::class.java)
            }
            R.id.tv_del -> showPop(position)
            R.id.tv_refresh -> refreshItem(position)
            R.id.tv_down -> offDown(position)
        }

    }

    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)

        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.tv_pop_sure -> activity?.let {
                PopUtils.dismissPop(it)
                (mPresenter as MyReleasePresenterImpl).delParts(mList[mPosition].id)
            }
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }

        }
    }

    private fun offDown(position: Int) {
        if (mList[position].isOn == 1) {
            (mPresenter as MyReleasePresenterImpl).editParts(mList[position].id, "2")
        } else {
            //重新上架
            (mPresenter as MyReleasePresenterImpl).editParts(mList[position].id, "1")
        }
    }

    private fun refreshItem(position: Int) {
        (mPresenter as MyReleasePresenterImpl).refreshParts(mList[position].id)
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
        if (netData != null && netData.code == 200) {
            spring_list?.callFresh()
        }
        ToastUtils.showText(netData?.message)
    }
}