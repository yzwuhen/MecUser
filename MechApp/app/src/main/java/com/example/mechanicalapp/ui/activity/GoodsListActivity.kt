package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.GoodsListAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.GoodsData
import com.example.mechanicalapp.ui.data.GoodsListBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.GoodsListPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.MyDecoration
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_goods_list.*
import kotlinx.android.synthetic.main.activity_goods_list.spring_list
import kotlinx.android.synthetic.main.layout_search_et.*
import kotlinx.android.synthetic.main.layout_spring_list.*

class GoodsListActivity:BaseCusActivity(),OnItemClickListener ,View.OnClickListener,NetDataView<NetData>,
    PopUtils.onViewListener {
    private var mList :MutableList<GoodsData> = ArrayList<GoodsData>()
    var mAdapter : GoodsListAdapter?=null

    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null
    private var mStringList :MutableList<String> = ArrayList<String>()
    private var mViewList :MutableList<TextView> = ArrayList<TextView>()

    private var title=""
    private var mPresenter: GoodsListPresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_goods_list

    }

    override fun initView() {
        super.initView()

        tv_sort.isSelected = true;


        mAdapter = GoodsListAdapter(this,mList,this)
        recycle_list.layoutManager = GridLayoutManager(this,2)
        recycle_list.addItemDecoration(MyDecoration(2))
        recycle_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as GoodsListPresenter).resetPage()
                (mPresenter as GoodsListPresenter).getGoodsList()
            }

            override fun onLoadmore() {
                (mPresenter as GoodsListPresenter).getGoodsList()
            }
        })



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

        title=  intent.getStringExtra("title").toString()


    }

    override fun initPresenter() {

        mPresenter = GoodsListPresenter(this)
        mPresenter?.setTitle(title)
        mPresenter?.getGoodsList()
    }
    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun err()  {
    }

    override fun onItemClick(view: View, position: Int) {
        val bundle = Bundle()
        bundle.putString(Configs.MEC_ID, mList[position].id)
        jumpActivity(bundle,GoodsDetailsActivity::class.java)

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

    override fun refreshUI(data: NetData?) {
        if (data is GoodsListBean){
            mList.clear()
            if (data.result!=null&&data.result.records!=null){
                mList.addAll(data.result.records)
            }
            mAdapter?.notifyDataSetChanged()
        }

    }

    override fun loadMore(data: NetData?) {
        if (data is GoodsListBean){
            if (data.result!=null&&data.result.records!=null){
                mList.addAll(data.result.records)
                mAdapter?.notifyDataSetChanged()
            }
        }
    }
}