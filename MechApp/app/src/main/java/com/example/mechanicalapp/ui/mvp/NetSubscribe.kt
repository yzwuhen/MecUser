package com.example.mechanicalapp.ui.mvp

import com.example.mechanicalapp.ui.`interface`.ISubscriberListener
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