package com.example.mechanicalapp.ui.activity

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.TextView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.layout_left_right_title.*

class OrderDetailsActivity : BaseActivity<NetData>(), View.OnClickListener,
    PopUtils.onViewListener {

    private var type: Int = 0
    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null


    private var popInputInfo: EditText? = null
    private var popInputCancel: TextView? = null
    private var popInputSure: TextView? = null
    private var mInputPopwindow: PopupWindow? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_order_details
    }

    override fun initView() {
        super.initView()

        iv_right.setImageResource(R.mipmap.share_icon)
        tv_title.text = "订单详情"

        type = intent.getIntExtra("order_type", 0)

        if (type == 1) {
            tv_cancel_order.visibility = View.GONE
            ly_state1.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
        } else if (type == 2) {
            tv_cancel_order.visibility = View.GONE
            ly_state2.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
        } else if (type == 3) {
            tv_cancel_order.visibility = View.GONE
            ly_state3.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
        }
        else if (type == 4) {
            tv_cancel_order.visibility = View.GONE
            ly_state4.visibility = View.VISIBLE
            ly_factory.visibility = View.VISIBLE
        }


        iv_left.setOnClickListener(this)
        ly_right.setOnClickListener(this)
        tv_cancel_order.setOnClickListener(this)
        ly_letter.setOnClickListener(this)
        ly_call.setOnClickListener(this)
        tv_letter.setOnClickListener(this)
        tv_call.setOnClickListener(this)
        ly_evaluate.setOnClickListener(this)
        ly_look_details1.setOnClickListener(this)
        ly_look_details.setOnClickListener(this)
        iv_look.setOnClickListener(this)
        tv_letter1.setOnClickListener(this)
        tv_call1.setOnClickListener(this)
        ly_look_details2.setOnClickListener(this)
        ly_pay.setOnClickListener(this)
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

        when (v?.id) {
            R.id.iv_left -> finish()
            R.id.ly_right -> share()
            R.id.iv_look -> showPop(1)
            R.id.tv_cancel_order -> showPop(0)
            R.id.ly_letter -> goToChat()
            R.id.ly_call -> call()
            R.id.tv_letter -> goToChat()
            R.id.tv_call -> call()
            R.id.ly_look_details -> jumpActivity(null, DetailedListActivity::class.java)
            R.id.ly_look_details1 -> jumpActivity(null, DetailedListActivity::class.java)
            R.id.ly_evaluate -> jumpActivity(null, EvaluateActivity::class.java)
            R.id.tv_pop_sure -> dismiss(0)
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
            R.id.tv_pop_input_cancel -> goVideo()
            R.id.tv_pop_input_sure -> goVideo()
            R.id.ly_look_details2 -> jumpActivity(null, DetailedListActivity::class.java)
//            R.id.ly_pay -> jumpActivity(null, null)
        }
    }

    private fun call() {


    }

    private fun goToChat() {


    }

    private fun goVideo(){
        PopUtils.dismissPop(this)
        jumpActivity(null,VideoListActivity::class.java)
    }

    private fun showPop(i: Int) {

        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
        }
        if (i == 0) {
            popInfo?.text = "确认取消订单吗？"
            popCancel?.text = "取消"
            popSure?.text = "确定"
        } else {
            popInfo?.text = "视频查看是否加密？"
            popCancel?.text = "不加密"
            popSure?.text = "加密"
        }

        this?.let { PopUtils.showPopupWindow(ly_right, it) }

    }

    private fun dismiss(types:Int){
        PopUtils.dismissPop(this)
        showPop()
    }

    private fun showPop() {

        if (mInputPopwindow == null) {
            mInputPopwindow = this?.let {
                PopUtils.init(this,
                    it, R.layout.pop_input,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, object : PopUtils.onViewListener {
                        override fun getView(view: View?) {
                            popInputCancel = view?.findViewById(R.id.tv_pop_input_cancel)
                            popInputSure = view?.findViewById(R.id.tv_pop_input_sure)
                            popInputInfo = view?.findViewById(R.id.tv_pop_input_info)

                            popInputSure?.setOnClickListener(this@OrderDetailsActivity)
                            popInputCancel?.setOnClickListener(this@OrderDetailsActivity)
                        }

                    })
            }
        }

        this?.let { PopUtils.showPopupWindow(ly_right, it) }
    }


    private fun share() {


    }

    override fun getView(view: View?) {


        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)

        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }
}