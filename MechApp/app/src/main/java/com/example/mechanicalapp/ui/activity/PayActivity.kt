package com.example.mechanicalapp.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alipay.sdk.app.PayTask
import com.example.mechanicalapp.R
import com.example.mechanicalapp.alipay.AuthResult
import com.example.mechanicalapp.alipay.PayResult
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.OrderPresenter
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
    private var orderType=0;//订单类型  维修单1 普通订单0


    @SuppressLint("HandlerLeak")
    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                Configs.SDK_PAY_FLAG-> {
                    val payResult = PayResult(msg.obj as Map<String?, String?>)
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    val resultInfo: String = payResult.result // 同步返回需要验证的信息
                    val resultStatus: String = payResult.resultStatus

                    var bundle = Bundle()
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        bundle.putInt("type", 0)
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        bundle.putInt("type", 1)
                    }
                    bundle.putInt("order_type", orderType)
                    jumpActivity(bundle, PayResultActivity::class.java)
                    finish()
                }
                Configs.SDK_AUTH_FLAG-> {
                    val authResult = AuthResult(msg.obj as Map<String?, String?>, true)
                    val resultStatus: String = authResult.resultStatus

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(
                            resultStatus,
                            "9000"
                        ) && TextUtils.equals(authResult.resultCode, "200")
                    ) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户

                    } else {
                        // 其他状态值则为授权失败
                    }
                }
                else -> {
                }
            }
        }
    }



    override fun getLayoutId(): Int {
        return R.layout.activity_pay
    }

    override fun initView() {
        super.initView()


        price = intent.getDoubleExtra("order_price",0.0)
        orderNum = intent.getStringExtra("order_num").toString()
        orderId =intent.getStringExtra("order_id").toString()
        createdTime =intent.getStringExtra("created_time").toString()
        orderType =intent.getIntExtra("order_type",0)
        tv_tip_info.text ="￥$price"
        tv_tip_info1.text ="订单号：$orderNum"

        if (orderType==1){
            tv_time_out.visibility =View.GONE

        }else{
            if (createdTime!=null){
                tv_time_out.text="${
                    DateUtils.getHours(
                        createdTime,
                        DateUtils.getDateByLongWithFormat(System.currentTimeMillis(),
                            "yyyy-MM-dd hh:mm:ss"))}小时后关闭订单，请尽快付款"
            }
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
        if (orderType==0){
            mMecAppPresenter?.payWx(orderId)
        }else{
            mMecAppPresenter?.payRepairWx(orderId)
        }
    }

    private fun payAlly() {
        if (orderType==0){
            mMecAppPresenter?.payAlly(orderId)
        }else{
            mMecAppPresenter?.payRepairAlly(orderId)
        }
    }

    override fun refreshUI(data: NetData?) {
        if (data!=null &&data is WxPayBean){
            payToWx(data?.result?.msg)
        }  else if (data is AliPayBean) {
            payToAlly(data?.result)
        }
    }
    private fun payToAlly(msg: String?) {
        var thread =Thread {
            var aliPay = PayTask(this@PayActivity)
            var result =aliPay.payV2(msg, true)
            var msg = Message.obtain()
            msg.what =1
            msg.obj =result
            mHandler.handleMessage(msg)
        }
        thread.start()
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