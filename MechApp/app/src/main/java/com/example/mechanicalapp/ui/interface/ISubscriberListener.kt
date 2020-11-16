package com.example.mechanicalapp.ui.`interface`

open interface ISubscriberListener<T> {
    fun onNext(t: T?)
    fun onError(e: Throwable?)
    fun onCompleted()

}