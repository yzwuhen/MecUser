package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.*
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.*

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


    fun addFactoryOrder(mReFactoryOrder: ReFactoryOrder) {
        baseView?.showLoading()
        baseModel.addFactory(
            mReFactoryOrder,
            App.getInstance().token,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    if (t != null) {
                        (baseView as FactoryOrderView<NetData>)?.showData(t)
                    }
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

    //支付方式
    fun getPayWay() {
        baseModel.getCode("mec_market_pay_type",
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


    // 获取年份
    fun getYearsTime() {
        baseModel.getCode("mec_market_delivery_type",
            object : ISubscriberListener<CodeBean> {
                override fun onNext(t: CodeBean?) {
                    if (t?.code == 200) {
                        (baseView as AskRentView).showYears(t.result)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    //工种父类
    fun getWorkType() {
        baseView.showLoading()
        baseModel.getWorkTypeList(
            0,
            30,
            object : ISubscriberListener<MecTypeParentBean> {
                override fun onNext(t: MecTypeParentBean?) {
                    if (t?.code == 200 && t?.result != null) {
                        t?.result?.records?.let {
                            (baseView as MecTypeView<BaseData>)?.refreshLeftUI(
                                it
                            )
                        }
                        if (t?.result?.records?.size!! > 0) {
                            t?.result?.records?.get(0)?.id?.let { getWorkTypeChildList(it) }
                        }

                    } else {
                        baseView?.err()
                    }

                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                    baseView?.hiedLoading()
                }
            })
    }

    fun getWorkTypeChildList(pid: String) {
        baseModel?.getWorkTypeChildList(
            1,
            30,
            pid,
            object : ISubscriberListener<MecTypeChildBean> {
                override fun onNext(t: MecTypeChildBean?) {
                    if (t?.code == 200 && t?.result != null) {

                        t?.result?.records?.let {
                            (baseView as MecTypeView<BaseData>)?.refreshRightUI(
                                it
                            )
                        }

                        baseView?.hiedLoading()
                    } else {
                        baseView?.err()
                    }
                }

                override fun onError(e: Throwable?) {
                    baseView?.err()
                }

                override fun onCompleted() {
                }
            })

    }


    override fun onDestroy() {
    }
}