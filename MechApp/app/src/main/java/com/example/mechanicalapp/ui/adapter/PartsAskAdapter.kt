package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import kotlinx.android.synthetic.main.item_user_demand.view.*

/**
 * 配件求租Adapter
 */
class PartsAskAdapter(
    var mContext: Context,
    var mList: MutableList<String>,
    var mOnItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var isShow: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PartsVh(
            View.inflate(parent.context, R.layout.item_parts_ask, null),
            mOnItemClickListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(mContext)
            .load("https://t8.baidu.com/it/u=2247852322,986532796&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600708280&t=2c8b3ed72148e0c4fb274061565e6723")
            .into(holder.itemView.iv_pic);
        if (isShow) {
            holder.itemView.ly_check.visibility = View.VISIBLE
        } else {
            holder.itemView.ly_check.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }

    fun showCheck(showCheck: Boolean) {
        isShow = showCheck

    }

    class PartsVh(itemView: View, mOnItemClickListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener(View.OnClickListener {
                mOnItemClickListener.onItemClick(
                    itemView,
                    adapterPosition
                )
            })
        }
    }
}