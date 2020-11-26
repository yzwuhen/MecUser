package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.SureOrderCarAdapter
import com.example.mechanicalapp.ui.adapter.SureOrderGoodsAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.*
import com.example.mechanicalapp.ui.mvp.impl.SureOrderPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_sure_order.*
import kotlinx.android.synthetic.main.layout_title.*

class SureOrderCarActivity  : BaseCusActivity(), View.OnClickListener, OnItemClickListener,
    TextWatcher,
    NetDataView<NetData> {

    private var mAdapter: SureOrderCarAdapter? = null
    private var mList: MutableList<ShopCarData> = ArrayList<ShopCarData>()

    private var data: List<ShopCarData>? = null
    private var mPresenter: SureOrderPresenter? = null

    private var price = 0
    private var num = 0

    private var reOrder = ReOrderCar()
    private var skuList = ArrayList<ReOrderItemListCar>()

    override fun getLayoutId(): Int {
        return R.layout.activity_sure_order
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "确认订单"

        ly_address.setOnClickListener(this)
        tv_settlement.setOnClickListener(this)
        tv_freight_rule.setOnClickListener(this)


        data = intent.getSerializableExtra("data") as List<ShopCarData>?
        data?.let { mList.addAll(it) }
        recycler_list.layoutManager = LinearLayoutManager(this)
        mAdapter = SureOrderCarAdapter(this, mList, this)
        recycler_list.adapter = mAdapter

        if (mList != null && mList.size > 0) {

            for (sku in mList) {
                price += sku.price * sku.quantity
                num += sku.quantity
//                var reOrderItemList = ReOrderItemListCar()
//                reOrderItemList.skuId = sku.skuListData.id
//                reOrderItemList.quantity =sku.num
//                skuList.add(reOrderItemList)
            }
        }
        tv_goods_num.text = "共计${num}件商品"
        tv_goods_money.text = "￥$price"

        tv_all_money.text = "合计： ￥$price"


        reOrder.shoppingCardList = mList
        et_remarks.addTextChangedListener(this)

    }

    override fun initPresenter() {
        mPresenter = SureOrderPresenter(this)
        mPresenter?.getAddressList()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.ly_address -> {
                var bundle = Bundle()
                bundle.putInt("type", 1)
                jumpActivityForResult(Configs.ADDRESS_LIST_SELECT_RESULT,1, MyAddressActivity::class.java)
            }
            R.id.ly_add_address -> jumpActivity(null, MyAddressActivity::class.java)
            R.id.tv_settlement -> creatOrder()
            R.id.tv_freight_rule -> jumpActivity(null, FreightRuleActivity::class.java)
        }
    }

    private fun creatOrder() {

        if (TextUtils.isEmpty(reOrder.receiverId)) {
            ToastUtils.showText("请先选择收货人")
            return
        }
        mPresenter?.creatOrderCar(reOrder)

    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun refreshUI(data: NetData?) {
        if (data != null && data is MyAddressBean) {
            if (data.result.records.isEmpty()) {
                ly_add_address.visibility = View.VISIBLE
                ly_address.visibility = View.GONE
            } else {
                ly_add_address.visibility = View.GONE
                ly_address.visibility = View.VISIBLE
                showAddress(data.result.records[0])
            }
        }
        else if (data !=null && data is CreatOrderBean){
            ToastUtils.showText(data.message)
            if (data.code==200){
                jumAct(data.result)
            }

        }
        else {
            ly_add_address.visibility = View.VISIBLE
            ly_address.visibility = View.GONE
        }
    }

    private fun jumAct(result: CreatOrderBean.ResultBean?) {
        var bundle = Bundle()
        bundle.putString("order_num",result?.orderNum)
        result?.amount?.let { bundle.putDouble("order_price", it) }
        jumpActivity(bundle, PayActivity::class.java)
    }

    private fun showAddress(reAddress: ReAddress) {
        tv_user_name.text = reAddress.name
        tv_address.text = "${reAddress.area}${reAddress.adress}"
        tv_user_phone.text = reAddress.phone

        reOrder.receiverId = reAddress.id
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == Configs.ADDRESS_LIST_SELECT_RESULT) {
            showAddress(data?.getSerializableExtra(Configs.SCREEN_RESULT_Extra) as ReAddress)
        }
        super.onActivityResult(requestCode, resultCode, data)

    }


    override fun loadMore(data: NetData?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        addRemark()
    }

    private fun addRemark() {

        reOrder.memo = et_remarks.text.toString()
    }
}