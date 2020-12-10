package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.*
import com.example.mechanicalapp.ui.base.BaseActivity
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.mvp.impl.MoreTypePresenter
import com.example.mechanicalapp.ui.mvp.v.TypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*
import java.lang.Exception

class MoreSelPartsType : BaseCusActivity(), OnItemClickListener, View.OnClickListener,OnItemClickLevelListener,
    TypeView<MecTypeBean> {


    private var mLeftAdapter: TypeLeftAdapter? = null
    private var mRightAdapter: TypePartsRightAdapter? = null
    var mLeftList: MutableList<MecTypeData> = ArrayList<MecTypeData>()
    var mRightList: MutableList<MecTypeData> = ArrayList<MecTypeData>()
    private var callbackkStr:String=""
    private var mMoreTypePresenter: MoreTypePresenter?=null

    private var leftIndex:Int=0
    private var rightIndex:Int=0
    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }

    override fun initView() {
        super.initView()

        tv_title.text="配件类型"
        tv_right.text="完成"
        tv_right.visibility = View.VISIBLE

        tv_unlimited.visibility =View.GONE

        mLeftAdapter = TypeLeftAdapter(this, mLeftList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter

        mRightAdapter = TypePartsRightAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = LinearLayoutManager(this)
        recycler_list_right.adapter = mRightAdapter


        iv_back.setOnClickListener(this)
        tv_right.setOnClickListener(this)

        recycler_list_right.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState==0){
                    selectLeft(rightIndex,false)
                }

            }
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager) {
                    rightIndex =(layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                }

            }
        })
    }

    override fun initPresenter() {
        mMoreTypePresenter = MoreTypePresenter(this)
        mMoreTypePresenter?.getPartType()
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }



    override fun onItemClick(view: View, position: Int) {

        when(view?.id){
            R.id.tv_type -> selectLeft(position,true)
        }
    }

    private fun selectLeft(position: Int, b: Boolean) {
        try {
            if (leftIndex!=position){
                mLeftList[leftIndex].isSelect= false
                mLeftAdapter?.notifyItemChanged(leftIndex)
                mLeftList[position].isSelect =true
                mLeftAdapter?.notifyItemChanged(position)
                leftIndex =position
                if (b){
                    scrollRight()
                }
            }
        }catch (e:Exception){

        }

    }

    private fun scrollRight(){
        if (leftIndex< recycler_list_right?.adapter?.itemCount!!){
            recycler_list_right?.scrollToPosition(leftIndex)
        }
    }

    private fun selType(){
        for (index in mLeftList.indices){
            if (mLeftList[index].partsList.size>0){
                for (childData in mLeftList[index].partsList.iterator()){
                    if (childData.isSelect){
                        callbackkStr += "${childData.name},"
                    }
                }
            }
        }
        callback()
    }

    private fun callback() {
        var intent  = Intent()
        var bundle = Bundle()
        bundle.putString(Configs.SCREEN_RESULT_Extra, callbackkStr)
        intent.putExtras(bundle)
        setResult(Configs.PARTS_TYPE_RESULT_CODE, intent)
        finish()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.iv_back->finish()
            R.id.tv_right->selType()
        }
    }
    override fun refreshLeftUI(bean: MecTypeBean?) {
        mLeftList.clear()
        if (bean!=null&&bean?.code==200){
            mLeftList.addAll(bean?.result)
            if (mLeftList.size>0){
                mLeftList[0].isSelect =true

                for (data in mLeftList.iterator()){
                    if (data.partsList.size>0){
                        mRightList.add(data)
                    }
                }
            }
        }
        mLeftAdapter?.notifyDataSetChanged()
        mRightAdapter?.notifyDataSetChanged()

    }

    override fun onItemClick(view: View, position: Int, childPosition: Int) {
        mLeftList[position].partsList[childPosition].isSelect = !mLeftList[position].partsList[childPosition].isSelect
        mRightAdapter?.notifyItemChanged(position)
    }
}