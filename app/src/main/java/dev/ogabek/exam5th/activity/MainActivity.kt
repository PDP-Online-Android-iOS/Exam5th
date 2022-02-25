package dev.ogabek.exam5th.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.manager.PrefsManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.ogabek.exam5th.fragment.HomeFragment
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import dev.ogabek.exam5th.fragment.CollectionsFragment
import dev.ogabek.exam5th.fragment.MessageFragment
import dev.ogabek.exam5th.fragment.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var nav_name: TextView

    private lateinit var more: LinearLayout
    private lateinit var profile: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {

        if (!PrefsManager(this).getData("isFinish")) {
            callOnBoardActivity()
        }

        more = findViewById(R.id.more)
        profile = findViewById(R.id.profile)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        nav_name = findViewById(R.id.nav_name)

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment,
            HomeFragment()
        ).commit()

    }

    private fun callOnBoardActivity() {
        startActivity(Intent(this, OnBoardingActivity::class.java))
    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> {
                    selectedFragment = HomeFragment()
                    nav_name.text = getString(R.string.home)
                    more.visibility = View.VISIBLE
                    profile.visibility = View.VISIBLE
                }
                R.id.nav_collection -> {
                    selectedFragment = CollectionsFragment()
                    nav_name.text = getString(R.string.collections)
                    more.visibility = View.GONE
                    profile.visibility = View.GONE
                }
                R.id.nav_message -> {
                    selectedFragment = MessageFragment()
                    nav_name.text = getString(R.string.message)
                    more.visibility = View.GONE
                    profile.visibility = View.GONE
                }
                R.id.nav_search -> {
                    selectedFragment = SearchFragment()
                    nav_name.text = getString(R.string.search)
                    more.visibility = View.GONE
                    profile.visibility = View.GONE
                }
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                selectedFragment!!
            ).commit()
            true
        }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentById(R.id.fragment) is HomeFragment) {
            super.onBackPressed()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, HomeFragment())
                .commit()
        }
    }
}