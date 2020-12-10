package com.example.mechanicalapp.ui.mvp

import android.content.Intent
import com.example.mechanicalapp.App
import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
import com.example.mechanicalapp.ui.activity.LoginActivity
import com.example.mechanicalapp.ui.data.NetData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class NetSubscribe<T>(var call: ISubscriberListener<T>): Observer<T> {
    private var mListtener: ISubscriberListener<T>? = null

    init {
        mListtener =call
    }
    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: T) {
        if (t != null && mListtener != null) {
//            if (t is NetData&&t.code==403){
//                var intent =Intent()
//                intent.setClass(App.getInstance().applicationContext,LoginActivity::class.java)
//                App.getInstance().applicationContext.startActivity(intent)
//            }
            mListtener!!.onNext(t)
        }
    }

    override fun onError(e: Throwable) {
        if (mListtener != null) {
            mListtener!!.onError(e)
        }
    }

    override fun onComplete() {
        if (mListtener != null) {
            mListtener!!.onCompleted()
        }
    }
}