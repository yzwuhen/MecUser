package com.example.mechanicalapp.ui.activity

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.base.BaseCusActivity
import com.example.mechanicalapp.ui.data.NetData
import com.example.mechanicalapp.ui.mvp.p.MecAppPresenter
import com.example.mechanicalapp.ui.mvp.v.NetDataView
import com.ezvizuikit.open.EZUIError
import com.ezvizuikit.open.EZUIKit
import com.ezvizuikit.open.EZUIPlayer
import kotlinx.android.synthetic.main.activity_video_player.*
import java.util.*

class VideoPlayerActivity :BaseCusActivity(), EZUIPlayer.EZUIPlayerCallBack ,NetDataView<NetData>{
    private var mPresenter : MecAppPresenter?=null
    override fun getLayoutId(): Int {
       return R.layout.activity_video_player
    }

    override fun initView() {
        super.initView()

        //设置加载需要显示的view
        //设置加载需要显示的view
        player_ui.setLoadingView(initProgressBar())
        player_ui.setRatio(16 * 1.0f / 9)
        //初始化EZUIKit
        EZUIKit.initWithAppKey(application, "ca60c005fe454770ac6fd81fd03a6164")
        //设置授权token
        EZUIKit.setAccessToken("at.dz6duz29dd1s8cyh3dsg2tbtc9rqxdts-58fwd7gbn7-12omb3y-gpaxvhcr2")
        //设置播放回调callback
        player_ui.setCallBack(this)
        //设置播放参数
        player_ui.setUrl("ezopen://open.ys7.com/E82901339/1.rec")

    }

    /**
     * 创建加载view
     *
     * @return
     */
    private fun initProgressBar(): View? {
        val relativeLayout = RelativeLayout(this)
        relativeLayout.setBackgroundColor(Color.parseColor("#000000"))
        val lp = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        )
        relativeLayout.layoutParams = lp
        val rlp = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT) //addRule参数对应RelativeLayout XML布局的属性
        val mProgressBar = ProgressBar(this)
        mProgressBar.indeterminateDrawable = resources.getDrawable(R.drawable.loading_anim)
        relativeLayout.addView(mProgressBar, rlp)
        return relativeLayout
    }

    override fun initPresenter() {
        mPresenter = MecAppPresenter(this)
        var id = intent.getStringExtra("id")
        mPresenter?.getCameraVideo(id)
    }

    override fun onPlaySuccess() {
        Log.v("ssss", "sssssssss===========播放成功")
    }

    override fun onPlayFail(p0: EZUIError?) {
        Log.v("ssss", "sssssssss=============${p0?.errorString}")
    }

    override fun onVideoSizeChange(p0: Int, p1: Int) {
    }

    override fun onPrepared() {
        Log.v("ssss", "sssssssss===========onPrepared")
        player_ui.startPlay()
    }

    override fun onPlayTime(p0: Calendar?) {
    }

    override fun onPlayFinish() {
        Log.v("ssss", "sssssssss===========onPlayFinish")
    }

    override fun onStop() {
        super.onStop()
        player_ui.stopPlay()
    }

    override fun onDestroy() {
        super.onDestroy()
        player_ui.releasePlayer();
    }

    override fun refreshUI(data: NetData?) {

    }

    override fun loadMore(data: NetData?) {
    }

    override fun showLoading() {
    }

    override fun hiedLoading() {
    }

    override fun err() {
    }

}