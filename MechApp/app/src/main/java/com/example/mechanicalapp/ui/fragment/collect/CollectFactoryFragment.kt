package com.example.mechanicalapp.ui.fragment.collect

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MecFactoryAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.FactoryData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.java.EventFresh
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CollectFactoryFragment : BaseFragment<NetData>() , OnItemClickListener {


    private var mAdapter: MecFactoryAdapter? = null
    private var mList: MutableList<FactoryData> = ArrayList<FactoryData>()
    override fun showLoading() {


    }
    init {

        EventBus.getDefault().register(this)

    }

    override fun initView() {
        super.initView()

        mAdapter = MecFactoryAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter =mAdapter

        spring_list.setType(SpringView.Type.FOLLOW)
        spring_list.setHeader(RefreshHeaderUtils.getHeaderView(mContext))

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onFresh(msg: EventFresh) {

        mAdapter?.showCheck(msg.isShowCheck)
        mAdapter?.notifyDataSetChanged()

        if (msg.isShowCheck){
            fl_bottom.visibility = View.VISIBLE
        }else{
            fl_bottom.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this);
    }


    override fun hiedLoading() {
        TODO("Not yet implemented")
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun err()  {
        TODO("Not yet implemented")
    }

    override fun onItemClick(view: View, position: Int) {


    }
}