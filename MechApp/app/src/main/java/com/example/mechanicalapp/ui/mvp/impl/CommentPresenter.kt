package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.data.CommentBean
import com.example.mechanicalapp.ui.data.CommentNumBean
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.BasePresenter
import com.example.mechanicalapp.ui.mvp.v.BaseView
import com.example.mechanicalapp.ui.mvp.v.CommentNumView
import com.example.mechanicalapp.ui.mvp.v.CommentView
import com.example.mechanicalapp.ui.mvp.v.GoodsDetailsView

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
            object : ISubscriberListener<CommentBean> {
                override fun onNext(t: CommentBean?) {
                    if (t?.code==200&&t?.result!=null&&t?.result?.pages!=null){
                        if (page==0){
                            (baseView as CommentView).refreshUI(t?.result?.pages?.records)
                        }else{
                            (baseView as CommentView).loadMore(t?.result?.pages?.records)
                        }

                    }else{
                        if (page==0){
                            (baseView as CommentView).refreshUI(null)
                        }
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCommentGoods(id: String?) {
        baseModel.getCommentGoods(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<CommentBean> {
                override fun onNext(t: CommentBean?) {
                    if (t?.code==200&&t?.result!=null&&t?.result?.pages!=null){
                        if (page==0){
                            (baseView as CommentView).refreshUI(t?.result?.pages?.records)
                        }else{
                            (baseView as CommentView).loadMore(t?.result?.pages?.records)
                        }

                    }else{
                        if (page==0){
                            (baseView as CommentView).refreshUI(null)
                        }
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCommentMiddle(id: String?) {
        baseModel.getCommentMiddle(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<CommentBean> {
                override fun onNext(t: CommentBean?) {
                    if (t?.code==200&&t?.result!=null&&t?.result?.pages!=null){
                        if (page==0){
                            (baseView as CommentView).refreshUI(t?.result?.pages?.records)
                        }else{
                            (baseView as CommentView).loadMore(t?.result?.pages?.records)
                        }

                    }else{
                        if (page==0){
                            (baseView as CommentView).refreshUI(null)
                        }
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCommentBad(id: String?) {
        baseModel.getCommentBad(
            App.getInstance().token,
            id,page,pageSize,
            object : ISubscriberListener<CommentBean> {
                override fun onNext(t: CommentBean?) {
                    if (t?.code==200&&t?.result!=null&&t?.result?.pages!=null){
                        if (page==0){
                            (baseView as CommentView).refreshUI(t?.result?.pages?.records)
                        }else{
                            (baseView as CommentView).loadMore(t?.result?.pages?.records)
                        }

                    }else{
                        if (page==0){
                            (baseView as CommentView).refreshUI(null)
                        }
                    }
                    ++page
                }

                override fun onError(e: Throwable?) {
                    baseView.hiedLoading()
                }

                override fun onCompleted() {
                    baseView.hiedLoading()
                }
            })
    }

    fun getCommentNum(id: String?) {
        baseModel.getCommentNum(
            App.getInstance().token,
            id,
            object : ISubscriberListener<CommentNumBean> {
                override fun onNext(t: CommentNumBean?) {
                    (baseView as CommentNumView).showData(t)
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

    fun resetPage() {
        page =0
    }
}