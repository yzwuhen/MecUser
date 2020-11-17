package com.example.mechanicalapp.ui.mvp.v

import com.example.mechanicalapp.ui.data.LoginCodeBean


interface LoginCodeView<NetData> :BaseView<NetData> {
    fun loginSuccess(mLoginCodeBean: LoginCodeBean)
    fun loginErr(exception: String?)
}