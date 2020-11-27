package com.example.mechanicalapp.ui.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.activity.*
import com.example.mechanicalapp.ui.adapter.MenuAdapter

class ItemMenu(var mContext: Context) : LinearLayout(mContext) , OnItemClickListener {
    private var mRecyList: RecyclerView? = null
    init {
        initView()
    }

    open fun initView() {
        val view = View.inflate(mContext, R.layout.view_menu, this)
        mRecyList = view.findViewById(R.id.recycle_list)
        mRecyList?.layoutManager=GridLayoutManager(mContext, 3)
        mRecyList?.adapter= MenuAdapter(mContext!!, this)
    }


    private fun jumAct1() {
        val intent = Intent()
        intent.setClass(mContext, CloudBoxActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        mContext.startActivity(intent)

    }
    private fun jumAct2() {
        val intent = Intent()
        intent.setClass(mContext, MoreRecruitActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        mContext.startActivity(intent)

    }

    private fun jumAct3() {
        val intent = Intent()
        intent.setClass(mContext, MoreFactoryActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        mContext.startActivity(intent)
    }


    private fun jumMoreDataAct(type:Int){
        val intent = Intent()
        val bundle = Bundle()
        bundle.putInt(Configs.MORE_VIEW_TYPE,type)
        intent.setClass(mContext, MoreDataActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mContext.startActivity(intent)
    }
    private fun jumParts(){
        val intent = Intent()
        intent.setClass(mContext, MorePartsActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        mContext.startActivity(intent)
    }

    override fun onItemClick(view: View, position: Int) {
        when(position){
            0->jumMoreDataAct(1)
            1->jumParts()
            2->jumMoreDataAct(2)
            3->jumAct3()
            4->jumAct2()
            5->jumAct1()
        }
    }
}