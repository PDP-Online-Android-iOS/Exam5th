package dev.ogabek.exam5th.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.adapter.OnBoardAdapter
import dev.ogabek.exam5th.manager.PrefsManager
import dev.ogabek.exam5th.model.OnBoardData

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var dotIndicator: WormDotsIndicator
    private lateinit var viewPager: ViewPager

    private lateinit var tv_skip: TextView
    private lateinit var tv_next: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_on_boarding)

        initViews()

    }

    private fun initViews() {
        dotIndicator = findViewById(R.id.di_onboard)
        viewPager = findViewById(R.id.vp_onboard)
        val adapter = OnBoardAdapter(this, addPages())
        viewPager.adapter = adapter
        dotIndicator.setViewPager(viewPager)

        tv_skip = findViewById(R.id.tv_skip_onboard)
        tv_next = findViewById(R.id.tv_next_onboard)

        tv_skip.setOnClickListener {
            viewPager.setCurrentItem(addPages().size, true)
        }

        tv_next.setOnClickListener {
            if (tv_next.text == getString(R.string.done)) {
                PrefsManager(this).saveData("isFinish", true)
                callMainActivity()
                finish()
            } else
                viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                if (position == addPages().size - 1) {
                    tv_next.text = getString(R.string.done)
                    tv_skip.visibility = View.GONE
                } else {
                    tv_next.text = getString(R.string.next)
                    tv_skip.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })

    }

    private fun callMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun addPages(): List<OnBoardData> {
        return ArrayList<OnBoardData>().apply {
            this.add(OnBoardData(R.drawable.ic_like, getString(R.string.first_title), getString(R.string.first_info)))
            this.add(OnBoardData(R.drawable.ic_instagram, getString(R.string.second_title), getString(R.string.second_info)))
            this.add(OnBoardData(R.drawable.ic_chat, getString(R.string.third_title), getString(R.string.third_info)))
            this.add(OnBoardData(R.drawable.ic_notification, getString(R.string.forth_title), getString(R.string.forth_info)))
        }
    }
}