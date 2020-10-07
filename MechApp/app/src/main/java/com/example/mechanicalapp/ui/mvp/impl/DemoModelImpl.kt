package com.example.mechanicalapp.ui.mvp.impl

import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.m.BaseModel
import com.example.mechanicalapp.ui.mvp.p.OnFinishListener

class DemoModelImpl(var listener: OnFinishListener): BaseModel {

    //网络请求
    override fun initRequest() {

        listener.onSuccess(NetData())
    }
}