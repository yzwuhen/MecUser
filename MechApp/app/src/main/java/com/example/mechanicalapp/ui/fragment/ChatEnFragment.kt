package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.OnItemLongClick
import com.example.mechanicalapp.ui.adapter.ChatAdapter
import com.example.mechanicalapp.ui.adapter.ChatEnAdapter
import com.example.mechanicalapp.ui.adapter.DialogListAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.p.MsgPresenter
import com.example.mechanicalapp.ui.mvp.v.MsgView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import com.netease.nim.uikit.api.NimUIKit
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.msg.MsgServiceObserve
import com.netease.nimlib.sdk.msg.model.RecentContact
import kotlinx.android.synthetic.main.fragment_msg_list.*


    class ChatEnFragment : BaseCusFragment(), OnItemClickListener, OnItemLongClick,
    MsgView<List<RecentContact>> {

    private var mChatAdapter: ChatEnAdapter? = null
    var mList: MutableList<RecentContact> = ArrayList<RecentContact>()

    private var mTipDialog: BottomSheetDialog? = null
    private var mTipView: View? = null
    private var mDialogRecycle: RecyclerView? = null
    private var mDialogList: MutableList<String> = ArrayList<String>()
    private var mDialogAdapter: DialogListAdapter? = null
    private var clickPosition = 0
    override fun getLayoutId(): Int {
        return R.layout.fragment_msg_list
    }

    override fun initView() {
        super.initView()

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        mChatAdapter = ChatEnAdapter(mContext, mList, this, this)
        recycle_list.adapter = mChatAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                //  initData()
                (mPresenter as MsgPresenter<List<RecentContact>>).request()
            }

            override fun onLoadmore() {}
        })

        mPresenter = MsgPresenter(this)
        mPresenter?.request()

        registerObservers(true)
    }

    /**
     * ********************** 收消息，处理状态变化 ************************
     *  好像只需要监听会话列表就行。
     */
    private fun registerObservers(register: Boolean) {
        val service = NIMClient.getService(MsgServiceObserve::class.java)
        service.observeRecentContact({ recentContacts ->
            mList.clear()
            if (recentContacts != null) {
                for (recent in recentContacts){
                    if (recent.contactId.split("-").size==3){
                        mList.add(recent)
                    }
                }
            }
            mChatAdapter?.notifyDataSetChanged()
        }, register)
    }
    fun closeRefreshView() {
        spring_list.isEnable = true
        spring_list.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {
        when (view.id) {
            R.id.item_chat_root -> jumChat(position)
            R.id.tv_test -> dialogClick(position)
        }
    }

    private fun dialogClick(position: Int) {
        mTipDialog?.dismiss()
        when (position) {
            0 -> readText()
            1 -> topMsg()
            2 -> delMsg()
            3 -> addBlackList()
        }
    }

    private fun addBlackList() {
        (mPresenter as MsgPresenter<List<RecentContact>>)?.addBlackList(mList[clickPosition].contactId)
    }

    //删除聊天
    private fun delMsg() {
        (mPresenter as MsgPresenter<List<RecentContact>>)?.delChat(mList[clickPosition])
        mList.removeAt(clickPosition)
        mChatAdapter?.notifyDataSetChanged()
    }

    //置顶
    private fun topMsg() {
        //通过tag置顶
        //mList[clickPosition].tag=0

    }

    //标记已读
    private fun readText() {
        (mPresenter as MsgPresenter<List<RecentContact>>)?.clearUnreadCount(mList[clickPosition])
    }

    private fun jumChat(position: Int) {
        NimUIKit.startP2PSession(activity, mList[position]?.contactId)
    }

    override fun onItemLongClick(view: View, position: Int) {
        showShare(position)

    }

    private fun showShare(position: Int) {
        clickPosition = position
        if (mTipDialog == null) {
            mTipDialog = BottomSheetDialog(mContext)
            mTipView = View.inflate(mContext, R.layout.dialog_list, null)
            mTipDialog?.setContentView(mTipView!!)

            mDialogRecycle = mTipView?.findViewById(R.id.dialog_recycle_list)

            mDialogList.add("标记已读")
            mDialogList.add("置顶聊天")
            mDialogList.add("删除聊天记录")
            mDialogList.add("黑名单")
            mDialogRecycle?.layoutManager = LinearLayoutManager(mContext)
            mDialogAdapter = DialogListAdapter(mContext, mDialogList, this)
            mDialogRecycle?.adapter = mDialogAdapter

        }
        mTipDialog?.show()

    }

    override fun onDestroy() {
        super.onDestroy()
        //反注册x
        registerObservers(false)
    }

    override fun refreshUI(list: List<RecentContact>?) {
        mList.clear()
        if (list != null&& list.isNotEmpty()) {
            for (recent in list){
                if (recent.contactId.split("-").size==3){
                    mList.add(recent)
                }
            }
        }
        mChatAdapter?.notifyDataSetChanged()
        closeRefreshView()
    }

    override fun success() {
        spring_list?.callFresh()
    }
}