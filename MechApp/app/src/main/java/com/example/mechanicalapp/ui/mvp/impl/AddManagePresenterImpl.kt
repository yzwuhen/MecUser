package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.CodeBean
import com.example.mechanicalapp.ui.data.CodeData
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.data.request.ReMecBusiness
import com.example.mechanicalapp.ui.data.request.ReMecLease
import com.example.mechanicalapp.ui.data.request.RePartsLease
import com.example.mechanicalapp.ui.data.request.ReWorkAbout
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.RecruitView
import com.example.mechanicalapp.ui.mvp.v.ReleaseView

/**
 * 器械 配件 工厂 添加管理
 */
class AddManagePresenterImpl(
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) :
    BasePresenter {

    private var baseModel = ModelImpl()


    override fun request() {
    }

    fun addMecLease(mReMecLease: ReMecLease) {
        baseView?.showLoading()
        baseModel.addMecLease(
            mReMecLease,
            App.getInstance().token,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as ReleaseView<NetData>)?.showSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

    fun addMecBusiness(mReMecBusiness: ReMecBusiness) {
        baseView?.showLoading()
        baseModel.addMecBusiness(
            mReMecBusiness,
            App.getInstance().token,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as ReleaseView<NetData>)?.showSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

    fun addPartsLease(mRePartsLease: RePartsLease) {
        baseView.showLoading()
        baseModel.addPartsLease(
            mRePartsLease,
            App.getInstance().token,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as ReleaseView<NetData>)?.showSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

    fun addWorkAbout(mReWorkAbout: ReWorkAbout) {
        baseView?.showLoading()
        baseModel.addWorkAbout(
            mReWorkAbout,
            App.getInstance().token,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as RecruitView)?.showSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

    //工作经验
    fun getWorkExp() {
        baseModel.getCode("mec_market_recruit_age",
            object : ISubscriberListener<CodeBean> {
                override fun onNext(t: CodeBean?) {
                    if (t?.code == 200) {
                        (baseView as RecruitView).showWorkExp(t.result)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    //薪资表
    fun getWages() {
        baseModel.getCode("mec_market_recruit_price",
            object : ISubscriberListener<CodeBean> {
                override fun onNext(t: CodeBean?) {
                    if (t?.code == 200) {
                        (baseView as RecruitView).showWages(t.result)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    //计费方式
    fun getBillMethod() {
        baseModel.getCode("mec_market_price_unit",
            object : ISubscriberListener<CodeBean> {
                override fun onNext(t: CodeBean?) {
                    if (t?.code == 200) {
                        (baseView as ReleaseView<List<CodeData>>).showData(t.result)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }


    //出厂时间
    fun getFactoryOutTime() {
        baseModel.getCode("mec_market_delivery_type",
            object : ISubscriberListener<CodeBean> {
                override fun onNext(t: CodeBean?) {
                    if (t?.code == 200) {
                        (baseView as RecruitView).showWages(t.result)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun getWorkType() {
//        baseModel.getWorkTypeList(
//            mReWorkAbout,
//            App.getInstance().token,
//            object : ISubscriberListener<NetData> {
//                override fun onNext(t: NetData?) {
//                }
//
//                override fun onError(e: Throwable?) {
//                }
//
//                override fun onCompleted() {
//                }
//            })
    }

    override fun onDestroy() {
    }
}