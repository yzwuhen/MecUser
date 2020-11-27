package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReAddCar
import com.example.mechanicalapp.ui.data.request.ReCollect
import com.example.mechanicalapp.ui.mvp.NetSubscribe
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.GoodsDetailsView
import com.example.mechanicalapp.ui.mvp.v.MecDetailsView

class DetailsPresenter(
    private var baseView: BaseView<NetData>
) : BasePresenter {
    private var baseModel = ModelImpl()

    override fun request() {

    }

    fun getLeaseDetails(id: String?) {
        baseView.showLoading()
        baseModel.getLeaseDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<MecDetailsBean> {
                override fun onNext(t: MecDetailsBean?) {
                    (baseView as MecDetailsView<MecDetailsData>).showData(t?.result)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    fun getBusiness(id: String?) {
        baseView.showLoading()
        baseModel.getBusinessDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<BusinessDetailsBean> {
                override fun onNext(t: BusinessDetailsBean?) {
                    (baseView as MecDetailsView<BusinessDetails>).showData(t?.result)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }



    fun getPartsLeaseDetails(id: String?) {
        baseView.showLoading()
        baseModel.getPartsLeaseDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<PartsDetailsBean> {
                override fun onNext(t: PartsDetailsBean?) {
                    (baseView as MecDetailsView<PartsDetailsData>).showData(t?.result)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }


    fun getGoodsDetails(id: String?) {
        baseView.showLoading()
        baseModel.getGoodsDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<GoodsDetailsBean> {
                override fun onNext(t: GoodsDetailsBean?) {
                    (baseView as MecDetailsView<GoodsDetails>).showData(t?.result)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }


    fun getRecruitDetails(id: String?) {
        baseView.showLoading()
        baseModel.getRecruitDetails(
            App.getInstance().token,
            id,
           NetSubscribe<RecruitDetailsBean>(object :ISubscriberListener<RecruitDetailsBean>{
               override fun onNext(t: RecruitDetailsBean?) {
                   (baseView as MecDetailsView<NetData>).showData(t)
               }

               override fun onError(e: Throwable?) {
                   baseView.hiedLoading()
               }

               override fun onCompleted() {
                   baseView.hiedLoading()
               }
           }))
    }

    fun getFactoryDetails(id: String?) {
        baseView.showLoading()
        baseModel.getFactoryDetails(
            App.getInstance().token,
            id,
            object : ISubscriberListener<FactoryDetailsBean> {
                override fun onNext(t: FactoryDetailsBean?) {
                    (baseView as MecDetailsView<NetData>).showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    fun addCollect(recollect: ReCollect){
        baseView.showLoading()
        baseModel.addCollect(
            App.getInstance().token,
            recollect,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as MecDetailsView<NetData>).collectSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }
    fun delCollect(recollect: ReCollect){
        baseView.showLoading()
        baseModel.delCollect(
            App.getInstance().token,
            recollect,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as MecDetailsView<NetData>).collectSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }
    //0商品1维修厂2配件租赁3二手设备租赁4机械租赁5招聘

    fun judgeCollect(id: String?,type:Int){
        baseModel.judgeCollect(
            App.getInstance().token,
            id,
            type,
            object : ISubscriberListener<IsCollectBean> {
                override fun onNext(t: IsCollectBean?) {
                  (baseView as MecDetailsView<NetData>).collectSuccess(t)
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun addShopCar(reAddCar: ReAddCar){
        baseView.showLoading()
        baseModel.addShopCar(
            App.getInstance().token,
            reAddCar,
            object : ISubscriberListener<AddCarBean> {
                override fun onNext(t: AddCarBean?) {
                    (baseView as MecDetailsView<NetData>).collectSuccess(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    override fun onDestroy() {
    }
}