package com.example.mechanicalapp.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SideBarView extends View {
    private List<String> mContentDataList = new ArrayList<>();
    private int mBackgroundColor = Color.TRANSPARENT;
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private float mTextSize = 26;
    private int mTextColor = Color.BLACK;
    private int mItemSpace = 15;                //自定义的item间隔
    private boolean mIsEqualItemSpace = true;   //是否按View的高度均分item的高度间隔
    private Paint mPaint;
    private int mWidth = 0;
    private int mHeight = 0;
    private Point mOneItemPoint = new Point();  //第一个item的坐标值
    private int mItemHeightSize = 40;            //单个Item的高度尺寸
    private OnClickListener mListener;

    public SideBarView(Context context) {
        super(context);
        initPaint();
    }

    public SideBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public SideBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (mContentDataList.isEmpty()){
            return;
        }
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (mIsEqualItemSpace) {//均分Item间距模式
            mItemHeightSize = (mHeight - (mPaddingTop + mPaddingBottom)) / mContentDataList.size();//高度 - 上下边距 / Item的数量 = 一个Item的高度
        } else {                //自定义Item间距模式
            mItemHeightSize = ((mHeight - (mPaddingTop + mPaddingBottom)) / mContentDataList.size()) + mItemSpace;
        }
        mOneItemPoint.x = (mWidth - (mPaddingLeft + mPaddingRight)) / 2; //宽度 - 左右边距 / 2 = 第一个Item的X坐标值
        mOneItemPoint.y = mPaddingTop + mItemHeightSize;                //上边距 + Item高度 = 第一个Item的Y坐标值
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int itemAllHeight = mHeight - (mPaddingTop + mPaddingBottom);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //根据当前点击的位置与整体item的全部高度除比，在将除得后的数字四舍五入获得对应集合中的位置。
                int downPosition = Math.round(mContentDataList.size() / (itemAllHeight / event.getY()));
                downPosition = Math.max(downPosition, 1);                       //不允许有小于1的值
                downPosition = Math.min(downPosition, mContentDataList.size());//不允许有大于集合长度的值
                downPosition = downPosition - 1;
                if (mListener != null) {
                    mListener.onItemDown(downPosition, mContentDataList.get(downPosition));
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                int movePosition = Math.round(mContentDataList.size() / (itemAllHeight / event.getY()));
                movePosition = Math.max(movePosition, 1);
                movePosition = Math.min(movePosition, mContentDataList.size());
                movePosition = movePosition - 1;
                if (mListener != null) {
                    mListener.onItemMove(movePosition, mContentDataList.get(movePosition));
                }
                return true;
            case MotionEvent.ACTION_UP:
                int upPosition = Math.round(mContentDataList.size() / (itemAllHeight / event.getY()));
                upPosition = Math.max(upPosition, 1);
                upPosition = Math.min(upPosition, mContentDataList.size());
                upPosition = upPosition - 1;
                if (mListener != null) {
                    mListener.onItemUp(upPosition, mContentDataList.get(upPosition));
                }
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    public void setContentDataList(List<String> list) {
        mContentDataList.clear();
        mContentDataList.addAll(list);
        postInvalidate();
    }

    /**
     * 设置文字大小
     *
     * @param spValue 单位sp
     */
    public void setTextSize(float spValue) {
        mTextSize = sp2px(spValue);
        mPaint.setTextSize(mTextSize);
        postInvalidate();
    }

    public void setTextColor(@ColorInt int color) {
        mTextColor = color;
        mPaint.setColor(mTextColor);
        postInvalidate();
    }

    public void setBackgroundColor(@ColorInt int color) {
        mBackgroundColor = color;
        postInvalidate();
    }

    /**
     * 设置是否根据View的高度均分item的间距
     *
     * @param isEqualItemSpace true=使用均分  false=不使用均分
     */
    public void setEqualItemSpace(boolean isEqualItemSpace) {
        mIsEqualItemSpace = isEqualItemSpace;
        postInvalidate();
    }

    /**
     * item的间距
     *
     * @param itemSpace 单位dp
     */
    public void itemSpace(int itemSpace) {
        mItemSpace = dip2px(itemSpace);
        mIsEqualItemSpace = false;
        postInvalidate();

    }

    /**
     * 设置内边距
     *
     * @param top    上边距,单位dp
     * @param bottom 下边距,单位dp
     * @param left   左边距,单位dp
     * @param right  右边距,单位dp
     */
    public void setPadding(int top, int bottom, int left, int right) {
        mPaddingTop = dip2px(top);
        mPaddingBottom = dip2px(bottom);
        mPaddingLeft = dip2px(left);
        mPaddingRight = dip2px(right);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(mBackgroundColor);
        drawContent(canvas);
    }

    private void drawContent(Canvas canvas) {
        if (mContentDataList.isEmpty()) {
            return;
        }
        for (int i = 0; i < mContentDataList.size(); i++) {
            String itemContent = mContentDataList.get(i);
            if (i == 0) {
                canvas.drawText(itemContent, mOneItemPoint.x, mOneItemPoint.y, mPaint);
                continue;
            }
            int y = mOneItemPoint.y + (mItemHeightSize * i);
            canvas.drawText(itemContent, mOneItemPoint.x, y, mPaint);
        }
    }

    private int sp2px(float spValue) {
        final float fontScale = getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private int dip2px(float dpValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void setOnSidleClickListener(OnClickListener listener) {
        this.mListener = listener;
    }

    public interface OnClickListener {
        void onItemDown(int position, String itemContent);

        void onItemMove(int position, String itemContent);

        void onItemUp(int position, String itemContent);
    }
}