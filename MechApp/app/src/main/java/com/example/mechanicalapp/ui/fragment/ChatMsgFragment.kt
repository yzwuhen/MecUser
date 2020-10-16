package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.`interface`.OnItemLongClick
import com.example.mechanicalapp.ui.adapter.ChatAdapter
import com.example.mechanicalapp.ui.adapter.DialogListAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_msg_list.*

class ChatMsgFragment:BaseFragment<NetData>(),OnItemClickListener,OnItemLongClick {

    private var mChatAdapter:ChatAdapter?=null
    var mList: MutableList<String> = ArrayList<String>()

    private var mTipDialog: BottomSheetDialog?=null
    private var mTipView: View?=null
    private var mDialogRecycle : RecyclerView?=null
    private var mDialogList: MutableList<String> = ArrayList<String>()
    private var mDialogAdapter : DialogListAdapter?=null

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
        mChatAdapter = ChatAdapter(mContext, mList, this,this)
        recycle_list.adapter = mChatAdapter
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun onItemLongClick(view: View, position: Int) {
        showShare()

    }
    private fun showShare() {

        if (mTipDialog ==null){
            mTipDialog = BottomSheetDialog(mContext)
            mTipView = View.inflate(mContext, R.layout.dialog_list,null)
            mTipDialog?.setContentView(mTipView!!)

            mDialogRecycle = mTipView?.findViewById(R.id.dialog_recycle_list)

            mDialogList.add("标记已读")
            mDialogList.add("置顶聊天")
            mDialogList.add("删除聊天记录")
//            mDialogList.add("黑名单")

            mDialogRecycle?.layoutManager =LinearLayoutManager(mContext)
            mDialogAdapter = DialogListAdapter(mContext,mDialogList,this)
            mDialogRecycle?.adapter =mDialogAdapter

        }
        mTipDialog?.show()

    }
}