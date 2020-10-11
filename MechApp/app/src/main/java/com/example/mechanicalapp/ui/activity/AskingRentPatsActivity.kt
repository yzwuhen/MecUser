package com.example.mechanicalapp.ui.activity

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.view.PopUtils
import kotlinx.android.synthetic.main.activity_ask_rent_parts.*
import kotlinx.android.synthetic.main.layout_title.*

class AskingRentPatsActivity : BaseActivity<NetData>(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener {


    private var mStringList: MutableList<String> = ArrayList<String>()
    private var popRecy: RecyclerView? = null
    private var mPopWayAdapter: PopWayAdapter? = null


    override fun getLayoutId(): Int {

        return R.layout.activity_ask_rent_parts
    }

    override fun initView() {
        super.initView()



        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "配件求租"
        tv_way.setOnClickListener(this)
        ly_address.setOnClickListener(this)

        mStringList?.add("元/月")
        mStringList?.add("元/台班")
        mStringList?.add("元/小时")
        mStringList?.add("面议")


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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> finish()
            R.id.tv_way -> showInput()
            R.id.ly_address->jumpActivity(null,AddressSelActivity::class.java)
        }
    }



    private fun showInput() {

        this?.let {
            PopUtils.init(
                it,
                R.layout.pop_way,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, this
            )
        }
        PopUtils.showPopupWindow(tv_way)
    }

    override fun getView(view: View?) {
        popRecy = view?.findViewById(R.id.pop_recycler_list)
        mPopWayAdapter = PopWayAdapter(this, mStringList, this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mPopWayAdapter
    }
}