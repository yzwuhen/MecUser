package com.example.mechanicalapp.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.mechanicalapp.R
import com.example.mechanicalapp.ui.`interface`.ProgressListener


class TwoWayProgressBar(
    mContext: Context, attrs: AttributeSet? = null

) : View(
    mContext,
    attrs
) {
    private var bgColor: Int = Color.parseColor("#EFEFEF")
    private var frontColor: Int  = Color.parseColor("#FFBA24")
    private var textColor: Int = Color.GRAY
    private var textPaint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var fontMetics: Paint.FontMetrics? = null

    private var paint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var paint1: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var frontPaint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bgPaint: Paint? = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitMapleft: Bitmap? = null
    private var rectLeft: Rect = Rect()
    private var rectRight: Rect = Rect()

    private var rectBitmap: Rect = Rect()

    private var bitMapSize: Int = 100
    private var startY: Float = 0f
    private var stopY: Float = 0f
    private var textY: Float = 0f
    private var textX: Float = 0f
    private var textW: Float = 0f

    private var moveLeft: Boolean = false
    private var moveRight: Boolean = false

    private var mProgressListener: ProgressListener? = null
    private var mlistText: MutableList<String> = ArrayList<String>()

    init {

        frontPaint?.color = frontColor
        frontPaint?.strokeWidth = 6f
        frontPaint?.strokeCap = Paint.Cap.ROUND
        bgPaint?.strokeWidth = 6f
        bgPaint?.color = bgColor
        bgPaint?.strokeCap = Paint.Cap.ROUND
        textPaint?.color = textColor
        textPaint?.strokeWidth = 10f
        textPaint?.textSize = 50f
        fontMetics = textPaint?.fontMetrics

        bitMapleft = BitmapFactory.decodeResource(resources, R.mipmap.progress_icon, null);
//        bitMapRight=BitmapFactory.decodeResource(resources, R.mipmap.progress_icon, null);
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

    fun addProgressListener(progressListener: ProgressListener) {
        mProgressListener = progressListener;
    }

    fun setTextList(lits: MutableList<String>) {
        mlistText = lits

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectLeft.left = 0
        rectLeft.top = 0
        rectLeft.right = bitMapSize
        rectLeft.bottom = bitMapSize

        rectRight.left = w - bitMapSize
        rectRight.top = 0
        rectRight.right = w
        rectRight.bottom = bitMapSize


        rectBitmap.left = 0
        rectBitmap.top = 0
        rectBitmap.right = bitMapSize
        rectBitmap.bottom = bitMapSize


        startY = height / 4f
        stopY = height / 4f
        textY = height / 4f + 100f

        //计算出间距
        textX = (width - bitMapSize) / (mlistText.size) * 1f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        drawLine(canvas)
        drawBitmap(canvas)
        drawText(canvas)

    }

    /**
     * 画出两条虚线  默认覆盖  第一条是底色 第二条是可拖动的前景色
     */
    private fun drawLine(canvas: Canvas?) {

        bgPaint?.let {
            canvas?.drawLine(
                bitMapSize / 2f,
                startY,
                width * 1f - bitMapSize / 2f,
                stopY,
                it
            )
        };

        frontPaint?.let {
            canvas?.drawLine(
                rectLeft?.left.toFloat() + bitMapSize / 2, startY,
                rectRight?.left.toFloat() + bitMapSize / 2, stopY, it
            )
        };

    }

    /**
     * 绘制 进度条下面的text文本
     */
    private fun drawText(canvas: Canvas?) {

        if (mlistText?.size!! > 0) {

            for (index in mlistText?.indices!!) {
                //文本再进度条下方 不考虑 text的基线等问题
                if (textW == 0f) {
                    textW = textPaint?.measureText(mlistText[index])!!
                }
                //这里第一个要减去描边得宽度 否则对不上
                //检查发现 不对 不是描边的原因= =
                if (index == 0) {
                    textPaint?.let {
                        canvas?.drawText(
                            mlistText[index],
                            bitMapSize / 2 + textX * index + textW * index - 10f,
                            textY,
                            it
                        )
                    }
                } else {
                    textPaint?.let {
                        canvas?.drawText(
                            mlistText[index],
                            bitMapSize / 2 + textX * index + textW * index,
                            textY,
                            it
                        )
                    }
                }

            }
        }
    }


    /**
     * 绘制两边的指示器
     */
    private fun drawBitmap(canvas: Canvas?) {
        paint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        paint?.let { canvas?.drawBitmap(bitMapleft!!, rectBitmap, rectLeft, it) }


        paint1?.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)
        paint1?.let { canvas?.drawBitmap(bitMapleft!!, rectBitmap, rectRight, it) }

        mProgressListener?.progress(
            ((width - bitMapSize) - rectLeft?.left) / ((width - bitMapSize).toDouble()),
            ((width - bitMapSize) - rectRight?.left) / ((width - bitMapSize).toDouble())
        )
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
        moveRight = false
    }

    private fun moveTo(x: Float) {
        if (moveLeft) {
            rectLeft?.left = x.toInt()
            rectLeft?.right = (x + bitMapSize).toInt()
//            边界判断
            if (rectLeft.left <= 0) {
                rectLeft?.right = bitMapSize
                rectLeft?.left = 0
            }

            if (rectLeft?.right >= rectRight?.left) {
                rectLeft?.right = rectRight?.left
                rectLeft?.left = rectRight?.left - bitMapSize
            }
//            mProgressListener?.progress( ((width-100)-rectLeft?.left)/((width-100).toDouble()),((width-100)-rectRight?.left)/((width-100).toDouble()))
            invalidate()
        }

        if (moveRight) {
            rectRight?.left = x.toInt()
            rectRight?.right = (x + bitMapSize).toInt()
            if (rectRight.right >= width) {
                rectRight.right = width
                rectRight.left = width - bitMapSize
            }
            //            边界判断
            if (rectRight?.left <= rectLeft?.right) {
                rectRight?.left = rectLeft?.right
                rectRight?.right = rectLeft?.right + bitMapSize
            }
            invalidate()
        }
    }

    private fun down(x: Float) {
        if (x >= rectLeft?.left && x <= rectLeft?.right) {

            moveLeft = true
        } else if (x >= rectRight?.left && x <= rectRight?.right) {
            moveRight = true
        }
    }
}
