package com.example.mechanicalapp.ui.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.activity.Brand
import com.example.mechanicalapp.ui.activity.EcModel
import com.example.mechanicalapp.ui.activity.EcType
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.adapter.UserDemandAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.fragment_more_data.*


class MoreDataFragment(var type:Int): BaseFragment<NetData>(), OnItemClickListener,View.OnClickListener,
    PopUtils.onViewListener {
    var mAdapter: UserDemandAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    var popRecy :RecyclerView?=null
    private var mScreenAdapter :ScreenAdapter ?=null

    private var mStringList :MutableList<String> = ArrayList<String>()
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

        mAdapter = UserDemandAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter
        tv_screen1.text ="2$type"



        mStringList?.add("智能排序")
        mStringList?.add("最新上架")
        mStringList?.add("最新上架")
        mStringList?.add("工作时长最短")


        tv_screen1.setOnClickListener(this)
        tv_screen2.setOnClickListener(this)
        tv_screen3.setOnClickListener(this)
        tv_screen4.setOnClickListener(this)
        tv_screen5.setOnClickListener(this)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_data
    }

    override fun showData(t: NetData?) {
    }



    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it,this) }
        PopUtils.showPopupWindow(tv_screen1)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_screen1 ->jumpActivity(null,EcModel::class.java)
            R.id.tv_screen2->jumpActivity(null,Brand::class.java)
            R.id.tv_screen3->jumpActivity(null,EcType::class.java)
                R.id.tv_screen4->showInput()
        }
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
    }
}