package com.example.mechanicalapp.ui.mvp.v

interface MsgView<T>  {
    fun refreshUI(t: T?)
    fun success()
}