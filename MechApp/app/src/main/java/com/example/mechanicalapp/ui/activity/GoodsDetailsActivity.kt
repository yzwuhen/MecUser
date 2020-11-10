package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItmeClickTyleListener
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.adapter.SpecAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.BannerData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_goods_details.*
import kotlinx.android.synthetic.main.activity_goods_details.banner
import kotlinx.android.synthetic.main.layout_left_right_title.*

class GoodsDetailsActivity:BaseActivity<NetData>(),View.OnClickListener ,OnItmeClickTyleListener{



    private var mShareDialog: BottomSheetDialog?=null
    private var mShareView: View?=null

    private var mLyWx: LinearLayout?=null
    private var mLyQq: LinearLayout?=null
    private var mLySina: LinearLayout?=null
    private var mTvCancelShare: TextView?=null


    private var mSpecsDialog: BottomSheetDialog?=null
    private var mSpecsView: View?=null

    private var mIvPic:ImageView?=null
    private var mTvMoney:TextView?=null
    private var mTvBtn:TextView?=null
    private var mTvTitle:TextView?=null
    private var mIvClose:ImageView?=null
    private var mSpecRecycler1:RecyclerView?=null
    private var mSpecRecycler2:RecyclerView?=null

    private var mSpecAdapter1:SpecAdapter?=null

    private var mSpecAdapter2:SpecAdapter?=null


    private var mList:MutableList<String> =ArrayList<String>()
    private var mList1:MutableList<String> =ArrayList<String>()

    var mList2: MutableList<BannerData>? = ArrayList<BannerData>()

    override fun getLayoutId(): Int {

        return R.layout.activity_goods_details
    }

    override fun initView() {
        super.initView()
        tv_title.text="商品详情"
        iv_right.setImageResource(R.mipmap.black_phone)
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)

        ly_specs.setOnClickListener(this)
        iv_share.setOnClickListener(this)
        ly_comment.setOnClickListener(this)
        ly_add_shop_car.setOnClickListener(this)
        ly_buy.setOnClickListener(this)
        ly_user_info.setOnClickListener(this)

        mList.add("红色")
        mList.add("黄色")
        mList.add("黑色")
        mList.add("蓝色")

        mList1.add("L")
        mList1.add("XL")
        mList1.add("XXL")

        var bannerData = BannerData()
        bannerData.img =
            "https://t8.baidu.com/it/u=2247852322,986532796&fm=79&app=86&size=h300&n=0&g=4n&f=jpeg?sec=1600708280&t=2c8b3ed72148e0c4fb274061565e6723"

        mList2?.add(bannerData)
        mList2?.add(bannerData)

        banner.adapter = ImageAdapter(mList2)
        banner.indicator = CircleIndicator(this)
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_left->finish()
            R.id.iv_right->callService()
            R.id.ly_specs->showSpecs()
            R.id.iv_share->showShare()
            R.id.ly_comment->jumComment()
            R.id.ly_add_shop_car->addCar()
            R.id.ly_buy->buy()
            R.id.ly_wx->mShareDialog?.dismiss()
            R.id.ly_qq->mShareDialog?.dismiss()
            R.id.ly_sina->mShareDialog?.dismiss()
            R.id.tv_cancel->mShareDialog?.dismiss()
            R.id.iv_dialog_close->mSpecsDialog?.dismiss()
            R.id.tv_dialog_submit->mSpecsDialog?.dismiss()
            R.id.ly_user_info->jumHomePage()
        }
    }
    private fun jumHomePage() {
        var bundle = Bundle()
            bundle.putInt(Configs.USER_HOME_PAGE,3)
        jumpActivity(bundle,UserHomePage::class.java)

    }

    private fun showShare() {

        if (mShareDialog ==null){
            mShareDialog = BottomSheetDialog(this)
            mShareView = View.inflate(this, R.layout.dialog_share,null)
            mShareDialog?.setContentView(mShareView!!)

            mLyWx = mShareView?.findViewById(R.id.ly_wx)
            mLyQq = mShareView?.findViewById(R.id.ly_qq)
            mLySina = mShareView?.findViewById(R.id.ly_sina)
            mTvCancelShare = mShareView?.findViewById(R.id.tv_cancel)

            mLyWx?.setOnClickListener(this)
            mLyQq?.setOnClickListener(this)
            mLySina?.setOnClickListener(this)
            mTvCancelShare?.setOnClickListener(this)
        }
        mShareDialog?.show()

    }

    private fun buy() {
        jumpActivity(null,SureOrderActivity::class.java)

    }

    private fun addCar() {


    }

    private fun jumComment() {

        jumpActivity(null,CommentListActivity::class.java)

    }

    private fun showSpecs() {
        if (mSpecsDialog ==null){
            mSpecsDialog = BottomSheetDialog(this)
            mSpecsView = View.inflate(this, R.layout.dialog_specs,null)
            mSpecsDialog?.setContentView(mSpecsView!!)

            mIvPic = mSpecsView?.findViewById(R.id.iv_dialog_goods_pic)
            mIvClose = mSpecsView?.findViewById(R.id.iv_dialog_close)

            mTvMoney = mSpecsView?.findViewById(R.id.tv_dialog_money)
            mTvTitle = mSpecsView?.findViewById(R.id.tv_dialog_info)

            mSpecRecycler1 = mSpecsView?.findViewById(R.id.recycler_model)
            mSpecRecycler2 = mSpecsView?.findViewById(R.id.recycler_size)
            mTvBtn = mSpecsView?.findViewById(R.id.tv_dialog_submit)

            mTvBtn?.setOnClickListener(this)
            mIvClose?.setOnClickListener(this)

            mSpecRecycler1?.layoutManager = GridLayoutManager(this,4)
            mSpecAdapter1 = SpecAdapter(this,mList,0,this)
            mSpecRecycler1?.adapter = mSpecAdapter1

            mSpecRecycler2?.layoutManager = GridLayoutManager(this,4)
            mSpecAdapter2 = SpecAdapter(this,mList1,0,this)
            mSpecRecycler2?.adapter = mSpecAdapter2
        }
        mSpecsDialog?.show()

    }

    private fun callService() {


    }

    override fun onItemClick(view: View, position: Int, type: Int) {


    }
}