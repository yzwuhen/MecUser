package com.example.mechanicalapp.ui.view

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MyDecoration(var hNum:Int) : RecyclerView.ItemDecoration() {

    var position :Int = 0
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        draw(c,parent,state)
    }

    /**
     * c 为getItemOffsets 撑开的画布 再这里画分割线的内容
     */
    private fun draw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (position%hNum==0){
            outRect.set(0,0,10,20)
        }else{
            outRect.set(10,0,0,20)
        }
        position++

    }
}