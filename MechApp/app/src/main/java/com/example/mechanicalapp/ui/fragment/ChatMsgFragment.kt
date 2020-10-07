package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.ChatAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import kotlinx.android.synthetic.main.fragment_msg_list.*

class ChatMsgFragment:BaseFragment<NetData>(),OnItemClickListener {

    private var mChatAdapter:ChatAdapter?=null
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
        mChatAdapter = ChatAdapter(mContext, mList, this)
        recycle_list.adapter = mChatAdapter
    }

    override fun onItemClick(view: View, position: Int) {


    }
}