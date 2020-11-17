package com.example.mechanicalapp.ui.fragment.collect

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PartsAdapter
import com.example.mechanicalapp.ui.base.BaseCusFragment
import com.example.mechanicalapp.ui.base.BaseFragment
import com.example.mechanicalapp.ui.data.MecSellData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.PartsData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import com.example.mechanicalapp.ui.data.java.EventFresh
import com.example.mechanicalapp.ui.mvp.impl.PresenterImpl
import com.example.mechanicalapp.ui.mvp.v.CollectView
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.layout_spring_list.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class CollectPartsLease : BaseCusFragment() , OnItemClickListener,CollectView<PartsData>,View.OnClickListener {


    private var mAdapter: PartsAdapter? = null
    var mList: MutableList<PartsData> = ArrayList<PartsData>()
    private var isCheckAll:Boolean=false
    private var ids:String=""
    init {
        EventBus.getDefault().register(this)

    }

    override fun initView() {
        super.initView()

        mAdapter = PartsAdapter(mContext, mList, this)
        recycler_list.layoutManager = LinearLayoutManager(mContext)
        recycler_list.adapter =mAdapter
        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(mContext)
        spring_list.footer = RefreshHeaderUtils.getFooterView(mContext)

        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable =false
                //  initData()
                (mPresenter as PresenterImpl).getCollectPartsList(1)
            }

            override fun onLoadmore() {
                (mPresenter as PresenterImpl).getCollectPartsListMore(1)
            }
        })
        mPresenter = PresenterImpl(mContext,this)
        (mPresenter as PresenterImpl).getCollectPartsList(1)
        tv_check_all.setOnClickListener(this)
        tv_del.setOnClickListener(this)
    }

    fun closeRefreshView() {
        spring_list.isEnable =true
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
    override fun showLoading() {
        showLoadView()
    }
    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun getLayoutId(): Int {
        return R.layout.layout_spring_list
    }

    override fun err()  {
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.ly_check->selectPosition(position)
            R.id.root_view->clickPosition(position)
        }

    }
    private fun clickPosition(position: Int) {

    }
    private fun selectPosition(position: Int) {
        isCheckAll =false
        mList[position].isSelect = !mList[position].isSelect
        mAdapter?.notifyItemChanged(position)
        tv_check_all.isSelected =isCheckAll

    }


    override fun refreshUI(list: List<PartsData>?) {
        mList.clear()
        if (list != null) {
            mList.addAll(list)
        }
        mAdapter?.notifyDataSetChanged()
    }

    override fun loadMore(list: List<PartsData>?) {
        if (list != null) {
            mList.addAll(list)
            mAdapter?.notifyDataSetChanged()
        }
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.tv_check_all->checkAll()
            R.id.tv_del->delSelect()
        }

    }

    private fun delSelect() {
        for (index in mList.indices){
            if (mList[index].isSelect){
                ids ="$ids,${mList[index].id}"
            }
        }

        (mPresenter as PresenterImpl).del(ids)

    }

    private fun checkAll() {
        isCheckAll =!isCheckAll
        for (index in mList.indices){
            mList[index].isSelect=isCheckAll
        }
        tv_check_all.isSelected =isCheckAll
        mAdapter?.notifyDataSetChanged()
    }

    override fun success(netData: NetData) {
        if (netData.code==200){
            (mPresenter as PresenterImpl).getCollectPartsList(1)
        }
        ToastUtils.showText(netData.message)
    }
}