package com.d10s_s3.androidkotlinexample.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d10s_s3.androidkotlinexample.adapter.contract.ImageAdapterContract
import com.d10s_s3.androidkotlinexample.data.ImageItem

class ImageAdapter(override var onClickFunc: ((Int) -> Unit)?) : ImageAdapterContract.View, RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.Model {

    private lateinit var imageList: ArrayList<ImageItem>

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        imageList[position].let {
            holder.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder = ImageViewHolder(parent, onClickFunc)

    override fun getItemCount() = imageList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun getItem(position: Int) = imageList[position]

    override fun addItems(imageItems: ArrayList<ImageItem>) {
        this.imageList = imageItems
    }

    override fun clearItem() {
        imageList.clear()
    }

}