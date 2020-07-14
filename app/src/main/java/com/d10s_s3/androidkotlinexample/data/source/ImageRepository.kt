package com.d10s_s3.androidkotlinexample.data.source

import android.content.Context
import com.d10s_s3.androidkotlinexample.data.ImageItem

object ImageRepository : ImageSource{
    private val imageLocalDataSource = ImageLocalDataSource

    override fun getImages(
        context: Context,
        size: Int,
        loadImageCallback: ImageSource.LoadImageCallback?
    ) {
        imageLocalDataSource.getImages(context, size, object : ImageSource.LoadImageCallback {
            override fun onLoadImages(list: ArrayList<ImageItem>) {
                loadImageCallback?.onLoadImages(list)
            }
        })
    }

    override fun addImages(
        context: Context,
        size: Int,
        list: ArrayList<ImageItem>,
        loadImageCallback: ImageSource.LoadImageCallback?
    ) {

    }
}