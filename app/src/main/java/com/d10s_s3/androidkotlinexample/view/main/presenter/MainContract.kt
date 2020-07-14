package com.d10s_s3.androidkotlinexample.view.main.presenter

import android.content.Context

interface MainContract {

    interface View {
        fun showToast(title: String)
    }

    interface Presenter {
        fun loadItems(context: Context, isClear: Boolean)
    }
}