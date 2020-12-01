package com.example.mechanicalapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MyMecAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.impl.MyMecPresenter
import com.example.mechanicalapp.ui.mvp.v.CollectView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_my_mec.*
import kotlinx.android.synthetic.main.activity_my_mec.recycler_list
import kotlinx.android.synthetic.main.activity_my_mec.spring_list
import kotlinx.android.synthetic.main.layout_title.*

class MyMecListActivity : BaseCusActivity(),OnItemClickListener ,View.OnClickListener, CollectView<MecData> {


    private var mMyMecAdapter: MyMecAdapter? = null

     private var mList: MutableList<MecData> = ArrayList<MecData>()

    private var mPresenter: MyMecPresenter?=null
    override fun getLayoutId(): Int {

        return R.layout.activity_my_mec
    }

    override fun initView() {
        super.initView()

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "我的设备列表"

        recycler_list.layoutManager = GridLayoutManager(this, 3)
        mMyMecAdapter = MyMecAdapter(this, mList, this)
        //recycler_list.addItemDecoration(MyDecoration(3))
        recycler_list.adapter = mMyMecAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
     // spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                mPresenter?.reset()
                mPresenter?.getMecList()
            }

            override fun onLoadmore() {
                mPresenter?.getMecList()
            }
        })


        ly_search.setOnClickListener(this)
        tv_add_mec.setOnClickListener(this)
    }

    override fun initPresenter() {
        mPresenter = MyMecPresenter(this)
        mPresenter?.getMecList()
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun success(netData: NetData) {
    }


    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }


    override fun err()  {
    }

    override fun onItemClick(view: View, position: Int) {

        var  bundle =Bundle()
        bundle.putString("id",mList[position].id)
        jumpActivity(bundle,MyMecDetailsActivity::class.java)
    }

    private fun jump() {

        var bundle = Bundle()
        bundle.putInt(Configs.HISTORY_TYPE,7)
        jumpActivity(bundle, HistorySearchActivity::class.java)
    }

    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.iv_back->finish()
            R.id.ly_search->jump()
            R.id.tv_add_mec->jumpActivity(null,AddMecActivity::class.java)
        }
    }

    override fun refreshUI(list: List<MecData>?) {
        mList.clear()
        if (list != null) {
            mList.addAll(list)
        }
        mMyMecAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<MecData>?) {
        if (list != null) {
            mList.addAll(list)
            mMyMecAdapter?.notifyDataSetChanged()
        }
    }
}