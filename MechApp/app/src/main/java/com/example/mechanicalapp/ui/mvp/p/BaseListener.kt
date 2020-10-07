package com.example.mechanicalapp.ui.mvp.p

 interface BaseListener<T> {

    fun onErr()
    fun onSuccess(data:T)
}