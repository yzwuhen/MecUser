package com.example.mechanicalapp.ui.`interface`

import android.view.View

interface ProgressListener {
    fun progress(leftPos: Double, rightPos:Double,isUp:Boolean,view:View)
}