package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.RecruitDetailsActivity
import com.example.mechanicalapp.ui.activity.WorkType
import com.example.mechanicalapp.ui.adapter.*
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.RecruitData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.RecruitPresenter
import com.example.mechanicalapp.ui.mvp.v.WorkAboutView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_more_data.*

class RecruitFragment(var type:Int):BaseCusFragment(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener,WorkAboutView {
    var mAdapter: MoreRecruitAdapter? = null
    var mList: MutableList<RecruitData> = ArrayList<RecruitData>()

    var popRecy: RecyclerView? = null
    var mScreenAdapter: ScreenAdapter? = null

    private var mStringList: MutableList<String> = ArrayList<String>()

    override fun initView() {
        super.initView()

        mAdapter = MoreRecruitAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter




        mStringList?.add("智能排序")
        mStringList?.add("距离由近到远")
        mStringList?.add("更新时间")
        mStringList?.add("工作时长最短")


        ly_screen1.setOnClickListener(this)
        ly_screen2.setOnClickListener(this)
        ly_screen3.setOnClickListener(this)
        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(mContext))

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.setEnable(false)
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {}
        })

        mPresenter = RecruitPresenter(mContext,this)
        (mPresenter as RecruitPresenter)?.getRecruitList(1)
    }

    fun closeRefreshView() {
        spring_list.setEnable(true)
        spring_list.onFinishFreshAndLoad()
    }

    override fun refreshRecruitUI(list: List<RecruitData>) {
        mList.clear()
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadRecruitMore(list: List<RecruitData>) {
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun err() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_recruit
    }



    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it, this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.ly_screen1 -> showInput()
            R.id.ly_screen2 -> jumpActivity(null,WorkType::class.java)
            R.id.ly_screen3 -> showInput()
        }
    }


    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        jumpActivity(null,RecruitDetailsActivity::class.java)
    }
}