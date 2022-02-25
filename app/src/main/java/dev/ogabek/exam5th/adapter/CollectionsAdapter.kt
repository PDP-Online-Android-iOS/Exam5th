package dev.ogabek.exam5th.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.model.Collections

class CollectionsAdapter(val context: Context, val collections: ArrayList<Collections>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_collections, parent, false)
        return CollectionsViewHolder(view)
    }

    class CollectionsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.collections_photo)
        val title: TextView = view.findViewById(R.id.collections_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val collections = collections[position]

        if (holder is CollectionsViewHolder) {
            holder.apply {
                photo.setImageResource(collections.photo)
                title.text = collections.title
            }
        }
    }

    override fun getItemCount() = collections.size
}