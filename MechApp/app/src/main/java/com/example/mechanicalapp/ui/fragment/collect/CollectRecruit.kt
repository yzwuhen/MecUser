package com.example.mechanicalapp.ui.fragment.collect

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.RecruitAdapter
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.java.EventFresh
import kotlinx.android.synthetic.main.layout_spring_list.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CollectRecruit : BaseFragment<NetData>() , OnItemClickListener {


    private var mAdapter: RecruitAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()
    override fun showLoading() {


    }

    init {
        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")
        EventBus.getDefault().register(this)

    }

    override fun initView() {
        super.initView()

        mAdapter = RecruitAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter = mAdapter


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

    override fun showData(t: NetData?) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(view: View, position: Int) {


    }
}