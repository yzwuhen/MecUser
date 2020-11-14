package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

class PresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()

    private var page: Int = 0;
    private var pageSize: Int = 30;

    override fun request() {
    }

    fun getCollectList(type: Int) {
        baseModel.getCollect(App.getInstance().token,type, page, pageSize, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }

    fun getCollectSecondHandList(type: Int) {
        baseModel.getSecondCollect(App.getInstance().token,type, page, pageSize, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }


    fun getCollectPartsList(type: Int) {
        baseModel.getPartsCollect(App.getInstance().token,type, page, pageSize, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }


    fun getFactoryCollect(type: Int) {
        baseModel.getFactoryCollect(App.getInstance().token,type, page, pageSize, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }



    fun getRecruitCollect(type: Int) {
        baseModel.getRecruitCollect(App.getInstance().token,type, page, pageSize, object : ISubscriberListener<NetData> {
            override fun onNext(t: NetData?) {

            }

            override fun onError(e: Throwable?) {
            }

            override fun onCompleted() {
            }
        })
    }



    fun getGoodsCollect(type: Int) {
        baseModel.getGoodsCollect(App.getInstance().token,type, page, pageSize, object : ISubscriberListener<NetData> {
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