package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.ShopCarAdapter
import com.example.mechanicalapp.ui.adapter.SpecAttrAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.base.WeakHandler
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.ShopCarPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.ImageLoadUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.StringUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_shop_car.*
import kotlinx.android.synthetic.main.layout_title.*
import java.io.Serializable


class ShopCarActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,OnItemClickLevelListener,
    OnItemClickListener,
    NetDataView<NetData> {

    var mList: MutableList<ShopCarData> = ArrayList<ShopCarData>()
    private var mShopCarAdapter: ShopCarAdapter? = null


    private var mSpecsDialog: BottomSheetDialog? = null
    private var mSpecsView: View? = null
    private var mIvPic: ImageView? = null
    private var mTvMoney: TextView? = null
    private var mTvBtn: TextView? = null
    private var mTvTitle: TextView? = null
    private var mIvClose: ImageView? = null
    private var mSpecRecycler: RecyclerView? = null
    private var mSpecAttrAdapter: SpecAttrAdapter? = null
    private var goodsProduct: GoodsProduct? = null
    private var isChange = false
    private var strSpec = ""
   // private var bundleData: SkuListData? = null
    //选择规格属性的时候修改时使用
    private var attrIndex=0


    private var mPresenter: ShopCarPresenter? = null
    private var popInputInfo: EditText? = null
    private var popInputCancel: TextView? = null
    private var popInputSure: TextView? = null
    private var mInputPopwindow: PopupWindow? = null


    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null
    private var popDelIndex = 0

    private var carIndex = 0
    private var isEdit = false//是否在编辑状态
    private var isCheckAll = false//是否已经全选


    private var mSpecList: MutableList<GoodsDetails.SkuNameListBean> =
        ArrayList<GoodsDetails.SkuNameListBean>()
    //skuList
    private var mSkuList: MutableList<SkuListData> =
        ArrayList<SkuListData>()


    private var handler = WeakHandler { msg ->
        when (msg.what) {
            1 -> {editShopCar()}
        }
        false
    }

    private fun editShopCar() {
        mPresenter?.edit(mList[carIndex])
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_shop_car
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_right.visibility = View.VISIBLE
        tv_title.text = "购物车"
        tv_right.setOnClickListener(this)
        tv_check_all.setOnClickListener(this)
        tv_settlement.setOnClickListener(this)

        mShopCarAdapter = ShopCarAdapter(this, mList, this)
        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mShopCarAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as ShopCarPresenter).resetPage()
                (mPresenter as ShopCarPresenter).getCarList()
            }

            override fun onLoadmore() {
                (mPresenter as ShopCarPresenter).getCarList()
            }
        })

    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun initPresenter() {
        mPresenter = ShopCarPresenter(this)
        mPresenter?.getCarList()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun err() {
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.tv_right -> editList()
            R.id.iv_back -> finish()
            R.id.tv_settlement -> buy()
            R.id.tv_pop_input_cancel -> {
                PopUtils.dismissPop(this)
            }
            R.id.tv_pop_input_sure -> changeNum()
            R.id.tv_check_all -> selectCarAll()
            R.id.tv_pop_sure -> delGoods()
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.iv_dialog_close -> mSpecsDialog?.dismiss()
            R.id.tv_dialog_submit -> {
                //编辑后不会立即刷新列表 不考虑信息差的情况
                mPresenter?.edit(mList[attrIndex])
                mSpecsDialog?.dismiss()}
        }

    }


    private fun buy() {

        var bundle = Bundle()

        var mgoList: MutableList<ShopCarData> = ArrayList<ShopCarData>()
        for (data in mList) {
            if (data.isSelect) {
//                var skuBean = SkuBean()
//                skuBean.num = data.quantity
//                var skuList =SkuListData()
//                skuList.price =data.price
//                skuList.picture =data.picture
//                skuList.mecProductName =data.productName
//                skuList.name =data.skuName
//                skuList.id =data.skuId
//                skuBean.skuListData=skuList
                mgoList.add(data)
            }
        }
        bundle.putSerializable("data", mgoList as Serializable)
        jumpActivity(bundle, SureOrderCarActivity::class.java)

    }

    //删除购物车的商品
    private fun delGoods() {
        PopUtils.dismissPop(this)
        mPresenter?.del(mList[popDelIndex].id)
    }


    private fun editList() {
        isEdit = !isEdit
        if (isEdit) {
            tv_right.text = "完成"
        } else {
            tv_right.text = "编辑"
        }
    }

    //修改购物车数量
    private fun changeNum() {
        mList[carIndex].quantity = popInputInfo?.text.toString().toInt()
        PopUtils.dismissPop(this)
        handler.sendEmptyMessageDelayed(1, 300)
    }

    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
            R.id.tv_attr -> getGoodsAttr(position)
            R.id.item_root -> {
                if (isEdit) {
                    showDel(position)
                } else {
                    val bundle = Bundle()
                    bundle.putString(Configs.MEC_ID, mList[position].productId)
                    jumpActivity(bundle,GoodsDetailsActivity::class.java)
                }
            }
            R.id.tv_num -> showPopInput(position)
            R.id.ly_reduce -> reduceNum(position)
            R.id.ly_add -> addNum(position)
            R.id.ly_check -> selectList(position)
        }
    }

    private fun showDel(position: Int) {

        popDelIndex = position
        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
            popInfo?.text = "确认要删除改商品？"
            popCancel?.text = "取消"
            popSure?.text = "确定"
        }

        this?.let { PopUtils.showPopupWindow(tv_right, it) }

    }

    override fun getView(view: View?) {
        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    private fun selectCarAll() {
        for (data in mList) {
            data.isSelect = !isCheckAll
        }
        isCheckAll = !isCheckAll
        mShopCarAdapter?.notifyDataSetChanged()
    }

    private fun selectList(position: Int) {
        isCheckAll = false
        mList[position].isSelect = !mList[position].isSelect
        mShopCarAdapter?.notifyItemChanged(position)

    }

    private fun addNum(position: Int) {
        carIndex = position
        mList[position].quantity += 1
        mShopCarAdapter?.notifyItemChanged(carIndex)
        handler.removeMessages(1)
        handler.sendEmptyMessageDelayed(1, 300)
    }

    private fun reduceNum(position: Int) {
        if (mList[position].quantity > 0) {
            carIndex = position
            mList[position].quantity -= 1
            mShopCarAdapter?.notifyItemChanged(carIndex)
            handler.removeMessages(1)
            handler.sendEmptyMessageDelayed(1, 300)
        }
    }

    private fun getGoodsAttr(position: Int){
        mPresenter?.getGoodsDetails(mList[position].productId)
        attrIndex =position
    }

    private fun showAttrSel() {
        if (mSpecsDialog ==null){
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
        }else{
            mSpecAttrAdapter?.notifyDataSetChanged()
        }
        mSpecsDialog?.show()

    }

    private fun showPopInput(position: Int) {
        carIndex = position
        if (mInputPopwindow == null) {
            mInputPopwindow = this?.let {
                PopUtils.init(this,
                    it, R.layout.pop_input_num,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, object : PopUtils.onViewListener {
                        override fun getView(view: View?) {
                            popInputCancel = view?.findViewById(R.id.tv_pop_input_cancel)
                            popInputSure = view?.findViewById(R.id.tv_pop_input_sure)
                            popInputInfo = view?.findViewById(R.id.tv_pop_input_info)
                            popInputSure?.setOnClickListener(this@ShopCarActivity)
                            popInputCancel?.setOnClickListener(this@ShopCarActivity)
                        }
                    })
            }
        }

        this?.let { PopUtils.showPopupWindow(tv_right, it) }
    }

    override fun refreshUI(data: NetData?) {

        if (data != null && data is ShopCarBean) {

            mList.clear()
            if (data?.result != null && data.result.records != null) {
                tv_title.text = "购物车(${data.result.total})"
                data?.result?.records?.let { mList.addAll(it) }
            }
            mShopCarAdapter?.notifyDataSetChanged()
        }else if (data!=null&&data is GoodsDetailsBean){
            mSpecList.clear()
            mSpecList.addAll(data.result.skuNameList)
            goodsProduct = data.result.product
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
            mSkuList.addAll(data.result.skuList)
            showAttrSel()
        }
        else{
            if (data!=null){
                ToastUtils.showText(data.message)
                if (data.code==200){
                    spring_list.callFresh()
                }
            }
        }
    }

    override fun loadMore(data: NetData?) {
        if (data != null && data is ShopCarBean) {
            if (data?.result != null && data.result.records != null) {
                data?.result?.records?.let { mList.addAll(it) }
                mShopCarAdapter?.notifyDataSetChanged()
            }
        }
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
        Log.v("sss==","ss==========$strSpec")
        strSpec = strSpec.substring(0, strSpec.length - 1)
        for (sku in mSkuList.iterator()) {
            if (strSpec == sku.name) {
                showDiaLogText(sku)
            }
        }


    }
    //显示相关内容
    private fun showDiaLogText(sku: SkuListData) {

        mList[attrIndex].price =sku.price
        mList[attrIndex].skuName =sku.name
        mList[attrIndex].skuId =sku.id
        mList[attrIndex].stock =sku.stock
        mList[attrIndex].productName =sku.mecProductName
        //编辑后不会立即刷新列表 不考虑信息差的情况
        mShopCarAdapter?.notifyItemChanged(attrIndex)

        ImageLoadUtils.loadImageCenterCrop(this, mIvPic, sku.picture, R.mipmap.ic_launcher)
        mTvMoney?.text = "￥${sku.price}"
        mTvTitle?.text = sku.mecProductName
    }
}