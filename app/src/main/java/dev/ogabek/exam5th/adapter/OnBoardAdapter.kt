package dev.ogabek.exam5th.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.model.OnBoardData

class OnBoardAdapter(val context: Context, val data: List<OnBoardData>): PagerAdapter() {
    override fun getCount() = data.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val info = data[position]
        val view = LayoutInflater.from(context.applicationContext).inflate(R.layout.item_onboard, container, false)
        val icon: ImageView = view.findViewById(R.id.vp_item_icon)
        val title: TextView = view.findViewById(R.id.vp_item_title)
        val description: TextView = view.findViewById(R.id.vp_item_description)
        icon.setImageResource(info.icon)
        title.text = info.title
        description.text = info.description
        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}