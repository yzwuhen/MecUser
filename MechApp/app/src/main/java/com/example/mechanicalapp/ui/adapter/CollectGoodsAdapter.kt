package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_collect_goods.view.*

class CollectGoodsAdapter  (var mContext: Context, var mList:MutableList<String>, var mOnItemClickListener: OnItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var isShow:Boolean=false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CollectGoodsVh(  LayoutInflater.from(mContext).inflate(R.layout.item_collect_goods, parent, false),mOnItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isShow){
            holder.itemView.ly_check.visibility =View.VISIBLE
        }else{
            holder.itemView.ly_check.visibility =View.GONE
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class CollectGoodsVh(itemView: View, mOnItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        init {

            itemView.setOnClickListener(View.OnClickListener { mOnItemClickListener.onItemClick(itemView.item_root,adapterPosition) })
        }
    }
}