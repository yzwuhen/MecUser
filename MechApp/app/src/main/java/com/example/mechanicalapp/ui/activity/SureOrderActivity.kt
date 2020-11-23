package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.SureOrderGoodsAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.GoodsDetails
import com.example.mechanicalapp.ui.data.MyAddressBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReAddress
import com.example.mechanicalapp.ui.mvp.impl.SureOrderPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import kotlinx.android.synthetic.main.activity_sure_order.*
import kotlinx.android.synthetic.main.activity_sure_order.recycler_list
import kotlinx.android.synthetic.main.layout_title.*

class SureOrderActivity:BaseCusActivity(),View.OnClickListener,OnItemClickListener ,NetDataView<NetData>{

    private var mAdapter:SureOrderGoodsAdapter?=null
    private var mList:MutableList<GoodsDetails.SkuListBean> =ArrayList<GoodsDetails.SkuListBean>()

    private var data:GoodsDetails.SkuListBean?=null
    private var mPresenter:SureOrderPresenter?=null

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


        data = intent.getSerializableExtra("data") as GoodsDetails.SkuListBean?
        data?.let { mList.add(it) }

        recycler_list.layoutManager = LinearLayoutManager(this)
        mAdapter = SureOrderGoodsAdapter(this,mList,this)
        recycler_list.adapter = mAdapter
    }

    override fun initPresenter() {
        mPresenter = SureOrderPresenter(this)
        mPresenter?.getAddressList()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back->finish()
            R.id.ly_address->jumpActivity(null,MyAddressActivity::class.java)
            R.id.ly_add_address->jumpActivity(null,MyAddressActivity::class.java)
            R.id.tv_settlement->jumpActivity(null,PayActivity::class.java)
            R.id.tv_freight_rule->jumpActivity(null,FreightRuleActivity::class.java)
        }
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun refreshUI(data: NetData?) {
            if (data != null && data is MyAddressBean) {
                if (data.result.records.isEmpty()){
                    ly_add_address.visibility =View.VISIBLE
                    ly_address.visibility =View.GONE
                }else{
                    ly_add_address.visibility =View.GONE
                    ly_address.visibility =View.VISIBLE
                    showAddress(data.result.records[0])
                }
            }else{
               ly_add_address.visibility =View.VISIBLE
                ly_address.visibility =View.GONE
            }
    }

    private fun showAddress(reAddress: ReAddress) {
        tv_user_name.text =reAddress.name
        tv_address.text = "${reAddress.area}${reAddress.adress}"
        tv_user_phone.text =reAddress.phone
    }

    override fun loadMore(data: NetData?) {
    }
}