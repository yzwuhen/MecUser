package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView

class CommentPresenter(private var baseView: BaseView<NetData>) :BasePresenter{
    private var page =0;
    private var pageSize=30
    private var baseModel = ModelImpl()
    override fun request() {

    }
    fun getCommentAll(id: String?) {
        baseModel.getComment(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun getCommentGoods(id: String?) {
        baseModel.getCommentGoods(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun getCommentMiddle(id: String?) {
        baseModel.getCommentMiddle(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<NetData> {
                override fun onNext(t: NetData?) {
                }

                override fun onError(e: Throwable?) {
                }

                override fun onCompleted() {
                }
            })
    }

    fun getCommentBad(id: String?) {
        baseModel.getCommentBad(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<NetData> {
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

    fun resetPage() {
        page =0
    }
}