package com.example.mechanicalapp.ui.activity

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktapp.views.MyDecoration
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.AttrAdapter
import com.example.mechanicalapp.ui.adapter.ShopCarAdapter
import com.example.mechanicalapp.ui.adapter.YearsAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_shop_car.*
import kotlinx.android.synthetic.main.layout_title.*

class ShopCarActivity: BaseActivity<NetData>() ,View.OnClickListener,OnItemClickListener{

    var mList: MutableList<String> = ArrayList<String>()
    private var mShopCarAdapter: ShopCarAdapter? = null


    private var mAttrDialog: BottomSheetDialog? = null
    private var mAttrDialogView: View? = null
    private var mRecAttrTypeDialog: RecyclerView? = null
    private var mRecAttrSizeDialog: RecyclerView? = null
    private var mCloseDialog:ImageView ?=null
    private var mAttrTypeList: MutableList<String> = ArrayList<String>()
    private var mAttrSzieList: MutableList<String> = ArrayList<String>()
    override fun getLayoutId(): Int {

        return R.layout.activity_shop_car
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text = "购物车（0）"


        mList.add("所有类型")
        mList.add("挖掘机")
        mList.add("推土机")
        mList.add("旋挖机")
        mList.add("汽车吊")
        mList.add("泵车")
        mList.add("装载机")

        mShopCarAdapter = ShopCarAdapter(this, mList, this)
        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mShopCarAdapter


        mAttrTypeList.add("红色")
        mAttrTypeList.add("黄色")
        mAttrTypeList.add("黑色")
        mAttrTypeList.add("蓝色")

        mAttrSzieList.add("XL")
        mAttrSzieList.add("XXL")
        mAttrSzieList.add("XXXL")
        mAttrSzieList.add("L")
    }

    override fun initPresenter() {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun showData(t: NetData) {
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.iv_back->finish()
        }


    }

    override fun onItemClick(view: View, position: Int) {


        when(view?.id){
            R.id.tv_attr->showAttrSel()
        }
    }

    private fun showAttrSel() {
        mAttrDialog = BottomSheetDialog(this)

        mAttrDialogView = View.inflate(this, R.layout.dialog_attr, null)
        mAttrDialog?.setContentView(mAttrDialogView!!)
        mRecAttrTypeDialog = mAttrDialogView?.findViewById(R.id.recycle_type)

        mRecAttrTypeDialog?.layoutManager = GridLayoutManager(this, 4)
        mRecAttrTypeDialog?.addItemDecoration(MyDecoration(4))
        mRecAttrTypeDialog?.adapter = AttrAdapter(this, mAttrTypeList, object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

            }

        })


        mRecAttrSizeDialog = mAttrDialogView?.findViewById(R.id.recycle_size)

        mRecAttrSizeDialog?.layoutManager = GridLayoutManager(this, 4)
        mRecAttrSizeDialog?.addItemDecoration(MyDecoration(4))
        mRecAttrSizeDialog?.adapter = AttrAdapter(this, mAttrSzieList, object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

            }

        })

        mCloseDialog = mAttrDialogView?.findViewById(R.id.iv_close)
        mCloseDialog?.setOnClickListener(View.OnClickListener { mAttrDialog?.dismiss() })
        mAttrDialog?.show()

    }
}