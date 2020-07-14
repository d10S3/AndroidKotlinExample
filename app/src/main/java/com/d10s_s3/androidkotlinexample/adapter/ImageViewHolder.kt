package com.d10s_s3.androidkotlinexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.d10s_s3.androidkotlinexample.R
import com.d10s_s3.androidkotlinexample.data.ImageItem

class ImageViewHolder (
    parent: ViewGroup,
    private val listenerFunc: ((Int) -> Unit)?
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)) {

    private val imageView by lazy {
        itemView.findViewById(R.id.img_view) as ImageView
    }

    fun onBind(item: ImageItem, position: Int) {
        Glide.with(imageView.context).load(item.resource).into(imageView)

        itemView.setOnClickListener {
            listenerFunc?.invoke(position)
        }
    }
}