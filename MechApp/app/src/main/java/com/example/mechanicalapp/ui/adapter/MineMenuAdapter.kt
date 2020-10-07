package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_mine_menu.view.*

class MineMenuAdapter   (var mContext: Context,  var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var mList:MutableList<String> =ArrayList<String>()
    private var mResList:MutableList<Int> =ArrayList<Int>()

    init {
        mList?.add("个人认证")
        mList?.add("公司认证")
        mList?.add("设备管理")
        mList?.add("我查看过")
        mList?.add("维修订单")
        mList?.add("配件订单")
        mList?.add("维修厂入驻")
        mList?.add("设置")
        mList?.add("联系客服")
        mList?.add("意见反馈")
        mList?.add("常见问题")

        mResList?.add(R.mipmap.mine_menu1)
        mResList?.add(R.mipmap.mine_menu2)
        mResList?.add(R.mipmap.mine_menu3)
        mResList?.add(R.mipmap.mine_menu4)
        mResList?.add(R.mipmap.mine_menu5)
        mResList?.add(R.mipmap.mine_menu6)
        mResList?.add(R.mipmap.mine_menu7)
        mResList?.add(R.mipmap.mine_menu8)
        mResList?.add(R.mipmap.mine_menu9)
        mResList?.add(R.mipmap.mine_menu10)
        mResList?.add(R.mipmap.mine_menu11)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MineMenuVh(View.inflate(parent.context, R.layout.item_mine_menu,null),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_menu.text =mList[position]
        holder.itemView.tv_menu.setCompoundDrawablesWithIntrinsicBounds(0,mResList[position],0,0)
       if (position==4){
           holder.itemView.iv_tip.visibility = View.VISIBLE
       }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class MineMenuVh(itemView: View, mOnItemClickListener: OnItemClickListener): RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}