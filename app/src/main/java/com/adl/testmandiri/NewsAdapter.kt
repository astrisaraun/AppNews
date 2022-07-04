package com.adl.testmandiri

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_category.view.*


class NewsAdapter(private var items: ArrayList<SourcesItem>, private val context: Context) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
//        holder.view.judulNews.text = item.name
        holder.view.newsCategory.text = item.category

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val view = view.kategoriBerita
}