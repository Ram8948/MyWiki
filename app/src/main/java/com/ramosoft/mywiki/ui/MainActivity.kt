package com.ramosoft.mywiki.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.ramosoft.mywiki.R
import com.ramosoft.mywiki.databinding.ActivityMainBinding
import com.ramosoft.mywiki.ui.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment: NavHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController: NavController = navHostFragment.navController
//
//        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(navController.graph)
//        binding.toolbar.setupWithNavController(navController, appBarConfiguration)


        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter
        binding.bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.articlesFragment -> {
                    binding.viewPager.currentItem = 0
                    return@OnItemSelectedListener true
                }
                R.id.imagesFragment -> {
                    binding.viewPager.currentItem = 1
                    return@OnItemSelectedListener true
                }
                R.id.categoryFragment -> {
                    binding.viewPager.currentItem = 2
                    return@OnItemSelectedListener true
                }
            }
            false
        })
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> binding.bottomNavigationView.menu.findItem(R.id.articlesFragment).isChecked = true
                    1 -> binding.bottomNavigationView.menu.findItem(R.id.imagesFragment).isChecked = true
                    2 -> binding.bottomNavigationView.menu.findItem(R.id.categoryFragment).isChecked = true
                }
            }
        })

    }
}
