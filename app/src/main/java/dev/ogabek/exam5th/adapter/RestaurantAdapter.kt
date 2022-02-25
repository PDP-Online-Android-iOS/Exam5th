package dev.ogabek.exam5th.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.model.Restaurant

class RestaurantAdapter(val context: Context, val restaurants: List<Restaurant>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurants, parent, false)
        return RestaurantViewHolder(view)
    }

    class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photo: ImageView = view.findViewById(R.id.restaurant_photo)
        val name: TextView = view.findViewById(R.id.restaurant_name)
        val address: TextView = view.findViewById(R.id.restaurant_address)
        val ratingBar: RatingBar = view.findViewById(R.id.restaurant_rating)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val restaurant = restaurants[position]

        if (holder is RestaurantViewHolder) {
            holder.apply {
                photo.setImageResource(restaurant.photo)
                name.text = restaurant.name
                address.text = restaurant.address
                ratingBar.rating = restaurant.rating
            }
        }

    }

    override fun getItemCount() = restaurants.size
}