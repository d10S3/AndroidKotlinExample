package com.d10s_s3.androidkotlinexample.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.arasthel.spannedgridlayoutmanager.SpanSize
import com.arasthel.spannedgridlayoutmanager.SpannedGridLayoutManager
import com.d10s_s3.androidkotlinexample.R
import com.d10s_s3.androidkotlinexample.adapter.ImageAdapter
import com.d10s_s3.androidkotlinexample.data.source.ImageRepository
import com.d10s_s3.androidkotlinexample.util.RecyclerViewDecoration
import com.d10s_s3.androidkotlinexample.view.main.presenter.MainContract
import com.d10s_s3.androidkotlinexample.view.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val imageAdapter: ImageAdapter by lazy {
        ImageAdapter()
    }

    private val presenter: MainPresenter by lazy {
        MainPresenter(
            view = this@MainActivity,
            imageData = ImageRepository,
            adapterModel = imageAdapter,
            adapterView = imageAdapter
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = imageAdapter

        val spannedGridLayoutManager = SpannedGridLayoutManager(orientation = SpannedGridLayoutManager.Orientation.VERTICAL, spans = 3)

        spannedGridLayoutManager.spanSizeLookup = SpannedGridLayoutManager.SpanSizeLookup { position ->
            when {
                position % 12 == 0 ->
                    SpanSize(2, 2)
                position % 12 == 7 ->
                    SpanSize(2, 2)
                else ->
                    SpanSize(1, 1)
            }
            /*if (position % imageAdapter.itemCount == 0 ||
                position % imageAdapter.itemCount == 10 || // r
                position % imageAdapter.itemCount == 18 || // l
                position % imageAdapter.itemCount == 28 || // r
                position % imageAdapter.itemCount == 36 || // l
                position % imageAdapter.itemCount == 46) { // r
                SpanSize(2, 2)
            }else{
                SpanSize(1, 1)
            }*/
        }

        recyclerView.layoutManager = spannedGridLayoutManager

        recyclerView.addItemDecoration(RecyclerViewDecoration(3, 3, 3, 3))

        presenter.loadItems(this, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun showToast(title: String) {
        Toast.makeText(this, "OnClick $title", Toast.LENGTH_SHORT).show()
    }
}
