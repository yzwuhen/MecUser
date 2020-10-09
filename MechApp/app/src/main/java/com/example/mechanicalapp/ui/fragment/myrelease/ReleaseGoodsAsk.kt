package com.example.mechanicalapp.ui.fragment.myrelease

import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.ReleaseGoodsAskAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.layout_spring_list.*


class ReleaseGoodsAsk : BaseFragment<NetData>() , OnItemClickListener, PopUtils.onViewListener,View.OnClickListener  {

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null
    private var mAdapter: ReleaseGoodsAskAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    override fun showLoading() {


    }
    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
    }

    override fun initView() {
        super.initView()
        mAdapter = ReleaseGoodsAskAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter =mAdapter


    }

    override fun hiedLoading() {

    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun showData(t: NetData?) {

    }
    private fun showPop() {

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
        showPop()
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

            R.id.tv_pop_sure -> activity?.let { PopUtils.dismissPop(it) }
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }

        }
    }
}