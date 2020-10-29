package com.example.mechanicalapp.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class ParentCusVp extends ViewPager {

    private boolean enabled;

    private float startX;

    public ParentCusVp(Context context) {
        super(context);
    }


    public ParentCusVp(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    //设置viewpage是否允许滑动
    public boolean setTouchEvent(boolean enabled){

        return  this.enabled=enabled;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        if (this.enabled) {
//            return super.onTouchEvent(event);
//        }
//        return enabled;
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                startX =event.getX();
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//                Log.e("=======ssss","=================="+Math.abs(event.getX() -startX));
//                if (Math.abs(event.getX() -startX)>10){
//                    return true;
//                }
//                break;
//        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

//        Log.e("=======ssss",ev.getAction()+"========dispatchTouchEvent==========");
//       switch (ev.getAction()){
//           case MotionEvent.ACTION_DOWN:
//               startX =ev.getX();
//               break;
//           case MotionEvent.ACTION_MOVE:
//
//               Log.e("=======ssss","=================="+Math.abs(ev.getX() -startX));
//               if (Math.abs(ev.getX() -startX)>20){
//                   return false;
//               }
//               break;
//       }

        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        Log.e("=======ssss",event.getAction()+"========onInterceptTouchEvent==========");
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               startX =event.getX();
               break;
           case MotionEvent.ACTION_MOVE:

               Log.e("=======ssss","=================="+Math.abs(event.getX() -startX));
               if (Math.abs(event.getX() -startX)>50){
                   return true;
               }
               break;
       }

        return super.onTouchEvent(event);
    }

}

