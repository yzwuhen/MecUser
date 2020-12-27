package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PayData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.WxPayBean
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.DateUtils
import com.tencent.mm.opensdk.modelpay.PayReq
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import kotlinx.android.synthetic.main.activity_pay.*
import kotlinx.android.synthetic.main.layout_title.*

class PayActivity:BaseCusActivity() ,View.OnClickListener,OnItemClickListener,NetDataView<NetData>{
    private var mAdapter:PayAdapter?=null
    private var mList:MutableList<PayData> =ArrayList<PayData>()

    private var mMecAppPresenter :MecAppPresenter?=null
    private var price=0.0
    private var  orderNum=""
    private var orderId=""
    private var createdTime=""
    private var type=0
    private var api:IWXAPI?=null
    override fun getLayoutId(): Int {
        return R.layout.activity_pay
    }

    override fun initView() {
        super.initView()


        price = intent.getDoubleExtra("order_price",0.0)
        orderNum = intent.getStringExtra("order_num").toString()
        orderId =intent.getStringExtra("order_id").toString()
        createdTime =intent.getStringExtra("created_time").toString()

        tv_tip_info.text ="￥$price"
        tv_tip_info1.text ="订单号：$orderNum"

        if (createdTime!=null){
            tv_time_out.text="${
                DateUtils.getHours(
                    createdTime,
                    DateUtils.getDateByLongWithFormat(System.currentTimeMillis(), 
                    "yyyy-MM-dd hh:mm:ss"))}小时后关闭订单，请尽快付款"
        }

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_pay.setOnClickListener(this)
        tv_title.text ="支付订单"

        val payData=PayData()
        payData.mIcon=R.mipmap.zfb
        payData.mText="支付宝"
        payData.isCheck =true
        val payData1=PayData()
        payData1.mIcon=R.mipmap.wxzf
        payData1.mText="微信支付"
        val payData2=PayData()
        payData2.mIcon=R.mipmap.yl
        payData2.mText="银联支付"
//        val payData3=PayData()
//        payData3.mIcon=R.mipmap.xxzf
//        payData3.mText="线下支付"

        mList.add(payData)
        mList.add(payData1)
        mList.add(payData2)
//        mList.add(payData3)

        mAdapter = PayAdapter(this,mList,this)
        recycle_list.layoutManager =LinearLayoutManager(this)
        recycle_list.adapter = mAdapter

        api =WXAPIFactory.createWXAPI(this,Configs.WX_APP_ID)
    }

    override fun initPresenter() {
        mMecAppPresenter = MecAppPresenter(this)

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
            R.id.tv_pay->payWay()
        }
    }

    override fun onItemClick(view: View, position: Int) {
        type =position
        for (index in mList.indices){
            mList[index].isCheck = index ==position
        }
      mAdapter?.notifyDataSetChanged()

    }
    private fun payWay(){
        when(type){
            0->payAlly()
            1->payWx()
        }
    }

    private fun payWx() {

        mMecAppPresenter?.payWx(orderId)
    }

    private fun payAlly() {


    }

    override fun refreshUI(data: NetData?) {
        if (data!=null &&data is WxPayBean){
            payToWx(data?.result?.msg)
        }
    }

    private fun payToWx(msg: WxPayBean.ResultBean.MsgBean?) {


        var request= PayReq();
        request.appId = msg?.appid;
        request.partnerId = msg?.partnerid;
        request.prepayId= msg?.prepayid;
        request.packageValue = msg?.packageX;
        request.nonceStr= msg?.noncestr;
        request.timeStamp= msg?.timestamp;
        request.sign= msg?.sign;
        api?.sendReq(request);

    }

    override fun loadMore(data: NetData?) {
    }
}