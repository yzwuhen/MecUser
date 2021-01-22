package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.FactoryCommentAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.FactoryCommentData
import com.example.mechanicalapp.ui.data.FactoryCommentListBean
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_comment.*
import kotlinx.android.synthetic.main.layout_title.*

class FactoryCommentActivity :BaseCusActivity() ,NetDataView<FactoryCommentListBean>,OnItemClickListener{
    private var mPresenter :MecAppPresenter?=null
    private var mList:MutableList<FactoryCommentData> =ArrayList<FactoryCommentData>()
    private var mAdapter : FactoryCommentAdapter?=null
    private var page=1
    private var id:String?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_factory_commentlist
    }

    override fun initView() {
        super.initView()
        mAdapter = FactoryCommentAdapter(this,mList,this)

        tv_title.text ="评论列表"
        ly_left.setOnClickListener(View.OnClickListener { finish() })

        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                page =1
                getData()
            }

            override fun onLoadmore() {
                ++page
                getData()
            }
        })


    }

    override fun initPresenter() {
        id = intent.getStringExtra("id")
        mPresenter = MecAppPresenter(this)
        getData()
    }

    private fun  getData(){
        mPresenter?.getFactoryCommentList(page,id)
    }
    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }


    override fun refreshUI(data: FactoryCommentListBean?) {

        if (data!=null){
            mList.clear()
            mList.addAll(data?.result.records)
            mAdapter?.notifyDataSetChanged()
        }
    }

    override fun loadMore(data: FactoryCommentListBean?) {
        if (data!=null){
            mList.addAll(data?.result.records)
            mAdapter?.notifyDataSetChanged()
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

    override fun onItemClick(view: View, position: Int) {


    }
}