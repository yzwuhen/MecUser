package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.GoodsListAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_goods_list.*
import kotlinx.android.synthetic.main.layout_search_et.*

class GoodsListActivity:BaseActivity<NetData>(),OnItemClickListener ,View.OnClickListener,
    PopUtils.onViewListener {
    private var mList :MutableList<String> = ArrayList<String>()
    var mAdapter : GoodsListAdapter?=null

    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null
    private var mStringList :MutableList<String> = ArrayList<String>()
    private var mViewList :MutableList<TextView> = ArrayList<TextView>()

    override fun getLayoutId(): Int {

        return R.layout.activity_goods_list

    }

    override fun initView() {
        super.initView()

        tv_sort.isSelected = true;

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        mAdapter = GoodsListAdapter(this,mList,this)
        recycle_list.addItemDecoration(MyDecoration(2))
        recycle_list.layoutManager = GridLayoutManager(this,2)
        recycle_list.adapter = mAdapter

        mStringList?.add("智能排序")
        mStringList?.add("新品")
        mStringList?.add("人气")

        mViewList.add(tv_price)
        mViewList.add(tv_sales)
        mViewList.add(tv_sort)

        ly_price.setOnClickListener(this)
        ly_sales.setOnClickListener(this)
        ly_sort.setOnClickListener(this)
        ly_search.setOnClickListener(this)

    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onItemClick(view: View, position: Int) {

        jumpActivity(null,GoodsDetailsActivity::class.java)

    }
    private fun showInput() {

        this?.let { PopUtils.init(this, it,this) }
        PopUtils.showPopupWindow(ly_sort)
    }
    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onClick(view: View?) {
        when(view?.id){
         //  R.id.ly_search ->jumAct()
            R.id.ly_price->selectText(0);
            R.id.ly_sales->selectText(1);
            R.id.ly_sort->selectText(2);
        }
    }
    private fun  jumAct(){
        var bundle  = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,3)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    private fun selectText(position:Int){
        for (index in mViewList.indices){
            mViewList[index].isSelected = index == position
        }
        if (position ==2){
            showInput()
        }
    }
}