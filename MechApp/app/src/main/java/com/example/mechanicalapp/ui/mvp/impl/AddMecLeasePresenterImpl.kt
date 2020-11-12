package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecBusiness
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.data.request.RePartsLease
import com.example.mechanicalapp.ui.data.request.ReWorkAbout
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

/**
 * 器械 配件 工厂 添加管理
 */
class AddMecManagePresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()


    override fun request() {
    }

    fun addMecLease(mReMecLease: ReMecLease){
        baseModel.addMecLease(mReMecLease,object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }

      fun addMecBusiness(mReMecBusiness: ReMecBusiness){
        baseModel.addMecBusiness(mReMecBusiness,object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {
            }
            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }
    fun addPartsLease(mRePartsLease: RePartsLease){
        baseModel.addPartsLease(mRePartsLease,object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {
            }
            override fun onError(e: Throwable?) {
            }
            override fun onCompleted() {
            }
        })
    }
    fun addWorkAbout(mReWorkAbout: ReWorkAbout){
        baseModel.addWorkAbout(mReWorkAbout,object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {
            }
            override fun onError(e: Throwable?) {
            }
            override fun onCompleted() {
            }
        })
    }

    override fun onDestroy() {
    }
}