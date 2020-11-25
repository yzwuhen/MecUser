package com.example.mechanicalapp.ui.activity

import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.AttrAdapter
import com.example.mechanicalapp.ui.adapter.ShopCarAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.base.WeakHandler
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.ShopCarBean
import com.example.mechanicalapp.ui.data.ShopCarData
import com.example.mechanicalapp.ui.mvp.impl.ShopCarPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.example.mechanicalapp.ui.view.MyDecoration
import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.RefreshHeaderUtils
import com.example.mechanicalapp.utils.ToastUtils
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.liaoinstan.springview.widget.SpringView
import kotlinx.android.synthetic.main.activity_shop_car.*
import kotlinx.android.synthetic.main.layout_title.*


class ShopCarActivity : BaseCusActivity(), View.OnClickListener, PopUtils.onViewListener,
    OnItemClickListener,
    NetDataView<NetData> {

    var mList: MutableList<ShopCarData> = ArrayList<ShopCarData>()
    private var mShopCarAdapter: ShopCarAdapter? = null


    private var mAttrDialog: BottomSheetDialog? = null
    private var mAttrDialogView: View? = null
    private var mRecAttrTypeDialog: RecyclerView? = null
    private var mRecAttrSizeDialog: RecyclerView? = null
    private var mCloseDialog: ImageView? = null
    private var mAttrTypeList: MutableList<String> = ArrayList<String>()
    private var mAttrSzieList: MutableList<String> = ArrayList<String>()

    private var mPresenter: ShopCarPresenter? = null
    private var popInputInfo: EditText? = null
    private var popInputCancel: TextView? = null
    private var popInputSure: TextView? = null
    private var mInputPopwindow: PopupWindow? = null


    private var popInfo: TextView? = null
    private var popCancel: TextView? = null
    private var popSure: TextView? = null
    private var mPopwindow: PopupWindow? = null
    private var popDelIndex = 0

    private var carIndex = 0
    private var isEdit = false//是否在编辑状态
    private var isCheckAll = false//是否已经全选

    private var handler = WeakHandler { msg ->
        when (msg.what) {
            1 -> editShopCar()
        }
        false
    }

    private fun editShopCar() {
        mPresenter?.edit(mList[carIndex])
    }

    override fun getLayoutId(): Int {

        return R.layout.activity_shop_car
    }

    override fun initView() {
        super.initView()
        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_right.visibility = View.VISIBLE
        tv_title.text = "购物车"
        tv_right.setOnClickListener(this)
        tv_check_all.setOnClickListener(this)
        tv_settlement.setOnClickListener(this)

        mShopCarAdapter = ShopCarAdapter(this, mList, this)
        recycle_list.layoutManager = LinearLayoutManager(this)
        recycle_list.adapter = mShopCarAdapter

        spring_list.type = SpringView.Type.FOLLOW
        spring_list.header = RefreshHeaderUtils.getHeaderView(this)
        spring_list.footer = RefreshHeaderUtils.getFooterView(this)
        spring_list.setListener(object : SpringView.OnFreshListener {
            override fun onRefresh() {
                spring_list.isEnable = false
                (mPresenter as ShopCarPresenter).resetPage()
                (mPresenter as ShopCarPresenter).getCarList()
            }

            override fun onLoadmore() {
                (mPresenter as ShopCarPresenter).getCarList()
            }
        })



        mAttrTypeList.add("红色")
        mAttrTypeList.add("黄色")
        mAttrTypeList.add("黑色")
        mAttrTypeList.add("蓝色")

        mAttrSzieList.add("XL")
        mAttrSzieList.add("XXL")
        mAttrSzieList.add("XXXL")
        mAttrSzieList.add("L")
    }

    fun closeRefreshView() {
        spring_list?.isEnable = true
        spring_list?.onFinishFreshAndLoad()
    }

    override fun initPresenter() {
        mPresenter = ShopCarPresenter(this)
        mPresenter?.getCarList()
    }

    override fun showLoading() {
        showLoadView()
    }

    override fun hiedLoading() {
        hideLoadingView()
        closeRefreshView()
    }

    override fun err() {
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.tv_right -> editList()
            R.id.iv_back -> finish()
            R.id.tv_settlement -> buy()
            R.id.tv_pop_input_cancel -> {
                PopUtils.dismissPop(this)
            }
            R.id.tv_pop_input_sure -> changeNum()
            R.id.tv_check_all -> selectCarAll()
            R.id.tv_pop_sure -> delGoods()
            R.id.tv_pop_cancel -> PopUtils.dismissPop(this)
        }

    }


    private fun buy() {

//        var bundle = Bundle()
//
//        var mgoList: MutableList<SkuBean> = ArrayList<SkuBean>()
//        for (data in mList) {
//            if (data.isSelect) {
//                var skuBean = SkuBean()
//                skuBean.num = data.quantity
//              //  skuBean.skuListData = data.productId
//                mgoList.add(skuBean)
//            }
//        }
//        bundle.putSerializable("data", mgoList as Serializable)
//        jumpActivity(bundle, SureOrderActivity::class.java)

    }

    //删除购物车的商品
    private fun delGoods() {
        PopUtils.dismissPop(this)
        mPresenter?.del(mList[popDelIndex].id)
    }


    private fun editList() {
        isEdit = !isEdit
        if (isEdit) {
            tv_right.text = "完成"
        } else {
            tv_right.text = "编辑"
        }
    }

    //修改购物车数量
    private fun changeNum() {
        mList[carIndex].quantity = popInputInfo?.text.toString().toInt()
        PopUtils.dismissPop(this)
        handler.sendEmptyMessageDelayed(1, 300)
    }

    override fun onItemClick(view: View, position: Int) {

        when (view?.id) {
            R.id.tv_attr -> showAttrSel()
            R.id.item_root -> {
                if (isEdit) {
                    showDel(position)
                } else {
                    jumpActivity(null, GoodsDetailsActivity::class.java)
                }
            }
            R.id.tv_num -> showPopInput(position)
            R.id.ly_reduce -> reduceNum(position)
            R.id.ly_add -> addNum(position)
            R.id.ly_check -> selectList(position)
        }
    }

    private fun showDel(position: Int) {

        popDelIndex = position
        if (mPopwindow == null) {
            mPopwindow = this?.let {
                PopUtils.init(
                    this,
                    it, R.layout.pop_del_mec,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, this
                )
            }
            popInfo?.text = "确认要删除改商品？"
            popCancel?.text = "取消"
            popSure?.text = "确定"
        }

        this?.let { PopUtils.showPopupWindow(tv_right, it) }

    }

    override fun getView(view: View?) {
        popCancel = view?.findViewById(R.id.tv_pop_cancel)
        popSure = view?.findViewById(R.id.tv_pop_sure)
        popInfo = view?.findViewById(R.id.tv_pop_info)
        popCancel?.setOnClickListener(this)
        popSure?.setOnClickListener(this)
    }

    private fun selectCarAll() {
        for (data in mList) {
            data.isSelect = !isCheckAll
        }
        isCheckAll = !isCheckAll
        mShopCarAdapter?.notifyDataSetChanged()
    }

    private fun selectList(position: Int) {
        isCheckAll = false
        mList[position].isSelect = !mList[position].isSelect
        mShopCarAdapter?.notifyItemChanged(position)

    }

    private fun addNum(position: Int) {
        carIndex = position
        mList[position].quantity += 1
        mShopCarAdapter?.notifyItemChanged(carIndex)
        handler.removeMessages(1)
        handler.sendEmptyMessageDelayed(1, 300)
    }

    private fun reduceNum(position: Int) {
        if (mList[position].quantity > 0) {
            carIndex = position
            mList[position].quantity -= 1
            mShopCarAdapter?.notifyItemChanged(carIndex)
            handler.removeMessages(1)
            handler.sendEmptyMessageDelayed(1, 300)
        }
    }

    private fun showAttrSel() {
        mAttrDialog = BottomSheetDialog(this)

        mAttrDialogView = View.inflate(this, R.layout.dialog_attr, null)
        mAttrDialog?.setContentView(mAttrDialogView!!)
        mRecAttrTypeDialog = mAttrDialogView?.findViewById(R.id.recycle_type)

        mRecAttrTypeDialog?.layoutManager = GridLayoutManager(this, 4)
        mRecAttrTypeDialog?.addItemDecoration(MyDecoration(4))
        mRecAttrTypeDialog?.adapter =
            AttrAdapter(this, mAttrTypeList, object : OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {

                }

            })


        mRecAttrSizeDialog = mAttrDialogView?.findViewById(R.id.recycle_size)

        mRecAttrSizeDialog?.layoutManager = GridLayoutManager(this, 4)
        mRecAttrSizeDialog?.addItemDecoration(MyDecoration(4))
        mRecAttrSizeDialog?.adapter =
            AttrAdapter(this, mAttrSzieList, object : OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {

                }

            })

        mCloseDialog = mAttrDialogView?.findViewById(R.id.iv_close)
        mCloseDialog?.setOnClickListener(View.OnClickListener { mAttrDialog?.dismiss() })
        mAttrDialog?.show()

    }

    private fun showPopInput(position: Int) {
        carIndex = position
        if (mInputPopwindow == null) {
            mInputPopwindow = this?.let {
                PopUtils.init(this,
                    it, R.layout.pop_input_num,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT, true, object : PopUtils.onViewListener {
                        override fun getView(view: View?) {
                            popInputCancel = view?.findViewById(R.id.tv_pop_input_cancel)
                            popInputSure = view?.findViewById(R.id.tv_pop_input_sure)
                            popInputInfo = view?.findViewById(R.id.tv_pop_input_info)
                            popInputSure?.setOnClickListener(this@ShopCarActivity)
                            popInputCancel?.setOnClickListener(this@ShopCarActivity)
                        }
                    })
            }
        }

        this?.let { PopUtils.showPopupWindow(tv_right, it) }
    }

    override fun refreshUI(data: NetData?) {

        if (data != null && data is ShopCarBean) {

            mList.clear()
            if (data?.result != null && data.result.records != null) {
                tv_title.text = "购物车(${data.result.total})"
                data?.result?.records?.let { mList.addAll(it) }
            }
            mShopCarAdapter?.notifyDataSetChanged()
        }else{
            if (data!=null){
                ToastUtils.showText(data.message)
                if (data.code==200){
                    spring_list.callFresh()
                }
            }
        }
    }

    override fun loadMore(data: NetData?) {
        if (data != null && data is ShopCarBean) {
            if (data?.result != null && data.result.records != null) {
                data?.result?.records?.let { mList.addAll(it) }
                mShopCarAdapter?.notifyDataSetChanged()
            }
        }
    }
}