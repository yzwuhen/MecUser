package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_menu.view.*


class MenuAdapter(var mContext:Context ,var mOnItemClickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private val mListIcon: List<Int> = listOf(R.mipmap.jxzl, R.mipmap.pj, R.mipmap.jy, R.mipmap.wxby, R.mipmap.home_zp,R.mipmap.yh)
    private val mListText: List<String> = listOf("机械租赁", "配件租赁", "机械交易","维修保养","求职招聘","云盒")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = View.inflate(parent.context,R.layout.item_menu, null)
        return MenuVh(view,mOnItemClickListener)
    }

    override fun getItemCount(): Int {
        return 6;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_icon_des.text = mListText[position]
        ImageLoadUtils.loadImageCenterCrop(App.getInstance().applicationContext,holder.itemView.iv_icon,mListIcon[position],R.mipmap.jxzl)

    }

    class MenuVh(
        itemView: View,
        mOnItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}