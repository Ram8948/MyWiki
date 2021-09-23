package com.ramosoft.mywiki.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ramosoft.mywiki.ui.images.CategoryFragment
import com.ramosoft.mywiki.ui.images.ImageinfosFragment


class ViewPagerAdapter(appCompatActivity : AppCompatActivity) : FragmentStateAdapter(appCompatActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ImageinfosFragment()
            1 -> ImageinfosFragment()
            2 -> CategoryFragment()
            else -> ImageinfosFragment()
        }
    }
}