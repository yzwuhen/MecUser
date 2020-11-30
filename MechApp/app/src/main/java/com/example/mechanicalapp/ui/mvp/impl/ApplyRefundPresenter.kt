package com.example.mechanicalapp.ui.mvp.impl

import android.content.Context
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.v.BaseView

class ApplyRefundPresenter (
    private var mContext: Context,
    private var baseView: BaseView<NetData>
) : UpdateFilePresenterImpl(mContext, baseView) {


}