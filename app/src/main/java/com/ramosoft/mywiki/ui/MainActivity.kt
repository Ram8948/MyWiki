package com.ramosoft.mywiki.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.ramosoft.mywiki.R
import com.ramosoft.mywiki.databinding.ActivityMainBinding
import com.ramosoft.mywiki.ui.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment: NavHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController: NavController = navHostFragment.navController
//
//        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration(navController.graph)
//        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitle(R.string.app_name)

        val drawerToggle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close)
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle.isDrawerIndicatorEnabled = true

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

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.id_day_light -> {
                Toast.makeText(this, "Publication", Toast.LENGTH_SHORT).show()
                val isNightTheme = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                when (isNightTheme) {
                    Configuration.UI_MODE_NIGHT_YES ->
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    Configuration.UI_MODE_NIGHT_NO ->
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
            }
            R.id.id_articles -> {
                binding.viewPager.currentItem = 0
                }
            R.id.id_gallery -> {
                binding.viewPager.currentItem = 1
            }
            R.id.id_category -> {
                binding.viewPager.currentItem = 2
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.getItemId() == android.R.id.home){ // use android.R.id
            drawer_layout.openDrawer(Gravity.LEFT);
        }
        return super.onOptionsItemSelected(item)
    }
}
