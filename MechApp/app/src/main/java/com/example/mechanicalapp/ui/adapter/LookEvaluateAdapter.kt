package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.data.EvaluateData
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_order_look_evaluate.view.*

class LookEvaluateAdapter(
    var mContext: Context,
    var mList: List<EvaluateData>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LookEvaluateVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_order_look_evaluate, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(
            mContext, holder.itemView.iv_pic, mList[position].productSkuImg,
            R.mipmap.ic_launcher
        )
        holder.itemView.tv_goods_title.text = mList[position].prodName
        holder.itemView.tv_attr.text = mList[position].mecProductSkuName
        holder.itemView.tv_num.text = "x${mList[position].partNum}"
        holder.itemView.tv_all_nun.text = "共${mList[position].partNum}件商品"
        holder.itemView.tv_money.text = "￥${mList[position].totalMoney}"
        holder.itemView.tv_score.text = "${mList[position].star}分"
        holder.itemView.tv_info.text = mList[position].content
        holder.itemView.ratingBar.rating = mList[position].star.toFloat()
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class LookEvaluateVh(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
    }
}