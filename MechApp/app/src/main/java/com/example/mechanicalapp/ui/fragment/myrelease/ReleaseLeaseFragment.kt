package com.example.mechanicalapp.ui.fragment.myrelease

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.LeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.ReleaseLeaseAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.item_parts_ask.*
import kotlinx.android.synthetic.main.layout_spring_list.*


class ReleaseLeaseFragment(var type:Int)   : BaseFragment<NetData>(), OnItemClickListener,PopUtils.onViewListener,View.OnClickListener {


    private var mAdapter: ReleaseLeaseAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null


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
        mAdapter = ReleaseLeaseAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter

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

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun showData(t: NetData?) {
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.item_root->{
                val bundle = Bundle()
                bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, type)
                jumpActivity(bundle, LeaseDetailsActivity::class.java)
            }
            R.id.tv_del-> showPop()
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

            R.id.tv_pop_sure -> activity?.let { PopUtils.dismissPop(it) }
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }

        }
    }
}