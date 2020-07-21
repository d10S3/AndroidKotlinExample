package com.d10s_s3.androidkotlinexample.data.source

import android.content.Context
import com.d10s_s3.androidkotlinexample.data.ImageItem

object ImageLocalDataSource : ImageSource{
    override fun getImages(
        context: Context,
        size: Int,
        loadImageCallback: ImageSource.LoadImageCallback?
    ) {
        val list = ArrayList<ImageItem>()
        var i: Int = 0
        for (index in 0..size) {
            if(i > 10) i = 0
            val name = String.format("sample_%02d", i)
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
            i++
        }
        loadImageCallback?.onLoadImages(list)
    }
}