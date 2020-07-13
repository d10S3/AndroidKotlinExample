package com.d10s_s3.androidkotlinexample.adapter.contract

import com.d10s_s3.androidkotlinexample.data.ImageItem

/**
 * MVP Contract interface
 */
interface ImageAdapterContract {
    interface View {
        var onClickFunc : ((Int) -> Unit)?
        fun notifyAdapter()
    }

    interface Model {
        fun addItems(imageItems: ArrayList<ImageItem>)
        fun clearItem()
        fun getItem(position: Int): ImageItem
    }
}