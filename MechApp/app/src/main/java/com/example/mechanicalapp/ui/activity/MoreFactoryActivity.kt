package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MecFactoryAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_more_factory.*
import kotlinx.android.synthetic.main.layout_more_data_title.*

class MoreFactoryActivity : BaseActivity<NetData>() ,View.OnClickListener ,PopUtils.onViewListener,
    OnItemClickListener {

    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null

    private var mStringList :MutableList<String> = ArrayList<String>()


    private var mMecFactoryShopAdapter : MecFactoryAdapter?=null
    var mList: MutableList<String> = ArrayList<String>()

    override fun getLayoutId(): Int {

        return R.layout.activity_more_factory
    }

    override fun initView() {
        super.initView()

        iv_back.setOnClickListener(this)
        tv_search.setOnClickListener(this)
        tv_map.setOnClickListener(this)

        ly_ec_type.setOnClickListener(this)
        ly_parts_type.setOnClickListener(this)
        ly_sort.setOnClickListener(this)


        mStringList?.add("智能排序")
        mStringList?.add("距离由近到远")
        mStringList?.add("最新上架")



        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mMecFactoryShopAdapter = MecFactoryAdapter(this,mList,this)

        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mMecFactoryShopAdapter

        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(this))

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.setEnable(false)
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {}
        })

    }

    fun closeRefreshView() {
        spring_list.setEnable(true)
        spring_list.onFinishFreshAndLoad()
    }



    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back->finish()
            R.id.ly_ec_type ->jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_parts_type ->jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_sort ->showPop()
            R.id.tv_search ->jumAct()
            R.id.tv_map->jumpActivity(null,MapActivity::class.java)
        }
    }
    private fun jumAct(){
        var bundle :Bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,10)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    private fun showPop() {
        this?.let { PopUtils.init(this, it,this) }
        PopUtils.showPopupWindow(ly_sort)
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.tv_screen->tv_sort.text=mStringList[position]
            R.id.ly_item_mec_factory->setSelect()
        }
    }

    private fun setSelect() {


    }
}