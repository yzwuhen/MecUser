package com.example.mechanicalapp.ui.fragment.store

import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.activity.GoodsListActivity
import com.example.mechanicalapp.ui.activity.ShopCarActivity
import com.example.mechanicalapp.ui.adapter.EcTypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.EcTypeRightAdapter
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_store.*


class StoreFragment : BaseFragment<NetData>(), OnItemClickListener, PopUtils.onViewListener,
    View.OnClickListener {
    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: EcTypeRightAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    private var mBannerList: MutableList<BannerData>? = ArrayList<BannerData>()


    private var popTvTitle: TextView? = null
    private var popTvInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null

    override fun getLayoutId(): Int {

        return R.layout.fragment_store
    }

    override fun initView() {
        super.initView()
        mList.add("不限")
        mList.add("挖掘机")
        mList.add("推土机")
        mList.add("旋挖机")
        mList.add("汽车吊")
        mList.add("泵车")
        mList.add("装载机")


        mLeftAdapter = EcTypeLeftAdapter(mContext, mList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(mContext)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = EcTypeRightAdapter(mContext, mList, this)
        recycler_list_right.layoutManager = GridLayoutManager(mContext, 2)
        recycler_list_right.addItemDecoration(MyDecoration(2))
        recycler_list_right.adapter = mRightAdapter


        var bannerData = BannerData()
        bannerData.img =
            "https://t9.baidu.com/it/u=2268908537,2815455140&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601476836&t=43717528e86dbef35c5a6e035d0e8c55"

        mBannerList?.add(bannerData)
        mBannerList?.add(bannerData)

        banner.adapter = ImageAdapter(mBannerList)
        banner.indicator = CircleIndicator(mContext)

        fl_shop_car.setOnClickListener(this)
        iv_phone.setOnClickListener(this)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onItemClick(view: View, position: Int) {


        when (view?.id) {
            R.id.ly_type -> jumpActivity(null, GoodsListActivity::class.java)

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
            R.id.iv_phone -> showPhone()
            R.id.tv_pop_sure -> activity?.let { PopUtils.dismissPop(it) }
            R.id.tv_pop_cancel -> activity?.let { PopUtils.dismissPop(it) }
        }
    }
}