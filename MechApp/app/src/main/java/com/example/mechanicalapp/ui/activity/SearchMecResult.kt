package com.example.mechanicalapp.ui.activity

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.MyMecAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.StoreLeftBean
import kotlinx.android.synthetic.main.activity_search_goods_result.*
import kotlinx.android.synthetic.main.activity_search_result.recycler_list
import kotlinx.android.synthetic.main.layout_search_et.*

class SearchMecResult: BaseActivity<NetData>(), OnItemClickListener {

    //tye== 0 出租出售 1 招牌  2 求职 3 商品（配件）
    private var myMecAdapter: MyMecAdapter? = null
    var mList: MutableList<String> = ArrayList<String>()

    private var type: Int = 0;
    override fun getLayoutId(): Int {
        return R.layout.activity_search_goods_result
    }

    override fun initView() {
        super.initView()

        type = intent.getIntExtra(Configs.SEARCH_RESULT_TYPE, 0)

        mList.add("1")
        mList.add("1")
        mList.add("1")
        mList.add("1")

        tv_list_count.visibility = View.GONE
        recycler_list.layoutManager = GridLayoutManager(this, 3)
        myMecAdapter = MyMecAdapter(this, mList, this)
        recycler_list.addItemDecoration(MyDecoration(3))
        recycler_list.adapter = myMecAdapter

        iv_back.setOnClickListener(View.OnClickListener { finish() })
    }

    override fun initPresenter() {

    }

    override fun showLoading() {

    }

    override fun hiedLoading() {

    }

    override fun err()  {

    }


    override fun onItemClick(view: View, position: Int) {


    }

}