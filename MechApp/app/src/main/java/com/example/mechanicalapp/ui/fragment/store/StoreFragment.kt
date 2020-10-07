package com.example.mechanicalapp.ui.fragment.store

import android.view.View
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
import com.example.mechanicalapp.ui.adapter.WorkTypeAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.activity_ec_type.recycler_list_left
import kotlinx.android.synthetic.main.activity_ec_type.recycler_list_right
import kotlinx.android.synthetic.main.activity_more_data.*
import kotlinx.android.synthetic.main.activity_more_data.banner
import kotlinx.android.synthetic.main.fragment_store.*

class StoreFragment: BaseFragment<NetData>(), OnItemClickListener {
    private var mLeftAdapter: EcTypeLeftAdapter? = null
    private var mRightAdapter: EcTypeRightAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    private var mBannerList: MutableList<BannerData>? = ArrayList<BannerData>()
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
        recycler_list_right.layoutManager = GridLayoutManager(mContext,2)
        recycler_list_right.addItemDecoration(MyDecoration(2))
        recycler_list_right.adapter = mRightAdapter


        var bannerData: BannerData
        bannerData = BannerData()
        bannerData.img_path ="https://t9.baidu.com/it/u=2268908537,2815455140&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1601476836&t=43717528e86dbef35c5a6e035d0e8c55"

        mBannerList?.add(bannerData)
        mBannerList?.add(bannerData)

        banner.adapter = ImageAdapter(mBannerList)
        banner.indicator = CircleIndicator(mContext)

        fl_shop_car.setOnClickListener(View.OnClickListener { jumpActivity(null,ShopCarActivity::class.java) })
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onItemClick(view: View, position: Int) {


        when(view?.id){
            R.id.ly_type->jumpActivity(null,GoodsListActivity::class.java)
        }
    }
}