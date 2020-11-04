package com.example.mechanicalapp.ui.fragment

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.EcModel
import com.example.mechanicalapp.ui.activity.PartsLeaseDetailsActivity
import com.example.mechanicalapp.ui.adapter.MorePartsAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.fragment_more_parts_lease.*

class MorePartsLeaseFragment : BaseFragment<NetData>(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener {
    var mAdapter: MorePartsAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    var popRecy : RecyclerView?=null
    private var mScreenAdapter : ScreenAdapter?=null

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

        mAdapter = MorePartsAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter



        mStringList?.add("智能排序")
        mStringList?.add("距离由远至近")
        mStringList?.add("最新上架")

        ly_sort.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)

    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_parts_lease
    }

    override fun showData(t: MutableList<StoreLeftBean>) {
    }



    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it,this) }
        PopUtils.showPopupWindow(ly_sort)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){

            R.id.ly_ec_type->jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcModel::class.java
            )
            R.id.ly_sort->showInput()
        }
    }

    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {
        jumpActivity(null,PartsLeaseDetailsActivity::class.java)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (Configs.EC_TYPE_RESULT_CODE==resultCode){
            tv_ec_type.text =data?.getStringExtra(Configs.SCREEN_RESULT_Extra)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}