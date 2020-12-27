package com.example.mechanicalapp.ui.fragment.store

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.GoodsListActivity
import com.example.mechanicalapp.ui.activity.HistorySearchActivity
import com.example.mechanicalapp.ui.activity.ShopCarActivity
import com.example.mechanicalapp.ui.adapter.*
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.StorePresenterImpl
import com.example.mechanicalapp.ui.mvp.v.StoreView
import com.example.mechanicalapp.ui.view.MyDecoration
import com.example.mechanicalapp.ui.view.PopUtils
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.fragment_store.*
import kotlinx.android.synthetic.main.fragment_store.recycler_list_left
import kotlinx.android.synthetic.main.fragment_store.recycler_list_right
import java.lang.Exception


class StoreFragment : BaseCusFragment(), OnItemClickListener, PopUtils.onViewListener,OnItemClickLevelListener,
    View.OnClickListener,StoreView<StoreLeftBean> {
    private var mLeftAdapter: StoreLeftAdapter? = null
    private var mRightAdapter: StoreRightAdapter? = null
    private var mLeftList: MutableList<StoreLeftBean> = ArrayList<StoreLeftBean>()
    private var mBannerList: MutableList<BannerData>? = ArrayList<BannerData>()


    private var popTvTitle: TextView? = null
    private var popTvInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null


    private var selectIndex:Int =0;
    private var rightIndex:Int=0

    override fun getLayoutId(): Int {

        return R.layout.fragment_store
    }

    override fun initView() {
        super.initView()

        mLeftAdapter = StoreLeftAdapter(mContext, mLeftList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(mContext)
        recycler_list_left.adapter = mLeftAdapter

        mRightAdapter = StoreRightAdapter(mContext, mLeftList, this)
        recycler_list_right.layoutManager = LinearLayoutManager(mContext)
        recycler_list_right.adapter = mRightAdapter

        banner.adapter = ImageAdapter(mBannerList)
        banner.indicator = CircleIndicator(mContext)

        fl_shop_car.setOnClickListener(this)
        iv_phone.setOnClickListener(this)
        ly_search.setOnClickListener(this)

        mPresenter = StorePresenterImpl(mContext,this)
        mPresenter?.request()


        recycler_list_right.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState==0){
                    //recycler_list_left.scrollToPosition()
                    selectLeft(rightIndex,false)
                }

            }
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager) {
                    rightIndex =(layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                }
            }
        })


    }

    override fun onItemClick(view: View, position: Int) {
        when (view?.id) {
            R.id.tv_type->selectLeft(position,true)
        }
    }

    private fun selectLeft(position: Int, b: Boolean) {

        try {
            if (selectIndex!=position){
                mLeftList[selectIndex].isSelect =false
                mLeftAdapter?.notifyItemChanged(selectIndex)
                mLeftList[position].isSelect =true
                mLeftAdapter?.notifyItemChanged(position)
                selectIndex =position
                if (b){
                    scrollRight()
                }
            }
        }catch (e:Exception){

        }

    }
    private fun scrollRight(){
        if (selectIndex< recycler_list_right?.adapter?.itemCount!!){
            recycler_list_right?.scrollToPosition(selectIndex)
        }
    }

    private fun showPhone() {

        if (mPopwindow == null) {
            mPopwindow = activity?.let {
                PopUtils.init(
                    mContext,
                    it, R.layout.pop_center_phone,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }

        activity?.let { PopUtils.showPopupWindow(iv_phone, it) }
    }

    override fun getView(view: View?) {

        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popTvTitle = view?.findViewById(R.id.tv_pop_title)
        popTvInfo = view?.findViewById(R.id.tv_pop_info)

        popTvTitle?.text ="客服电话"
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.fl_shop_car -> jumpActivity(
                null,
                ShopCarActivity::class.java
            )
            R.id.ly_search->{
                var bundle  = Bundle()
                bundle.putInt(Configs.HISTORY_TYPE,11)
                jumpActivity(bundle, HistorySearchActivity::class.java)
            }
            R.id.iv_phone -> showPhone()
            R.id.tv_pop_sure -> activity?.let { PopUtils.dismissPop(it) }
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }
        }
    }

    override fun err() {


    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun showAd(adList: List<BannerData>) {

        mBannerList?.clear()
        mBannerList?.addAll(adList)
        banner.adapter?.notifyDataSetChanged()
    }

    override fun showData(list: List<StoreLeftBean>) {

        mLeftList.clear()
        mLeftList.addAll(list)

        if (mLeftList.size>0){
            mLeftList[0].isSelect =true
        }
        mLeftAdapter?.notifyDataSetChanged()
        mRightAdapter?.notifyDataSetChanged()
    }

    override fun onItemClick(view: View, position: Int, childPosition: Int) {
            var bundle =Bundle()
            bundle.putString("title",mLeftList[position].children[childPosition].name)
            jumpActivity(bundle, GoodsListActivity::class.java)

    }
}