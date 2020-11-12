package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.PicAdapter
import com.example.mechanicalapp.ui.adapter.PopWayAdapter
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.RePartsLease
import com.example.mechanicalapp.ui.mvp.impl.AddMecManagePresenterImpl

import com.example.mechanicalapp.ui.view.PopUtils
import com.example.mechanicalapp.utils.GlideEngine
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.listener.OnResultCallbackListener
import kotlinx.android.synthetic.main.activity_ec_sell.*
import kotlinx.android.synthetic.main.activity_parts_rental.*
import kotlinx.android.synthetic.main.activity_parts_rental.et_ec_brand
import kotlinx.android.synthetic.main.activity_parts_rental.et_ec_model
import kotlinx.android.synthetic.main.activity_parts_rental.et_ec_type
import kotlinx.android.synthetic.main.activity_parts_rental.ly_address
import kotlinx.android.synthetic.main.activity_parts_rental.ly_ec_brand
import kotlinx.android.synthetic.main.activity_parts_rental.ly_ec_model
import kotlinx.android.synthetic.main.activity_parts_rental.ly_ec_type
import kotlinx.android.synthetic.main.activity_parts_rental.ry_pic
import kotlinx.android.synthetic.main.layout_title.*

class PartsRentalActivity : BaseActivity<NetData>(), OnItemClickListener, View.OnClickListener,
    PopUtils.onViewListener {

    private var mPicAdapter : PicAdapter?=null

    private var mPicList :MutableList<String> ?=null

    private var mStringList :MutableList<String> = ArrayList<String>()
    private var popRecy : RecyclerView?=null
    private var mPopWayAdapter : PopWayAdapter?=null

    private var mButtDialog: BottomSheetDialog? = null

    private var mDialogView: View? = null
    private var mDialogTv1: TextView? = null
    private var mDialogTv2: TextView? = null
    private var mDialogTv3: TextView? = null

    private var mPresenter: AddMecManagePresenterImpl?=null

    private var mRePartsLease =RePartsLease()

    override fun getLayoutId(): Int {

        return R.layout.activity_parts_rental
    }

    override fun initView() {
        super.initView()

        mPicList = ArrayList<String>()
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicList?.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1600716333897&di=963fb5b0077fce243ce0cbf1d70b44cf&imgtype=0&src=http%3A%2F%2Ft8.baidu.com%2Fit%2Fu%3D3571592872%2C3353494284%26fm%3D79%26app%3D86%26f%3DJPEG%3Fw%3D1200%26h%3D1290")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)
        ry_pic.layoutManager = GridLayoutManager(this,3)
        ry_pic.adapter = mPicAdapter

        rl_title.setBackgroundColor(resources.getColor(R.color.color_ffb923))
        iv_back.setOnClickListener(this)
        tv_title.text ="配件出租"
        tv_no_element.setOnClickListener(this)
        ly_ec_type.setOnClickListener(this)
        ly_ec_brand.setOnClickListener(this)
        ly_ec_model.setOnClickListener(this)
        ly_address.setOnClickListener(this)
        mStringList?.add("元/月")
        mStringList?.add("元/台班")
        mStringList?.add("元/小时")
        mStringList?.add("面议")
        mPicAdapter = PicAdapter(this, mPicList as ArrayList<String>,this)



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
        when(view?.id){
            R.id.tv_screen->{
            //    tv_way?.text = mStringList[position]
                PopUtils.dismissPop()
            }
            R.id.iv_del->{
                mPicList?.removeAt(position)
                mPicAdapter?.notifyDataSetChanged()
            }
            R.id.iv_pic->{
                if (position==mPicList?.size){
                    showDialogType()
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_no_element->showInput()
//            R.id.ly_ec_type -> jumpActivityForResult(
//                Configs.EC_TYPE_RESULT_CODE,
//                1,
//                EcType::class.java
//            )
//            R.id.ly_ec_brand -> jumpActivityForResult(
//                Configs.EC_BRAND_RESULT_CODE,
//                1,
//                Brand::class.java
//            )
//            R.id.ly_ec_model -> jumpActivityForResult(
//                Configs.EC_MODEL_RESULT_CODE,
//                1,
//                PartsModel::class.java
//            )
            R.id.ly_address -> jumpActivityForResult(
                Configs.ADDRESS_RESULT_CODE,
                1,
                AddressSelActivity::class.java
            )
            R.id.ly_address -> jumpActivity(null, AddressSelActivity::class.java)
            R.id.tv_dialog_item1 -> setItem()
            R.id.tv_dialog_item2 -> setItem1()
            R.id.tv_dialog_item3 -> mButtDialog?.dismiss()
        }
    }



    private fun showInput() {

        this?.let { PopUtils.init(it,
            R.layout.pop_way,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, this) }
        PopUtils.showPopupWindow(tv_no_element)
    }


    override fun getView(view: View?) {
        popRecy =view?.findViewById(R.id.pop_recycler_list)
        mPopWayAdapter = PopWayAdapter(this,mStringList,this)
        popRecy?.layoutManager = LinearLayoutManager(this)
        popRecy?.adapter = mPopWayAdapter
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        showResult(
            requestCode,
            data?.getStringExtra(Configs.SCREEN_RESULT_Extra),
            data?.getStringExtra(Configs.SCREEN_RESULT_ID)
        )
        super.onActivityResult(requestCode, resultCode, data)

    }

    private fun showResult(requestCode: Int, extra: String?, extraId: String?) {
        if (extra.isNullOrEmpty()){
            return
        }
        when (requestCode) {
            Configs.EC_TYPE_RESULT_CODE -> {
                et_ec_type.text = extra
                mRePartsLease.partsType = extra
              //  mRePartsLease.cateId = extraId
            }
            Configs.EC_BRAND_RESULT_CODE -> {
                et_ec_brand.text = extra
                mRePartsLease.brand = extra
               // mRePartsLease.brandId = extraId
            }
            Configs.EC_MODEL_RESULT_CODE -> {
                et_ec_model.text = extra
           //     mRePartsLease.modelName = extra
             //   mRePartsLease.modelId = extraId
            }
            Configs.ADDRESS_RESULT_CODE -> {
                et_address.text = extra
                mRePartsLease.city = extra
            }
        }

    }
    private fun setItem1() {
        mButtDialog?.dismiss()
        verifyStoragePermissions(this)
    }

    private fun setItem() {
        mButtDialog?.dismiss()
        verifyStoragePermissions(this)
    }

    private fun takePicture() {
        mButtDialog?.dismiss()
        PictureSelector.create(this)
            .openGallery(PictureMimeType.ofAll())
            .imageEngine(GlideEngine.createGlideEngine())
            .forResult(object : OnResultCallbackListener<LocalMedia?> {
                override fun onResult(result: List<LocalMedia?>) {
                    // 结果回调
                    //  imgUrl = result[0]?.path.toString()
                    mPicList?.add(result[0]?.path.toString())
                    mPicAdapter?.notifyDataSetChanged()
//                    ImageLoadUtils.loadImage(
//                        App.getInstance().applicationContext,
//                        iv_user_pic,
//                        result[0]?.path,
//                        R.mipmap.user_default
//                    )
                }

                override fun onCancel() {
                    // 取消
                }
            })
    }

    override fun hasPermissions() {
        super.hasPermissions()
        takePicture()
    }

    private fun showDialogType() {
        if (mButtDialog == null) {
            mButtDialog = BottomSheetDialog(this)
            mDialogView = View.inflate(this, R.layout.dialog_user_data_buttom, null)
            mButtDialog?.setContentView(mDialogView!!)
            mDialogTv1 = mDialogView?.findViewById(R.id.tv_dialog_item1)
            mDialogTv2 = mDialogView?.findViewById(R.id.tv_dialog_item2)
            mDialogTv3 = mDialogView?.findViewById(R.id.tv_dialog_item3)
        }
        mDialogTv1?.setOnClickListener(this)
        mDialogTv2?.setOnClickListener(this)
        mDialogTv3?.setOnClickListener(this)

        mButtDialog?.show()
    }
}