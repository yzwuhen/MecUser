package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.*
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_search_result.*
import kotlinx.android.synthetic.main.layout_search_et.*

class SearchResultActivity:BaseActivity<NetData>() , OnItemClickListener {

    //tye== 0 出租出售 1 招聘  2 求职 3 商品（配件） 4 配件求租 5 配件出租  6是我的设备
    private var mAdapter :UserDemandAdapter ?=null
    private var mRecruitAdapter : RecruitAdapter?=null
    private var mJobWantAdapter : JobWantAdapter?=null
    private var mPartsAdapter :PartsAdapter?=null
    private var mPartsAskAdapter :PartsAskAdapter?=null

    private var mOrderAdapter:OrderAdapter?=null
    private var mEngineerAdapter:SearchResultEngineer?=null

    private var mMoreFactoryActivity:SearchResultFactoryAdapter?=null
    var mList: MutableList<String> = ArrayList<String>()

    private var type:Int =0;
    override fun getLayoutId(): Int {
        return R.layout.activity_search_result
    }

    override fun initView() {
        super.initView()

        type = intent.getIntExtra(Configs.SEARCH_RESULT_TYPE,0)

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        recycler_list.layoutManager = LinearLayoutManager(this)

        if (type ==0){
            mAdapter = UserDemandAdapter(this, mList, 1,this)
            recycler_list.adapter = mAdapter
        }
        else if (type ==1){
            mRecruitAdapter = RecruitAdapter(this, mList, this)
            recycler_list.adapter = mRecruitAdapter
        }
        else if (type ==2){
            mJobWantAdapter = JobWantAdapter(this, mList, this)
            recycler_list.adapter = mJobWantAdapter
        }
        else if (type ==5){
            mPartsAdapter = PartsAdapter(this, mList, this)
            recycler_list.adapter = mPartsAdapter
        }

        else if (type ==4){
            mPartsAskAdapter = PartsAskAdapter(this, mList, this)
            recycler_list.adapter = mPartsAskAdapter
        }

        else if (type ==7){
            mOrderAdapter = OrderAdapter(this, mList, this)
            recycler_list.adapter = mOrderAdapter
        }
        else if (type ==8){
            mEngineerAdapter = SearchResultEngineer(this, mList, this)
            recycler_list.adapter = mEngineerAdapter
        }

        else if (type ==10){
            mMoreFactoryActivity = SearchResultFactoryAdapter(this, mList, this)
            recycler_list.adapter = mMoreFactoryActivity
        }


        iv_back.setOnClickListener(View.OnClickListener { finish() })

        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(this))

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.setEnable(false)
                //  initData()
                closeRefreshView()
            }

            override fun onLoadmore() {}
        })

    }

    fun closeRefreshView() {
        spring_list.setEnable(true)
        spring_list.onFinishFreshAndLoad()
    }


    override fun initPresenter() {

    }

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun showData(t: NetData) {

    }



    override fun onItemClick(view: View, position: Int) {


    }
}