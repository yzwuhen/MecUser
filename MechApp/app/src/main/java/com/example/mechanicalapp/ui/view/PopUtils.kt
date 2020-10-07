package com.example.mechanicalapp.ui.view

import android.app.Activity
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import com.example.mechanicalapp.R


object PopUtils{

    private var view: View? = null
    private var popupWindow:PopupWindow?=null



     fun init(mContext: Context, activity: Activity, listen:onViewListener ) :PopupWindow {
        view= View.inflate(mContext,R.layout.pop_recycler,null)

        popupWindow = PopupWindow(view,android.view.ViewGroup.LayoutParams.MATCH_PARENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT,false)
        popupWindow?.inputMethodMode =PopupWindow.INPUT_METHOD_NEEDED
        popupWindow?.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        popupWindow?.isFocusable =true
        popupWindow?.setBackgroundDrawable(BitmapDrawable())
         listen.getView(view)
       //  activity?.let { backgroundAlpha(0.5f, it) };
         return popupWindow!!
    }

    fun init(mContext: Context,res:Int,popWidth:Int,popHeight:Int,listen:onViewListener ) :PopupWindow {
        view= View.inflate(mContext,res,null)
        popupWindow = PopupWindow(view,popWidth,popHeight,false)
        popupWindow?.inputMethodMode =PopupWindow.INPUT_METHOD_NEEDED
        popupWindow?.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        popupWindow?.isFocusable =true
        popupWindow?.setBackgroundDrawable(BitmapDrawable())
        listen.getView(view)
        //  activity?.let { backgroundAlpha(0.5f, it) };
        return popupWindow!!
    }


    fun init(mContext: Context,activity:Activity,res:Int,popWidth:Int,popHeight:Int,hsaBg:Boolean,listen:onViewListener ) :PopupWindow {
        view= View.inflate(mContext,res,null)
        popupWindow = PopupWindow(view,popWidth,popHeight,false)
        popupWindow?.inputMethodMode =PopupWindow.INPUT_METHOD_NEEDED
        popupWindow?.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        popupWindow?.isFocusable =true
        popupWindow?.setBackgroundDrawable(BitmapDrawable())
        listen.getView(view)

        view?.setOnClickListener(View.OnClickListener {
            dismissPop(activity)
        })
        if (hsaBg){
            activity?.let { backgroundAlpha(0.5f, it) }
        }
        return popupWindow!!
    }




    fun backgroundAlpha(bgAlpha: Float, activity: Activity) {
        val lp = activity.window.attributes
        lp.alpha = bgAlpha // 0.0-1.0
        activity.window.attributes = lp
    }

    fun showPopupWindow(parent: View) {
        if (popupWindow?.isShowing==false) {
            val location = IntArray(2)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                popupWindow?.showAsDropDown(
                    parent,
                    Gravity.BOTTOM,
                    location[0],
                    location[1]
                )
            } else {
                popupWindow?.showAtLocation(parent, Gravity.BOTTOM, 0, 0)
            }
        }else{
            popupWindow?.dismiss()
        }
    }

    fun showPopupWindow(parent: View,activity: Activity) {
        if (popupWindow?.isShowing==false) {
            val location = IntArray(2)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                popupWindow?.showAsDropDown(
                    parent,
                    Gravity.BOTTOM,
                    location[0],
                    location[1]
                )
            } else {
                popupWindow?.showAtLocation(parent, Gravity.BOTTOM, 0, 0)
            }
            activity?.let { backgroundAlpha(0.5f, it) }
        }else{
            activity?.let { backgroundAlpha(1f, it) }
            popupWindow?.dismiss()
        }
    }


    fun dismissPop(){
        popupWindow?.dismiss()
    }


    fun dismissPop(activity: Activity){
        popupWindow?.dismiss()
        activity?.let { backgroundAlpha(1f, it) }
    }

    /**
     * 返回View对象
     *
     * @author shishuyao
     */
    interface onViewListener {
        fun getView(
            view: View?
        )
    }

}