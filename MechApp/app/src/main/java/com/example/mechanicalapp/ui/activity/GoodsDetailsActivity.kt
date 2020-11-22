package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.App
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.adapter.ImageAdapter
import com.example.mechanicalapp.ui.adapter.SpecAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReAddCar
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.impl.DetailsPresenter
import com.example.mechanicalapp.ui.mvp.v.GoodsDetailsView
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.StringUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_goods_details.*
import kotlinx.android.synthetic.main.item_comment.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

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

    private var mTvSpec1: TextView? = null
    private var mTvSpec2: TextView? = null
    private var mIvPic: ImageView? = null
    private var mTvMoney: TextView? = null
    private var mTvBtn: TextView? = null
    private var mTvTitle: TextView? = null
    private var mIvClose: ImageView? = null
    private var mSpecRecycler1: RecyclerView? = null
    private var mSpecRecycler2: RecyclerView? = null

    private var mSpecAdapter1: SpecAdapter? = null

    private var mSpecAdapter2: SpecAdapter? = null


    private var speceName1:String=""
    private var speceName2:String=""
    private var mSpecList1: MutableList<Spec> = ArrayList<Spec>()
    private var mSpecList2: MutableList<Spec> = ArrayList<Spec>()

    private var mSpecLst =
        ArrayList<GoodsDetails.SkuListBean>()

    var mList2: MutableList<BannerData>? = ArrayList<BannerData>()


    private var mPresenter: DetailsPresenter? = null
    private var mecId: String? = null
    private var mReCollect = ReCollect()

    private var specIndex1=-1
    private var specIndex2=-1
    private var spec =""

    private var isCollect=false

    private var goodDetails:GoodsDetails?=null

    private var bundleData:GoodsDetails.SkuListBean?=null

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
        mPresenter?.getCommentList(mecId)
        mPresenter?.judgeCollect(mecId)
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
        if (isCollect){
            mPresenter?.delCollect(mReCollect)
        }else{
            mPresenter?.addCollect(mReCollect)
        }

    }

    private fun jumHomePage() {
        var bundle = Bundle()
        bundle.putInt(Configs.USER_HOME_PAGE, 3)
        jumpActivity(bundle, UserHomePage::class.java)

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
        if (bundleData==null){
            ToastUtils.showText("请先选择规格")
            return
        }
        var bundle =Bundle()
        bundle.putSerializable("data",bundleData)

        jumpActivity(bundle, SureOrderActivity::class.java)

    }

    private fun addCar() {
    //    jumpActivity(null,ShopCarActivity::class.java)
        if (bundleData==null){
            ToastUtils.showText("请先选择规格")
            return
        }
        if (TextUtils.isEmpty(App.getInstance().token)){
            ToastUtils.showText("请先登录后操作")
            return
        }
        var reAddCar=ReAddCar()
        reAddCar.productId =mecId
        reAddCar.skuId =bundleData?.id
        reAddCar.quantity=1

        mPresenter?.addShopCar(reAddCar)
    }

    private fun jumComment() {

        var bundle =Bundle()
        bundle.putString("id",mecId)
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

            mSpecRecycler1 = mSpecsView?.findViewById(R.id.recycler_model)
            mSpecRecycler2 = mSpecsView?.findViewById(R.id.recycler_size)
            mTvBtn = mSpecsView?.findViewById(R.id.tv_dialog_submit)

            mTvSpec1 =mSpecsView?.findViewById(R.id.tv_spec1)
            mTvSpec2 =mSpecsView?.findViewById(R.id.tv_spec2)
            mTvBtn?.setOnClickListener(this)
            mIvClose?.setOnClickListener(this)

            mSpecRecycler1?.layoutManager = GridLayoutManager(this, 4)
            mSpecAdapter1 = SpecAdapter(this, mSpecList1, 0, this)
            mSpecRecycler1?.adapter = mSpecAdapter1

            mSpecRecycler2?.layoutManager = GridLayoutManager(this, 4)
            mSpecAdapter2 = SpecAdapter(this, mSpecList2, 1, this)
            mSpecRecycler2?.adapter = mSpecAdapter2

            mTvSpec1?.text =speceName1
            mTvSpec2?.text =speceName2
            if (goodDetails!=null){
                ImageLoadUtils.loadImageCenterCrop(this,mIvPic,StringUtils.getImgStr(goodDetails?.img),R.mipmap.ic_launcher)
                mTvMoney?.text = "￥${goodDetails?.price}"
                mTvTitle?.text =goodDetails?.title
            }
        }

        mSpecsDialog?.show()


    }

    private fun callService() {
    }

    override fun onItemClick(view: View, position: Int, type: Int) {
        if (type==0){
            if (position!=specIndex1){
                if (specIndex1!=-1){
                   mSpecList1[specIndex1].isSelect =false
                    mSpecAdapter1?.notifyItemChanged(specIndex1)
                }
                mSpecList1[position].isSelect =true
                mSpecAdapter1?.notifyItemChanged(position)
                specIndex1 =position
            }
        }else{
            if (position!=specIndex2){
                if (specIndex2!=-1){
                    mSpecList2[specIndex2].isSelect =false
                    mSpecAdapter2?.notifyItemChanged(specIndex2)
                }
                mSpecList2[position].isSelect =true
                mSpecAdapter2?.notifyItemChanged(position)
                specIndex2 =position
            }
        }
        showAttrText()
    }

    //匹配规格
    private fun showAttrText() {
        if (specIndex1!=-1&&specIndex2!=-1){

            for (spec1 in mSpecList1){
                if (spec1.isSelect){
                    spec ="颜色:$spec1"
                }
            }
            for (spec1 in mSpecList2){
                if (spec1.isSelect){
                    spec =",尺码:$spec1"
                }
            }
            for (goods in mSpecLst.iterator()){
                if (spec == goods.name){
                    showDiaLogText(goods)
                    bundleData =goods
                }
            }
        }

    }

    //显示相关内容
    private fun showDiaLogText(goods: GoodsDetails.SkuListBean) {
        ImageLoadUtils.loadImageCenterCrop(this,mIvPic,goods.picture,R.mipmap.ic_launcher)
        mTvMoney?.text = "￥${goods.price}"
        mTvTitle?.text =goods.mecProductName
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun comment(mlist: List<CommentData>?) {
        if (mlist==null|| mlist.isEmpty()){
            ly_comment_info.visibility =View.GONE
        }else{
            ImageLoadUtils.loadImageCenterCrop(this,iv_comment_pic,mlist[0].commentUserHeader,R.mipmap.ic_launcher)
            tv_comment_user_name.text =mlist[0].commentUserName
            tv_buy_info.text ="${mlist[0].mecProductSkuName}"
            tv_comment.text =mlist[0].content
            ratingBar.rating =mlist[0].star

        }

    }

    override fun showData(data: GoodsDetails?) {
        if (data != null) {
            goodDetails =data
            if (!TextUtils.isEmpty(data.img)) {
                for (imgUrl in data.img.split(",")) {
                    var bannerData = BannerData()
                    bannerData.img = imgUrl
                    mList2?.add(bannerData)
                }
                banner.adapter = ImageAdapter(mList2)
                banner.indicator = CircleIndicator(this)
            }

            tv_details_title.text = data.title
            tv_money.text = "￥${data.price}"

            //  tv_sell_num.text="销量：${data.scale}件"

            mSpecLst?.clear()
            mSpecLst?.addAll(data.skuList)

            try {
                if (data.skuItems != null && data.skuItems.size > 0) {

                    for (sku in data.skuItems[0]) {
                        var spec =Spec()
                        spec.specName=sku.split(":")[1]
                        mSpecList1.add(spec)
                        if (TextUtils.isEmpty(speceName1)){
                            speceName1 =sku.split(":")[0]
                        }
                    }

                    for (sku in data.skuItems[1]) {
                        var spec =Spec()
                        spec.specName=sku.split(":")[1]
                        mSpecList2.add(spec)
                        if (TextUtils.isEmpty(speceName2)){
                            speceName2 =sku.split(":")[0]
                        }
                    }
                }

            }catch (e:Exception){

                Log.v("ssss","sss======$e")
            }


            tv_details.text = Html.fromHtml(data.productDetailInfo)

        }

    }

    override fun collectSuccess(netData: NetData?) {
        if (netData is IsCollectBean){
            if (netData.result ==1){
                isCollect =true
                tv_collected.text = "已收藏"
                tv_collected.isSelected = true
            }

        }else{
            if (netData != null && netData.code == 200) {
                if (!isCollect){
                    tv_collected.text = "已收藏"
                    tv_collected.isSelected = true
                }else{
                    tv_collected.text = "收藏"
                    tv_collected.isSelected = false
                }
                isCollect =!isCollect
            }
            ToastUtils.showText(netData?.message)
        }
    }

}