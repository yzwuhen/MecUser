package com.example.mechanicalapp.ui.activity

import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.PageData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import kotlinx.android.synthetic.main.activity_integral_rule.*
import kotlinx.android.synthetic.main.layout_title.*

class IntegralRuleActivity :BaseCusActivity() ,View.OnClickListener,NetDataView<PageData>{
    private lateinit var mecPresenter : MecAppPresenter
    override fun getLayoutId(): Int {
        return R.layout.activity_integral_rule
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "积分规则"
    }

    override fun initPresenter() {
        mecPresenter= MecAppPresenter(this)
        mecPresenter.getPageInfo(7)
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }

    override fun onClick(p0: View?) {

        finish()
    }

    override fun refreshUI(data: PageData?) {
        if (data?.result!=null){
            tv_info.text =data?.result.content
        }
    }

    override fun loadMore(data: PageData?) {
    }
}