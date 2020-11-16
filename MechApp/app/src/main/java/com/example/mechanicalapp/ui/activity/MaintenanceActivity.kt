package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MecFactoryShopAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.FactoryData
import com.example.mechanicalapp.ui.mvp.impl.FactoryPresenter
import com.example.mechanicalapp.ui.mvp.v.FactoryView
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_maintenance.*
import kotlinx.android.synthetic.main.layout_title.*

class MaintenanceActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,
    OnItemClickListener,
    FactoryView {

    var popRecy: RecyclerView? = null
    private var mScreenAdapter: ScreenAdapter? = null

    private var mStringList: MutableList<String> = ArrayList<String>()


    private var mMecFactoryShopAdapter: MecFactoryShopAdapter? = null
    var mList: MutableList<FactoryData> = ArrayList<FactoryData>()


    private var mPresenter: FactoryPresenter? = null
    private var index = -1

    override fun getLayoutId(): Int {

        return R.layout.activity_maintenance
    }

    override fun initView() {
        super.initView()

        tv_title.text = "维修厂"

        iv_back.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_parts_type.setOnClickListener(this)
        ly_sort.setOnClickListener(this)
        tv_submit.setOnClickListener(this)


        mStringList?.add("智能排序")
        mStringList?.add("最新上架")
        mStringList?.add("最新上架")
        mStringList?.add("工作时长最短")


        mMecFactoryShopAdapter = MecFactoryShopAdapter(this, mList, this)

        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mMecFactoryShopAdapter

        mPresenter = FactoryPresenter(this, this)
        mPresenter?.getFactoryList()
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
    }

    override fun err() {
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.iv_back -> finish()
            R.id.ly_ec_type -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_parts_type -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_sort -> showPop()
            R.id.tv_submit -> toResult()
        }
    }

    private fun toResult() {

        if (index==-1){
            return
        }

        var intent = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra,mList[index].name)
        bundle.putString(Configs.SCREEN_RESULT_ID,mList[index].companyId)
        bundle.putString(Configs.FACTORY_ADDRESS,mList[index].address)
        intent.putExtras(bundle)
        setResult(Configs.FACTORY_RESULT_CODE, intent)
        finish()
    }

    private fun showPop() {
        this?.let { PopUtils.init(this, it, this) }
        PopUtils.showPopupWindow(ly_sort)
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
            R.id.tv_screen -> tv_sort.text = mStringList[position]
            R.id.ly_item_mec_factory -> setSelect(position)
        }
    }

    private fun setSelect(position: Int) {

        if (index != position) {
            if (index == -1) {
                mList[position].isSelect = true
                mMecFactoryShopAdapter?.notifyItemChanged(position)
            } else {
                mList[index].isSelect = false
                mMecFactoryShopAdapter?.notifyItemChanged(index)
                mList[position].isSelect = true
                mMecFactoryShopAdapter?.notifyItemChanged(position)
            }
            index = position
        }
    }
}