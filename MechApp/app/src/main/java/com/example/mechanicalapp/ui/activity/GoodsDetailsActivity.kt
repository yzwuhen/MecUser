package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.adapter.SpecAttrAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReAddCar
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.GoodsDetailsView
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_goods_details.*
import kotlinx.android.synthetic.main.item_comment.*
import kotlinx.android.synthetic.main.layout_left_right_title.*
import java.io.Serializable

class GoodsDetailsActivity : BaseCusActivity(), View.OnClickListener, OnItemClickLevelListener,
    GoodsDetailsView {

    private var mShareDialog: BottomSheetDialog? = null
    private var mShareView: View? = null

    private var mLyWx: LinearLayout? = null
    private var mLyQq: LinearLayout? = null
    private var mLySina: LinearLayout? = null
    private var mTvCancelShare: TextView? = null


    private var mSpecsDialog: BottomSheetDialog? = null
    private var mSpecsView: View? = null

    private var mIvPic: ImageView? = null
    private var mTvMoney: TextView? = null
    private var mTvBtn: TextView? = null
    private var mTvTitle: TextView? = null
    private var mIvClose: ImageView? = null
    private var mSpecRecycler: RecyclerView? = null

    private var mSpecAttrAdapter: SpecAttrAdapter? = null

    private var mSpecList: MutableList<GoodsDetails.SkuNameListBean> =
        ArrayList<GoodsDetails.SkuNameListBean>()
    private var commentData: CommentData? = null

    //skuList
    private var mSkuList: MutableList<SkuListData> =
        ArrayList<SkuListData>()
    var mList2: MutableList<BannerData>? = ArrayList<BannerData>()


    private var mPresenter: DetailsPresenter? = null
    private var mecId: String? = null
    private var mReCollect = ReCollect()

    private var strSpec = ""
    private var isChange = false

    private var isCollect = false

    private var goodsProduct: GoodsProduct? = null

    private var bundleData: SkuListData? = null

    override fun getLayoutId(): Int {
        return R.layout.activity_goods_details
    }

    override fun initView() {
        super.initView()
        tv_title.text = "商品详情"
        iv_right.setImageResource(R.mipmap.black_phone)
        iv_left.setOnClickListener(this)
        iv_right.setOnClickListener(this)

        ly_specs.setOnClickListener(this)
        iv_share.setOnClickListener(this)
        ly_comment.setOnClickListener(this)
        ly_add_shop_car.setOnClickListener(this)
        ly_buy.setOnClickListener(this)
        ly_user_info.setOnClickListener(this)
        tv_collected.setOnClickListener(this)


        mecId = intent.getStringExtra(Configs.MEC_ID)

        mReCollect.type = 0
        mReCollect.storeId = mecId
    }

    override fun initPresenter() {
        mPresenter = DetailsPresenter(this)
        mPresenter?.getGoodsDetails(mecId)
        mPresenter?.judgeCollect(mecId,0)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_left -> finish()
            R.id.iv_right -> callService()
            R.id.ly_specs -> showSpecs()
            R.id.iv_share -> showShare()
            R.id.ly_comment -> jumComment()
            R.id.ly_add_shop_car -> addCar()
            R.id.ly_buy -> buy()
            R.id.ly_wx -> mShareDialog?.dismiss()
            R.id.ly_qq -> mShareDialog?.dismiss()
            R.id.ly_sina -> mShareDialog?.dismiss()
            R.id.tv_cancel -> mShareDialog?.dismiss()
            R.id.iv_dialog_close -> mSpecsDialog?.dismiss()
            R.id.tv_dialog_submit -> mSpecsDialog?.dismiss()
            R.id.ly_user_info -> jumHomePage()
            R.id.tv_collected -> collect()
        }
    }

    private fun collect() {
        if (TextUtils.isEmpty(App.getInstance().token)) {
            ToastUtils.showText("请先登陆后再操作")
            return
        }
        if (isCollect) {
            mPresenter?.delCollect(mReCollect)
        } else {
            mPresenter?.addCollect(mReCollect)
        }

    }

    private fun jumHomePage() {
//        var bundle = Bundle()
//        bundle.putInt(Configs.USER_HOME_PAGE, 1)
//        bundle.putString(Configs.USER_HOME_PAGE_NAME,goodsProduct?.createBy)
//        jumpActivity(bundle, UserHomePage::class.java)

    }

    private fun showShare() {

        if (mShareDialog == null) {
            mShareDialog = BottomSheetDialog(this)
            mShareView = View.inflate(this, R.layout.dialog_share, null)
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
        if (bundleData == null) {
            ToastUtils.showText("请先选择规格")
            return
        }
        var bundle = Bundle()

        var mList:MutableList<SkuBean> =ArrayList<SkuBean>()
        var skuBean =SkuBean()
        skuBean.num =1
        skuBean.skuListData =bundleData
        mList.add(skuBean)
        bundle.putSerializable("data", mList as Serializable)
        jumpActivity(bundle, SureOrderActivity::class.java)

    }

    private fun addCar() {
        //    jumpActivity(null,ShopCarActivity::class.java)
        if (bundleData == null) {
            ToastUtils.showText("请先选择规格")
            return
        }
        if (TextUtils.isEmpty(App.getInstance().token)) {
            ToastUtils.showText("请先登录后操作")
            return
        }
        var reAddCar = ReAddCar()
        reAddCar.productId = mecId
        reAddCar.skuId = bundleData?.id
        reAddCar.quantity = 1

        mPresenter?.addShopCar(reAddCar)
    }

    private fun jumComment() {

        var bundle = Bundle()
        bundle.putString("id", mecId)
        jumpActivity(bundle, CommentListActivity::class.java)

    }

    private fun showSpecs() {
        if (mSpecsDialog == null) {
            mSpecsDialog = BottomSheetDialog(this)
            mSpecsView = View.inflate(this, R.layout.dialog_specs, null)
            mSpecsDialog?.setContentView(mSpecsView!!)

            mIvPic = mSpecsView?.findViewById(R.id.iv_dialog_goods_pic)
            mIvClose = mSpecsView?.findViewById(R.id.iv_dialog_close)

            mTvMoney = mSpecsView?.findViewById(R.id.tv_dialog_money)
            mTvTitle = mSpecsView?.findViewById(R.id.tv_dialog_info)

            mSpecRecycler = mSpecsView?.findViewById(R.id.spec_recycle_list)
            mTvBtn = mSpecsView?.findViewById(R.id.tv_dialog_submit)

            mTvBtn?.setOnClickListener(this)
            mIvClose?.setOnClickListener(this)

            mSpecRecycler?.layoutManager = LinearLayoutManager(this)
            mSpecAttrAdapter = SpecAttrAdapter(this, mSpecList, this)
            mSpecRecycler?.adapter = mSpecAttrAdapter

            if (goodsProduct != null) {
                ImageLoadUtils.loadImageCenterCrop(
                    this,
                    mIvPic,
                    StringUtils.getImgStr(goodsProduct?.images),
                    R.mipmap.ic_launcher
                )
                mTvMoney?.text = "￥${goodsProduct?.price}"
                mTvTitle?.text = goodsProduct?.title
            }
        }
        mSpecsDialog?.show()

    }

    private fun callService() {
    }

    override fun onItemClick(view: View, parentPosition: Int, childPosition: Int) {
        isChange = false
        for (index in mSpecList[parentPosition].getmSpecList().indices) {
            if (mSpecList[parentPosition].getmSpecList()[index].specNum > 0) {
                mSpecList[parentPosition].getmSpecList()[index].isSelect =
                    index == childPosition
                isChange = true
            }
        }
        if (isChange) {
            mSpecAttrAdapter?.notifyItemChanged(parentPosition)
            showAttrText()
        }
    }

    //匹配规格
    private fun showAttrText() {
        strSpec = ""
        for (attr in mSpecList) {
            strSpec += "${attr.typeName}:"
            for (spec in attr.getmSpecList()) {
                if (spec.isSelect) {
                    strSpec += spec.specName
                }
            }
            strSpec += ","
        }
        strSpec = strSpec.substring(0, strSpec.length - 1)
        for (sku in mSkuList.iterator()) {
            if (strSpec == sku.name) {
                showDiaLogText(sku)
                bundleData = sku
                showDiaLogText(sku)
            }
        }

    }

    //显示相关内容
    private fun showDiaLogText(goods: SkuListData) {
        tv_specs.text = strSpec
        ImageLoadUtils.loadImageCenterCrop(this, mIvPic, goods.picture, R.mipmap.ic_launcher)
        mTvMoney?.text = "￥${goods.price}"
        mTvTitle?.text = goods.mecProductName
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    private fun showComment() {
        if (commentData == null) {
            ly_comment_info.visibility = View.GONE
        } else {
            ImageLoadUtils.loadImageCenterCrop(
                this,
                iv_comment_pic,
                commentData?.commentUserHeader,
                R.mipmap.ic_launcher
            )
            tv_comment_user_name.text = commentData?.commentUserName
            tv_buy_info.text = "${commentData?.mecProductSkuName}"
            tv_comment.text = commentData?.content
            ratingBar.rating = commentData?.star!!

        }

    }

    override fun showData(data: GoodsDetails?) {
        if (data != null) {
            goodsProduct = data.product
            if (!TextUtils.isEmpty(goodsProduct?.images)) {
                for (imgUrl in goodsProduct?.images?.split(",")!!) {
                    var bannerData = BannerData()
                    bannerData.img = imgUrl
                    mList2?.add(bannerData)
                }
                banner.adapter = ImageAdapter(mList2)
                banner.indicator = CircleIndicator(this)
            }

            tv_details_title.text = goodsProduct?.title
            tv_money.text = "￥${goodsProduct?.price}"
            tv_sell_num.text = "销量：${goodsProduct?.scale}件"

            mSpecList.clear()
            mSpecList.addAll(data.skuNameList)

            try {
                for (str in mSpecList) {
                    var specList = ArrayList<Spec>()
                    for (attr in str.nameList) {
                        var spec = Spec()
                        spec.specName = attr.split(",")[0]
                        spec.specNum = attr.split(",")[1].toInt()
                        specList.add(spec)
                    }
                    str.setmSpecList(specList)
                }


            } catch (e: Exception) {

            }

            mSkuList.clear()
            mSkuList.addAll(data.skuList)

            commentData = data.comment

            tv_details.text = Html.fromHtml(goodsProduct?.detail)
            showComment()
        }

    }

    override fun collectSuccess(netData: NetData?) {
        if (netData is IsCollectBean) {
            if (netData.result == 1) {
                isCollect = true
                tv_collected.text = "已收藏"
                tv_collected.isSelected = true
            }

        } else if (netData is AddCarBean) {
            if (netData.code==200){
                ToastUtils.showText("已添加到购物车中")
            }else{
                ToastUtils.showText(netData.message)
            }
        } else {
            if (netData != null && netData.code == 200) {
                if (!isCollect) {
                    tv_collected.text = "已收藏"
                    tv_collected.isSelected = true
                } else {
                    tv_collected.text = "收藏"
                    tv_collected.isSelected = false
                }
                isCollect = !isCollect
            }
            ToastUtils.showText(netData?.message)
        }
    }

}