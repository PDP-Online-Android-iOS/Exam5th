package dev.ogabek.exam5th.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.adapter.CategoryAdapter
import dev.ogabek.exam5th.adapter.RestaurantAdapter
import dev.ogabek.exam5th.model.Category
import dev.ogabek.exam5th.model.Restaurant

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val category: RecyclerView = view.findViewById(R.id.rv_categories)
        val restaurant: RecyclerView = view.findViewById(R.id.rv_restaurants)

        category.layoutManager = GridLayoutManager(requireContext(), 1, GridLayoutManager.HORIZONTAL, false)
        category.adapter = CategoryAdapter(requireContext(), prepareCategory())

        restaurant.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        restaurant.adapter = RestaurantAdapter(requireContext(), prepareRestaurants())

        return  view
    }

    private fun prepareRestaurants(): List<Restaurant> {
        return ArrayList<Restaurant>().apply {
            this.add(Restaurant(R.drawable.restaurant_pizza, "Pizza Restaurant", "1231 Filmore Str", 4.5F))
            this.add(Restaurant(R.drawable.restaurant_pizza, "Pizza Restaurant", "1231 Filmore Str", 4.5F))
            this.add(Restaurant(R.drawable.restaurant_pizza, "Pizza Restaurant", "1231 Filmore Str", 4.5F))
            this.add(Restaurant(R.drawable.restaurant_pizza, "Pizza Restaurant", "1231 Filmore Str", 4.5F))
        }
    }

    private fun prepareCategory(): List<Category> {
        return ArrayList<Category>().apply {
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
            this.add(Category(R.drawable.category_restaurants, "Restaurants"))
        }
    }

}