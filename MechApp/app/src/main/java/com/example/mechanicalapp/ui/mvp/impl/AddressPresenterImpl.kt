package com.example.mechanicalapp.ui.mvp.impl

import android.util.Log
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.*
import com.example.mechanicalapp.ui.data.request.ReAddress
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.AddressView
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AddressPresenterImpl(
    private var baseView: BaseView<NetData>
) :
    BasePresenter {
    private var baseModel = ModelImpl()
    private var page: Int = 1;
    private var pageSize: Int = 30;
    override fun request() {

    }

    fun getAddressList() {
        baseView.showLoading()
        baseModel.getAddressList(
            App.getInstance().token,
            page,
            pageSize,
            object : ISubscriberListener<MyAddressBean> {
                override fun onNext(t: MyAddressBean?) {
                    (baseView as AddressView).showData(t)
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    fun addAddress(reAddress: ReAddress) {
        baseView.showLoading()
        baseModel.addAddress(
            App.getInstance().token,
            reAddress,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as AddressView).showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }

    fun delAddress(data: ReAddress?) {
        baseView.showLoading()
        baseModel.delAddress(
            App.getInstance().token,
            data,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as AddressView).showData(t)
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }
    fun editAddress(data: ReAddress?) {
        baseView.showLoading()
        baseModel.editAddress(
            App.getInstance().token,
            data,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                    (baseView as AddressView).showData(t)
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

    fun getCity() {
        baseModel.getCity(
            object : ISubscriberListener<String> {
                override fun onNext(t: String?) {
                    val gson = Gson()
                    val list: List<CityData> = gson.fromJson(
                        t,
                        object : TypeToken<List<CityData?>?>() {}.type
                    ) // 参数二：需要指定类型，类型来决定解析的集合

                    (baseView as AddressView).showCity(list)
                    Log.v("===","sssssss${list.size}")
                }
                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })

    }


}