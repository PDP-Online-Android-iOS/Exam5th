package dev.ogabek.exam5th.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.model.Category

class CategoryAdapter(val context: Context, val categories: List<Category>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.category_icon)
        val title: TextView = view.findViewById(R.id.category_title)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val category = categories[position]

        if (holder is CategoryViewHolder) {
            holder.apply {
                icon.setImageResource(category.icon)
                title.text = category.title
            }
        }

    }

    override fun getItemCount() = categories.size
}