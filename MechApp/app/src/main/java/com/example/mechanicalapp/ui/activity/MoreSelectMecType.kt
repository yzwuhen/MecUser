package com.example.mechanicalapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mechanicalapp.R
import com.example.mechanicalapp.config.Configs
import com.example.mechanicalapp.ui.`interface`.OnItemClickLevelListener
import com.example.mechanicalapp.ui.`interface`.OnItemClickListener
import com.example.mechanicalapp.ui.adapter.TypeLeftAdapter
import com.example.mechanicalapp.ui.adapter.TypeRightAdapter
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.MecTypeBean
import com.example.mechanicalapp.ui.data.MecTypeData
import com.example.mechanicalapp.ui.mvp.impl.MoreTypePresenter
import com.example.mechanicalapp.ui.mvp.v.TypeView
import kotlinx.android.synthetic.main.activity_ec_type.*
import kotlinx.android.synthetic.main.layout_title.*

class MoreSelectMecType :BaseCusActivity(), OnItemClickListener ,View.OnClickListener,OnItemClickLevelListener,
    TypeView<MecTypeBean> {


    private var mLeftAdapter: TypeLeftAdapter? = null
    private var mRightAdapter: TypeRightAdapter? = null
    var mLeftList: MutableList<MecTypeData> = ArrayList<MecTypeData>()
    var mRightList: MutableList<MecTypeData> = ArrayList<MecTypeData>()
    private var callbackkStr:String=""
    private var mMoreTypePresenter:MoreTypePresenter?=null

    private var leftIndex:Int=0
    private var rightIndex:Int=0

    override fun getLayoutId(): Int {
        return R.layout.activity_ec_type
    }


    override fun initView() {
        super.initView()

        tv_title.text="机械类型"
        tv_right.text="完成"
        tv_right.visibility =View.VISIBLE

        mLeftAdapter = TypeLeftAdapter(this, mLeftList, this)
        recycler_list_left.layoutManager = LinearLayoutManager(this)
        recycler_list_left.adapter = mLeftAdapter


        mRightAdapter = TypeRightAdapter(this, mRightList, this)
        recycler_list_right.layoutManager = LinearLayoutManager(this)
        recycler_list_right.adapter = mRightAdapter

        tv_unlimited.visibility =View.GONE

        iv_back.setOnClickListener(this)
        tv_right.setOnClickListener(this)



        recycler_list_right.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState==0){
                    //recycler_list_left.scrollToPosition()
                    selectLeft(rightIndex,false)
                }

            }
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
               var layoutManager = recyclerView.layoutManager
                if (layoutManager is LinearLayoutManager) {
                  //  var  lastVisibleItemPosition =(layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                  //  var firstVisibleItemPosition =(layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    rightIndex =(layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition()
                  //  var lastCompletelyVisibleItemPosition =(layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
              //      Log.v("sssssssssss", "============ssssss=====================$lastVisibleItemPosition")
                //    Log.v("sssssssssss", "============dddddd=====================$firstVisibleItemPosition")
                 //   Log.v("sssssssssss", "==============ggggg===================$firstCompletelyVisibleItemPosition")
                  //  Log.v("sssssssssss", "==============hhhhh===================$lastCompletelyVisibleItemPosition")
                }

            }
        })
    }

    override fun initPresenter() {

        mMoreTypePresenter = MoreTypePresenter(this)
        mMoreTypePresenter?.getMecType()
    }

    override fun onItemClick(view: View, position: Int) {
        when(view?.id){
            R.id.tv_type -> selectLeft(position,true)
        }
    }

    private fun selectLeft(position: Int, b: Boolean) {
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
    }

    private fun scrollRight(){
        if (leftIndex< recycler_list_right?.adapter?.itemCount!!){
            recycler_list_right?.scrollToPosition(leftIndex)
        }
    }

    private fun selType(){
        for (index in mLeftList.indices){
            if (mLeftList[index].childList.size>0){
                for (childData in mLeftList[index].childList.iterator()){
                    if (childData.isSelect){
                        callbackkStr += "${childData.cateName},"
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
        setResult(Configs.EC_TYPE_RESULT_CODE, intent)
        finish()
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.iv_back -> finish()
            R.id.tv_right -> selType()
        }

    }
    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err()  {
    }


    override fun refreshLeftUI(bean: MecTypeBean?) {
        mLeftList.clear()
        if (bean!=null&&bean?.code==200){
            mLeftList.addAll(bean?.result)
            if (mLeftList.size>0){
                mLeftList[0].isSelect =true
                for (data in mLeftList.iterator()){
                    if (data.childList.size>0){
                        mRightList.add(data)
                    }
                }
            }
        }
        mLeftAdapter?.notifyDataSetChanged()
        mRightAdapter?.notifyDataSetChanged()

    }

    override fun onItemClick(view: View, position: Int, childPosition: Int) {
        mLeftList[position].childList[childPosition].isSelect = !mLeftList[position].childList[childPosition].isSelect
        mRightAdapter?.notifyItemChanged(position)
    }
}