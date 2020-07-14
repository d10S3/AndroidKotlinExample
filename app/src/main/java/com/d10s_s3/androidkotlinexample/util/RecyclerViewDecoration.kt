package com.d10s_s3.androidkotlinexample.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDecoration (
    private val divTop: Int,
    private val divLeft: Int,
    private val divRight: Int,
    private val divBottom: Int
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = divTop
        outRect.left = divLeft
        outRect.right = divRight
        outRect.bottom = divBottom
    }
}