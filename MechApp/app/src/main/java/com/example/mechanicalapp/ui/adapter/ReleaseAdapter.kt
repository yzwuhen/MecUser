package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_menu.view.*

class ReleaseAdapter (var mContext: Context, var mOnItemClickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private val mListIcon: List<Int> = listOf(R.mipmap.jxcz, R.mipmap.cs, R.mipmap.pjcz,  R.mipmap.release_zp,R.mipmap.jxqz,R.mipmap.qg, R.mipmap.pjqz, R.mipmap.qz)
    private val mListText: List<String> = listOf("机械出租", "二手机械出售", "配件出租","招聘","机械求租","二手机械求购","配件求租","求职")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = View.inflate(parent.context, R.layout.item_menu, null)
        return ReleaseVh(view,mOnItemClickListener)
    }

    override fun getItemCount(): Int {
        return 8;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.tv_icon_des.text = mListText[position]
        ImageLoadUtils.loadImageCenterCrop(
            App.getInstance().applicationContext,holder.itemView.iv_icon,mListIcon[position],
            R.mipmap.jxzl)

    }

    class ReleaseVh(
        itemView: View,
        mOnItemClickListener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView,adapterPosition) })
        }
    }
}