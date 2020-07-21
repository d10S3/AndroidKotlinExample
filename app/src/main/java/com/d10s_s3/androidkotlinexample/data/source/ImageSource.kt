package com.d10s_s3.androidkotlinexample.data.source

import android.content.Context
import com.d10s_s3.androidkotlinexample.data.ImageItem

interface ImageSource {

    interface LoadImageCallback {
        fun onLoadImages(list: ArrayList<ImageItem>)
    }

    fun getImages(context: Context, size: Int, loadImageCallback: LoadImageCallback?)
}