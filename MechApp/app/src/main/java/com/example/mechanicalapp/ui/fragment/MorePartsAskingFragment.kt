package com.example.mechanicalapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.EcType
import com.example.mechanicalapp.ui.activity.PartsAskDetailsActivity
import com.example.mechanicalapp.ui.adapter.MorePartsAskAdapter
import com.example.mechanicalapp.ui.adapter.ScreenAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.ui.mvp.impl.MorePartsPresenter
import com.example.mechanicalapp.ui.mvp.v.MorePartsLeaseView
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.fragment_more_parts_lease.*

/**
 * 求组 配件
 */
class MorePartsAskingFragment  : BaseCusFragment(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener , MorePartsLeaseView<NetData> {
    var mAdapter: MorePartsAskAdapter? = null
    var mList: MutableList<PartsData> = ArrayList<PartsData>()

    var popRecy: RecyclerView? = null
    private var mScreenAdapter: ScreenAdapter? = null

    private var mStringList: MutableList<String> = ArrayList<String>()


    override fun initView() {
        super.initView()

        mAdapter = MorePartsAskAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter



        mStringList?.add("智能排序")
        mStringList?.add("距离由远至近")
        mStringList?.add("最新上架")

        ly_sort.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        mPresenter = MorePartsPresenter(mContext,this)
        (mPresenter as MorePartsPresenter).getPartsLeaseList("2")
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun getLayoutId(): Int {

        return R.layout.fragment_more_parts_lease
    }



    private fun showInput() {

        activity?.let { PopUtils.init(mContext, it, this) }
        PopUtils.showPopupWindow(ly_sort)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.ly_ec_type -> jumpActivityForReSult(
                Configs.EC_TYPE_RESULT_CODE,
                EcType::class.java
            )
            R.id.ly_sort -> showInput()

        }
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mScreenAdapter = ScreenAdapter(mContext, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(mContext)
        popRecy?.adapter = mScreenAdapter
    }

    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.tv_screen->{
                (mPresenter as MorePartsPresenter).setSort(position)
                PopUtils.dismissPop()
            }
            R.id.item_root->{

                var bundle = Bundle()
                bundle.putString(Configs.MEC_ID, mList[position].id)
                jumpActivity(bundle,PartsAskDetailsActivity::class.java)
            }
            R.id.iv_phone->{
                openCall(mList[position].contactPhone)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        showResult(requestCode, data?.getStringExtra(Configs.SCREEN_RESULT_Extra),data?.getStringExtra(Configs.SCREEN_RESULT_ID))
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun showResult(requestCode: Int, extra: String?, stringExtra: String?) {
        if (extra.isNullOrEmpty()) {
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE ->
            {tv_ec_type.text = extra
                (mPresenter as MorePartsPresenter).setCateId(stringExtra)
                refresh()

            }

        }
    }
    private fun refresh(){
        (mPresenter as MorePartsPresenter).getPartsLeaseList("2")
    }
    override fun refreshUI(list: List<PartsData>) {
        mList.clear()
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<PartsData>) {
        mList.addAll(list)
        mAdapter?.notifyDataSetChanged()
    }

    override fun err() {
    }

    fun reFresh() {
        (mPresenter as MorePartsPresenter).resetPage()
        (mPresenter as MorePartsPresenter).getPartsLeaseList("2")
    }
}