package com.example.mechanicalapp.ui.fragment.user

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.UserRentAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.data.MecLeaseData
import com.example.mechanicalapp.ui.data.UserInfoBean
import com.example.mechanicalapp.ui.mvp.impl.UserInfoThreePresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_list.*

/**
 * 个人 求租
 */
class UserMecRentFragment (private var user: String,var  type: Int) : BaseCusFragment(),
    OnItemClickListener, NetDataView<UserInfoBean> {


    private var mAdapter: UserRentAdapter? = null
    private var mLeaseList: MutableList<MecLeaseData> = ArrayList<MecLeaseData>()


    override fun initView() {
        super.initView()
        mAdapter = UserRentAdapter(mContext, mLeaseList,  this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as UserInfoThreePresenter).getUserLease(user,type)
            }

            override fun onLoadmore() {
                //  (mPresenter as UserInfoPresenter).getUserLease(user,type)
            }
        })

        mPresenter = UserInfoThreePresenter(this)
        (mPresenter as UserInfoThreePresenter).getUserLease(user,type)
    }

    fun closeRefreshView() {
        spring_list.isEnable = true
        spring_list.onFinishFreshAndLoad()
    }


    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_list
    }

    override fun err() {
    }

    override fun onItemClick(view: View, position: Int) {

    }
    override fun refreshUI(data: UserInfoBean?) {
        mLeaseList.clear()
        if (data!=null&&data.result!=null&&data.result.mecMarketMechanics!=null&&data.result.mecMarketMechanics.size>0){
            for (mec in data.result.mecMarketMechanics){
                if (mec.bussiessType=="2"){
                    mLeaseList.add(mec)
                }
            }
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(data: UserInfoBean?) {

    }


}