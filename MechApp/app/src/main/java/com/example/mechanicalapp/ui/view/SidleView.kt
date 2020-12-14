package com.example.mechanicalapp.ui.view

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import com.example.mechanicalapp.R


class SidleView(var mContext: Context, attrs: AttributeSet? = null) : View(
    mContext,
    attrs
) {

    private var bgColor: Int = Color.parseColor("#FFBA24")
    private var frontColor: Int = Color.parseColor("#EFEFEF")
    private var textColor: Int = Color.GRAY
    private var textPaint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var fontMetics: Paint.FontMetrics? = null

    private var paint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var frontPaint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bgPaint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitMapleft: Bitmap? = null
    private var rectLeft: Rect = Rect()

    private var rectBitmap: Rect = Rect()

    private var bitMapSize: Int = 180
    private var startY: Float = 0f
    private var stopY: Float = 0f

    private var textW: Float = 0f
    private var textH: Float = 0f
    private var moveLeft: Boolean = false


    private var mSidleOutListener: SidleOutListener? = null
    private var str = "滑动滑块完成验证"
    private var mXfermode: PorterDuffXfermode? = null

    init {

        frontPaint?.color = frontColor
        frontPaint?.strokeWidth = 6f
        frontPaint?.strokeCap = Paint.Cap.ROUND
        bgPaint?.strokeWidth = 6f
        bgPaint?.color = bgColor
        bgPaint?.strokeCap = Paint.Cap.ROUND
        textPaint?.color = textColor
        textPaint?.strokeWidth = 10f
        textPaint?.textSize = 40f
        fontMetics = textPaint?.fontMetrics

        bitMapleft = BitmapFactory.decodeResource(resources, R.mipmap.scroll_n, null);

        mXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }


    fun addSidleListener(sidleOutListener: SidleOutListener) {
        this.mSidleOutListener = sidleOutListener
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectLeft.left = 0
        rectLeft.top = 0
        rectLeft.right = bitMapSize
        rectLeft.bottom = h


        rectBitmap.left = 0
        rectBitmap.top = 0
        rectBitmap.right = bitMapSize
        rectBitmap.bottom = bitMapSize


        startY = height / 4f
        stopY = height / 4f

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //不影响这层级 ->底层
        val sc =
            canvas!!.saveLayer(0f, 0f, width * 1f, height * 1f, bgPaint, Canvas.ALL_SAVE_FLAG)
        drawRect(canvas)
        drawBitmap(canvas)
        drawText(canvas)
        canvas.restoreToCount(sc);
    }

    /**
     * 画出两个长方形  默认覆盖  第一条是底色 第二条是可拖动的前景色
     */
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun drawRect(canvas: Canvas?) {

        bgPaint?.let { canvas?.drawRoundRect(0f, 0f, width * 1f, height * 1f, 5f, 5f, it) }
        // drawText(canvas)
        frontPaint?.let {
            canvas?.drawRoundRect(
                rectLeft?.left.toFloat() ,
                0f,
                width * 1f,
                height * 1f,
                5f,
                5f,
                it
            )
        }
        frontPaint?.xfermode = null
    }

    /**
     * 绘制 进度条下面的text文本
     */
    private fun drawText(canvas: Canvas?) {
        //不考虑 text的基线等问题
        if (textW == 0f) {
            val rect = Rect()
            textPaint!!.getTextBounds(str, 0, str.length, rect)
            textW = rect.width() * 1f
            textH = rect.height() * 1f
        }
        textPaint?.let {
            canvas?.drawText(
                str,
                width / 2 - textW / 2,
                height / 2 + textH / 2,
                it
            )
        }


    }

    /**
     * 绘制 右侧提示的 滑动验证文本
     */
    private fun drawRightText(canvas: Canvas?) {
        //考虑 text的基线等问题
        if (textW == 0f) {
            val rect = Rect()
            textPaint!!.getTextBounds(str, 0, str.length, rect)
            textW = rect.width() * 1f
            textH = rect.height() * 1f
        }
        textPaint?.let {
            canvas?.drawText(
                str,
                width - textW - bitMapSize - 50,
                height / 2 + textH / 2,
                it
            )
        }


    }


    /**
     * 绘制箭头
     */
    private fun drawBitmap(canvas: Canvas?) {
        paint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        paint?.let { canvas?.drawBitmap(bitMapleft!!, rectBitmap, rectLeft, it) }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> down(event.x)
            MotionEvent.ACTION_UP -> up(event.x)
            MotionEvent.ACTION_MOVE -> moveTo(event.x)
        }
        return true
    }

    private fun up(x: Float) {
        moveLeft = false
    }

    private fun moveTo(x: Float) {
        //已经完成不在绘制 不允许往回拖
        if (moveLeft&& str != "完成验证") {
            rectLeft?.left = x.toInt()
            rectLeft?.right = (x + bitMapSize).toInt()
//            边界判断
            if (rectLeft.left <= 0) {
                rectLeft?.right = bitMapSize
                rectLeft?.left = 0
            }
            if (rectLeft?.right >= width) {
                rectLeft?.right = width
                rectLeft?.left = width - bitMapSize
                str = "完成验证"
                //防止反复回调
                if (mSidleOutListener != null ) {
                    mSidleOutListener?.isSidleOut()
                }
            }
            invalidate()

        }

    }

    public fun resetView(){
        rectLeft.left =0
        rectLeft.right =bitMapSize
        str="滑动滑块完成验证"
        invalidate()
    }

    private fun down(x: Float) {
        if (x >= rectLeft?.left && x <= rectLeft?.right) {

            moveLeft = true
        }
    }

    public interface SidleOutListener {
        fun isSidleOut()
    }
}