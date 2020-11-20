package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.*
import com.example.mechanicalapp.ui.adapter.BossBuyAdapter
import com.example.mechanicalapp.ui.adapter.BossSellAdapter
import com.example.mechanicalapp.ui.data.MecSellData
import kotlinx.android.synthetic.main.layout_boss_denmand.view.*

class BossDemandView(var mContext: Context) : LinearLayout(mContext), OnItemClickListener,
    View.OnClickListener {

    private var mAdapter: BossSellAdapter? = null
    private var mBuyAdapter: BossBuyAdapter? = null
    var mList: MutableList<MecSellData> = ArrayList<MecSellData>()
    var mSellList: MutableList<MecSellData> = ArrayList<MecSellData>()
    var type: Int = 0

    init {
        orientation = VERTICAL;
        val view = inflate(mContext, R.layout.layout_boss_denmand, null)
        addView(view)


        mAdapter = BossSellAdapter(mContext, mSellList, 1, this)

        mBuyAdapter = BossBuyAdapter(mContext, mList, this)

        recycler_demand.layoutManager = LinearLayoutManager(mContext)
        recycler_demand.adapter = mAdapter

        tv_lease.setOnClickListener(this)
        tv_rent.setOnClickListener(this)
        tv_rent_more.setOnClickListener(this)

    }


    override fun onClick(v: View?) {

        if (v?.id == R.id.tv_lease) {
            if (type != 0) {
                type = 0
                recycler_demand.adapter = mAdapter
                tv_lease.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.tv_under_ine)
                tv_lease.paint.isFakeBoldText = true
                tv_rent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                tv_rent.paint.isFakeBoldText = false
                tv_rent.setTextColor(Color.parseColor("#B5B5B5"))
                tv_lease.setTextColor(Color.parseColor("#222222"))

                tv_rent.textSize = 13f
                tv_lease.textSize = 16f
            }
        } else if (v?.id == R.id.tv_rent) {
            if (type != 1) {
                type = 1
                recycler_demand.adapter = mBuyAdapter
                tv_rent.paint.isFakeBoldText = true
                tv_lease.paint.isFakeBoldText = false
                tv_rent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.tv_under_ine)
                tv_lease.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)


                tv_lease.setTextColor(Color.parseColor("#B5B5B5"))
                tv_rent.setTextColor(Color.parseColor("#222222"))

                tv_lease.textSize = 13f
                tv_rent.textSize = 16f
            }
        } else if (v?.id == R.id.tv_rent_more) {
            jumAct(2)
        }
    }

    private fun jumAct(type: Int) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putInt(Configs.MORE_VIEW_TYPE, type)
        intent.setClass(mContext, MoreDataActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)
    }

    private fun jumDetails(position: Int) {
        val intent = Intent()
        val bundle = Bundle()
        bundle.putInt(Configs.MORE_VIEW_TYPE, type)

        if (type == 0) {
            bundle.putInt(Configs.MEC_Lease_DETAILS_TYPE, 1)
            bundle.putString(Configs.MEC_ID, mSellList[position].id)
            intent.setClass(mContext, MecSellDetails::class.java)
        } else {
            bundle.putInt(Configs.MEC_ASK_DETAILS_TYPE, 1)
            bundle.putString(Configs.MEC_ID, mList[position].id)
            intent.setClass(mContext, MecBuyDetails::class.java)
        }
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)
    }

    override fun onItemClick(view: View, position: Int) {
        jumDetails(position)
    }

    fun setSell(list: List<MecSellData>) {
        mSellList.clear()
        mSellList.addAll(list)
        mAdapter?.notifyDataSetChanged()

    }

    fun setBuy(list: List<MecSellData>) {
        mList.clear()
        mList.addAll(list)
        mBuyAdapter?.notifyDataSetChanged()

    }


}