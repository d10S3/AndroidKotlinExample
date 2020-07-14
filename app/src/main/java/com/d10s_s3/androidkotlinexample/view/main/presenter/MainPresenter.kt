package com.d10s_s3.androidkotlinexample.view.main.presenter

import android.content.Context
import com.d10s_s3.androidkotlinexample.adapter.contract.ImageAdapterContract
import com.d10s_s3.androidkotlinexample.data.ImageItem
import com.d10s_s3.androidkotlinexample.data.source.ImageRepository
import com.d10s_s3.androidkotlinexample.data.source.ImageSource

class MainPresenter (
    private val view: MainContract.View,
    private val imageData: ImageRepository,
    private val adapterModel: ImageAdapterContract.Model,
    private val adapterView: ImageAdapterContract.View
) : MainContract.Presenter{
    init {
        adapterView.onClickFunc = {
            onClickListener(it)
        }
    }

    override fun loadItems(context: Context, isClear: Boolean) {
        imageData.getImages(context, 47, object : ImageSource.LoadImageCallback {
            override fun onLoadImages(list: ArrayList<ImageItem>) {
                if (isClear) {
                    adapterModel.clearItem()
                }

                adapterModel.addItems(list)
                adapterView.notifyAdapter()
            }
        })
    }

    private fun onClickListener(position: Int) {
        adapterModel.getItem(position).let {
            view.showToast(it.title)
        }
    }
}
