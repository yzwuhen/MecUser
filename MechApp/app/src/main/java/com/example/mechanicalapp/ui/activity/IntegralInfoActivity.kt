package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.IntegralAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.IntegralData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.mvp.impl.IntegralPresenter
import com.example.mechanicalapp.ui.mvp.v.IntegralView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_integral_info.*
import kotlinx.android.synthetic.main.layout_title.*

class IntegralInfoActivity : BaseCusActivity(), View.OnClickListener, OnItemClickListener,
    IntegralView<List<IntegralData>> {


    private var mIntegralAdapter: IntegralAdapter? = null
    private var mList: MutableList<IntegralData> = ArrayList<IntegralData>()
    private var mPresenter: IntegralPresenter? = null

    override fun getLayoutId(): Int {

        return R.layout.activity_integral_info
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "积分明细"


        mIntegralAdapter = IntegralAdapter(this, mList, this)
        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mIntegralAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as IntegralPresenter).resetPage()
                (mPresenter as IntegralPresenter).getIntegralList()
            }

            override fun onLoadmore() {
                (mPresenter as IntegralPresenter).getIntegralList()
            }
        })

        var points = intent.getIntExtra("key",0)
        tv_integral.text =points.toString()
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun initPresenter() {
        mPresenter = IntegralPresenter(this)
        mPresenter?.getIntegralList()
    }


    override fun onClick(p0: View?) {

        finish()
    }

    override fun onItemClick(view: View, position: Int) {


    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
    }

    override fun err() {
    }

    override fun showData(t: List<IntegralData>?) {
        mList.clear()
        if (t!=null){
            mList.addAll(t)
        }
        mIntegralAdapter?.notifyDataSetChanged()
    }

    override fun showDataMore(t: List<IntegralData>?) {
        if (t!=null){
            mList.addAll(t)
            mIntegralAdapter?.notifyDataSetChanged()
        }
    }

    override fun success(netData: NetData?) {


    }
}