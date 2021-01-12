package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.IntegralBean
import com.example.mechanicalapp.ui.data.IntegralData
import com.example.mechanicalapp.ui.data.IntegralListBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.IntegralView

class IntegralPresenter (
    private var baseView: BaseView<NetData>
) :
    BasePresenter {
    private var baseModel = ModelImpl()
    private var page: Int = 1;
    private var pageSize: Int = 30;
    override fun request() {

    }
    fun getIntegral(){
        baseView.showLoading()
        baseModel.getIntegral( App.getInstance().token,object :ISubscriberListener<IntegralBean>{
            override fun onNext(t: IntegralBean?) {
                (baseView as IntegralView<IntegralBean>).showData(t)
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }

    override fun onDestroy() {
    }

    fun resetPage() {
        page=1
    }

    fun getIntegralList() {
        baseView.showLoading()
        baseModel.getIntegralList(App.getInstance().token,App.getInstance().userInfo.username,page,pageSize,object :ISubscriberListener<IntegralListBean>{
            override fun onNext(t: IntegralListBean?) {
                if (page==1){
                    if (t?.code==200){
                        (baseView as IntegralView<List<IntegralData>>).showData(t?.result?.records)
                    }
                }else{
                    if (t?.code==200){
                        (baseView as IntegralView<List<IntegralData>>).showDataMore(t?.result?.records)
                    }
                }
                ++page
            }

            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })
    }

    //签到
    fun sign() {
        baseView.showLoading()
        baseModel.signIntegral(App.getInstance().token,object :ISubscriberListener<NetData>{
            override fun onNext(t: NetData?) {
                (baseView as IntegralView<IntegralBean>).success(t)
            }
            override fun onError(e: Throwable?) {
                baseView.hiedLoading()
                baseView.err()
            }

            override fun onCompleted() {
                baseView.hiedLoading()
            }
        })

    }
}