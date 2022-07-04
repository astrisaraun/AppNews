package com.adl.testmandiri

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    private var listNews = ArrayList<SourcesItem>()
    private var listDefault = ArrayList<SourcesItem>()
    private val apiServe by lazy {
        InterfaceNews.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        disposable = apiServe.getCategorynews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                val list = result.sources as ArrayList
                for (x in 0 until list.size) {
                    listNews.add(
                        SourcesItem(
                            list[x]?.category,
                            list[x]?.name,
                        )
                    )
                }
                setAdapter()
                Toast.makeText(this, "API Success", Toast.LENGTH_LONG).show()
            },
                { error ->
                    Toast.makeText(this, "API Error", Toast.LENGTH_LONG).show()
                })

    }

    private fun setAdapter() {
        val list = ArrayList<SourcesItem>()
        val adapter = NewsAdapter(list, this)
        adapter.notifyDataSetChanged()
        listCategory.adapter = adapter
        listCategory.layoutManager = LinearLayoutManager(this)
        listCategory.setHasFixedSize(true)
        listCategory.itemAnimator = DefaultItemAnimator()
    }
}
