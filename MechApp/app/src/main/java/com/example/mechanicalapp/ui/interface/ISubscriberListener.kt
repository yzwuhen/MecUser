package com.example.mechanicalapp.ui.`interface`

interface ISubscriberListener<T> {
    fun onNext(t: T?)
    fun onError(e: Throwable?)
    fun onCompleted()

}