package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MecFactoryAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.FactoryData
import com.example.mechanicalapp.ui.mvp.impl.FactoryPresenter
import com.example.mechanicalapp.ui.mvp.impl.MecLeaseListPresenter
import com.example.mechanicalapp.ui.mvp.v.FactoryView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_more_factory.*
import kotlinx.android.synthetic.main.activity_more_factory.spring_list
import kotlinx.android.synthetic.main.layout_more_data_title.*

class MoreFactoryActivity : BaseCusActivity() ,View.OnClickListener ,PopUtils.onViewListener,
    OnItemClickListener,FactoryView {

    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null

    private var mStringList :MutableList<String> = ArrayList<String>()


    private var mMecFactoryShopAdapter : MecFactoryAdapter?=null
    var mList: MutableList<FactoryData> = ArrayList<FactoryData>()

    private var mPresenter:FactoryPresenter?=null

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


        mMecFactoryShopAdapter = MecFactoryAdapter(this,mList,this)

        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mMecFactoryShopAdapter

        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as FactoryPresenter).resetPage()
                (mPresenter as FactoryPresenter).getFactoryList()
            }

            override fun onLoadmore() {
                (mPresenter as FactoryPresenter).getFactoryList()
            }
        })


        mPresenter = FactoryPresenter(this,this)
        mPresenter?.getFactoryList()
    }

    fun closeRefreshView() {
        spring_list?.isEnable=true
        spring_list?.onFinishFreshAndLoad()
    }



    override fun initPresenter() {
    }

    override fun refreshUI(list: List<FactoryData>) {
        mList.clear()
        mList.addAll(list)
        mMecFactoryShopAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<FactoryData>) {
        mList.addAll(list)
        mMecFactoryShopAdapter?.notifyDataSetChanged()
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

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.iv_back->finish()
            R.id.ly_ec_type ->jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_parts_type ->jumpActivityForReSult(
                Configs.PARTS_TYPE_RESULT_CODE,
                PartsTypeActivity::class.java
            )
            R.id.ly_sort ->showPop()
            R.id.tv_search ->jumAct()
            R.id.tv_map->{
                if (isLocationEnabled(this)){
                    jumpActivity(null,MapFactoryActivity::class.java)
                }else{
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    startActivity(intent)
                }
            }
        }
    }
    private fun jumAct(){
        var bundle :Bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,6)
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
            R.id.tv_screen->{
                tv_sort.text=mStringList[position]
                (mPresenter as FactoryPresenter).setSort(position)
                PopUtils.dismissPop()
            }
            R.id.root_view->setSelect(position)
        }
    }

    private fun setSelect(position: Int) {
        var bundle =Bundle()
        bundle.putString("id",mList[position].id)
        jumpActivity(bundle,FactoryDetails::class.java)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

            showResult(
                requestCode,
                data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
                data?.getStringExtra(Configs.SCREEN_RESULT_ID)
            )
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                tv_ec_type.text = extra
                if (extra =="不限"){
                    (mPresenter as FactoryPresenter)?.setRepaireType(null)
                }else{
                    (mPresenter as FactoryPresenter)?.setRepaireType(extra)
                }

            }
            Configs.PARTS_TYPE_RESULT_CODE -> {
                tv_parts_type.text = extra
                if (extra =="不限"){
                    (mPresenter as FactoryPresenter)?.setComponentType(null)
                }else{
                    (mPresenter as FactoryPresenter)?.setComponentType(extra)
                }
            }

        }

        (mPresenter as FactoryPresenter)?.getFactoryList()
    }

}