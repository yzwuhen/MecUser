package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.OnItemLongClick
import com.example.mechanicalapp.ui.adapter.ChatAdapter
import com.example.mechanicalapp.ui.adapter.DialogListAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.mvp.p.MsgPresenter
import com.example.mechanicalapp.ui.mvp.v.MsgView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import com.netease.nim.uikit.api.NimUIKit
import com.netease.nim.uikit.api.model.contact.ContactChangedObserver
import com.netease.nim.uikit.business.recent.TeamMemberAitHelper
import com.netease.nimlib.sdk.NIMClient
import com.netease.nimlib.sdk.Observer
import com.netease.nimlib.sdk.msg.MsgServiceObserve
import com.netease.nimlib.sdk.msg.model.IMMessage
import com.netease.nimlib.sdk.msg.model.RecentContact
import kotlinx.android.synthetic.main.fragment_msg_list.*
import java.util.*
import kotlin.collections.ArrayList


class ChatMsgFragment:BaseCusFragment(),OnItemClickListener,OnItemLongClick,MsgView<List<RecentContact>> {

    private var mChatAdapter:ChatAdapter?=null
    var mList: MutableList<RecentContact> = ArrayList<RecentContact>()

    private var mTipDialog: BottomSheetDialog?=null
    private var mTipView: View?=null
    private var mDialogRecycle : RecyclerView?=null
    private var mDialogList: MutableList<String> = ArrayList<String>()
    private var mDialogAdapter : DialogListAdapter?=null
    private var clickPosition=0
    override fun getLayoutId(): Int {
        return R.layout.fragment_msg_list
    }

    override fun initView() {
        super.initView()

        recycle_list.layoutManager = LinearLayoutManager(mContext)
        mChatAdapter = ChatAdapter(mContext, mList, this, this)
        recycle_list.adapter = mChatAdapter

        spring_list.type=SpringView.Type.FOLLOW
        spring_list.header=RefreshHeaderUtils.getHeaderView(mContext)

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

    }

    // 暂存消息，当RecentContact 监听回来时使用，结束后清掉
    private val cacheMessages=TreeMap<String, Set<IMMessage>>()
    /**
     * ********************** 收消息，处理状态变化 ************************
     */
    private fun registerObservers(register: Boolean) {
        val service = NIMClient.getService(MsgServiceObserve::class.java)
        service.observeReceiveMessage(object : Observer<List<IMMessage>> {
            override fun onEvent(imMessages: List<IMMessage>?) {
                if (imMessages != null) {
                    for (imMessage in imMessages) {
                        if (!TeamMemberAitHelper.isAitMessage(imMessage)) {
                            continue
                        }
                        var cacheMessageSet=
                            cacheMessages[imMessage.sessionId]
                        if (cacheMessageSet == null) {
                            cacheMessageSet = HashSet()
                            cacheMessages[imMessage.sessionId] = cacheMessageSet
                        }
                        cacheMessageSet.add(imMessage)
                    }
                }
            }
        }, register)
        service.observeRecentContact({ }, register)
        service.observeMsgStatus({ }, register)
        service.observeRecentContactDeleted({ }, register)
        NimUIKit.getContactChangedObservable().registerObserver(object : ContactChangedObserver {
            override fun onAddedOrUpdatedFriends(accounts: MutableList<String>?) {
            }

            override fun onDeletedFriends(accounts: MutableList<String>?) {
            }

            override fun onAddUserToBlackList(accounts: MutableList<String>?) {
            }

            override fun onRemoveUserFromBlackList(accounts: MutableList<String>?) {

            }
        }, register)
    }



    fun closeRefreshView() {
        spring_list.isEnable =true
        spring_list.onFinishFreshAndLoad()
    }

    override fun onItemClick(view: View, position: Int) {

        when(view.id){
            R.id.item_chat_root -> jumChat(position)
            R.id.tv_test -> dialogClick(position)
        }
    }

    private fun dialogClick(position: Int) {
        mTipDialog?.dismiss()
        when(position){
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
        clickPosition =position
        if (mTipDialog ==null){
            mTipDialog = BottomSheetDialog(mContext)
            mTipView = View.inflate(mContext, R.layout.dialog_list, null)
            mTipDialog?.setContentView(mTipView!!)

            mDialogRecycle = mTipView?.findViewById(R.id.dialog_recycle_list)

            mDialogList.add("标记已读")
            mDialogList.add("置顶聊天")
            mDialogList.add("删除聊天记录")
            mDialogList.add("黑名单")
            mDialogRecycle?.layoutManager =LinearLayoutManager(mContext)
            mDialogAdapter = DialogListAdapter(mContext, mDialogList, this)
            mDialogRecycle?.adapter =mDialogAdapter

        }
        mTipDialog?.show()

    }


    override fun refreshUI(list: List<RecentContact>?) {
        mList.clear()
        if (list!=null){
            mList.addAll(list)
        }
        mChatAdapter?.notifyDataSetChanged()
        closeRefreshView()
    }

    override fun success() {
        spring_list?.callFresh()
    }
}