package com.example.mechanicalapp.ui.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemChangeListener
import com.example.mechanicalapp.ui.data.PartsOrderGoodsList
import com.example.mechanicalapp.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.item_order_evaluate.view.*

class EvaluateAdapter(
    var mContext: Context,
    var mList: List<PartsOrderGoodsList>, private var onItemChangeListener: OnItemChangeListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EvaluateVh(
            LayoutInflater.from(mContext).inflate(R.layout.item_order_evaluate, parent, false),onItemChangeListener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        ImageLoadUtils.loadImageCenterCrop(mContext,holder.itemView.iv_pic,mList[position].productSkuImg,R.mipmap.ic_launcher)
        holder.itemView.tv_goods_title.text =mList[position].prodName
        holder.itemView.tv_attr.text =mList[position].skuName
        holder.itemView.tv_num.text="x${mList[position].quantity}"
        holder.itemView.tv_all_nun.text ="共${mList[position].quantity}件商品"
        holder.itemView.tv_money.text="￥${mList[position].price}*${mList[position].quantity}"

    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class EvaluateVh(itemView: View, onItemChangeListener: OnItemChangeListener) :
        RecyclerView.ViewHolder(itemView){
        init {
            itemView.ratingBar.setOnRatingBarChangeListener(object :RatingBar.OnRatingBarChangeListener{
                override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
                    onItemChangeListener.onItemClick(itemView.ratingBar,adapterPosition,p1.toString())
                }
            })
            itemView.tv_info.addTextChangedListener(object :TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    onItemChangeListener.onItemClick(itemView.tv_info,adapterPosition,itemView.tv_info.text.toString())
                }
            })
        }
    }
}