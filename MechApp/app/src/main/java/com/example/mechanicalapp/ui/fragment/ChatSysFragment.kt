package com.example.mechanicalapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.SysMsgActivity
import com.example.mechanicalapp.ui.adapter.ChatSysAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.SysMsgBean
import com.example.mechanicalapp.ui.data.SysMsgData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_msg_list.*

class ChatSysFragment : BaseCusFragment(), OnItemClickListener ,NetDataView<SysMsgBean>{

    private var mChatAdapter: ChatSysAdapter?=null
    var mList: MutableList<SysMsgData> = ArrayList<SysMsgData>()
    override fun getLayoutId(): Int {
        return R.layout.fragment_msg_list
    }

    override fun initView() {
        super.initView()

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        mChatAdapter = ChatSysAdapter(mContext, mList, this)
        recycle_list.adapter = mChatAdapter
        spring_list.type=SpringView.Type.FOLLOW
        spring_list.header=RefreshHeaderUtils.getHeaderView(mContext)

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable =false
                //  initData()
                (mPresenter as MecAppPresenter).resetPage()
                getData()
            }

            override fun onLoadmore() {
                getData()
            }
        })

        mPresenter = MecAppPresenter(this)
        getData()
    }
    fun getData(){
        (mPresenter as MecAppPresenter).getNotifyMsgList()
    }

    fun closeRefreshView() {
        spring_list.isEnable=true
        spring_list.onFinishFreshAndLoad()
    }


    override fun onItemClick(view: View, position: Int) {

        mList[position].isRead ="1"
        mChatAdapter?.notifyItemChanged(position)
        var bundle =Bundle()
        bundle.putSerializable("data",mList[position])
        jumpActivity(bundle,SysMsgActivity::class.java)

    }

    override fun refreshUI(data: SysMsgBean?) {
        if (data!=null){
            mList.clear()
            mList.addAll(data.result)
            mChatAdapter?.notifyDataSetChanged()
        }

    }

    override fun loadMore(data: SysMsgBean?) {
        if (data!=null){
            mList.addAll(data.result)
            mChatAdapter?.notifyDataSetChanged()
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