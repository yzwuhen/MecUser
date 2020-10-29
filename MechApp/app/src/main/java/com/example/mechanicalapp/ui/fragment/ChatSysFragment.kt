package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.SysMsgActivity
import com.example.mechanicalapp.ui.adapter.ChatSysAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.fragment_msg_list.*

class ChatSysFragment : BaseFragment<NetData>(), OnItemClickListener {

    private var mChatAdapter: ChatSysAdapter?=null
    var mList: MutableList<String> = ArrayList<String>()

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_msg_list
    }
    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
    }
    override fun initView() {
        super.initView()

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        mChatAdapter = ChatSysAdapter(mContext, mList, this)
        recycle_list.adapter = mChatAdapter
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

    }

    fun closeRefreshView() {
        spring_list.setEnable(true)
        spring_list.onFinishFreshAndLoad()
    }


    override fun onItemClick(view: View, position: Int) {

        jumpActivity(null,SysMsgActivity::class.java)

    }
}