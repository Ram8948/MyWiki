package com.ramosoft.mywiki.ui.images

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.data.entities.ImageModel
import com.ramosoft.mywiki.databinding.ImageDetailFragmentBinding
import kotlinx.android.synthetic.main.activity_article_detail.*

class ImageDetailsActivity : AppCompatActivity() {
    private var currentPage: ImageModel.Query.Allimage? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ImageDetailFragmentBinding = ImageDetailFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val wikiPageJson = intent.getStringExtra("page")
        currentPage = Gson().fromJson<ImageModel.Query.Allimage>(wikiPageJson, ImageModel.Query.Allimage::class.java)


        supportActionBar?.title = currentPage?.title
        currentPage?.url?.let { bindCharacter(it,binding) }
//        intent.extras?.getString("ARGUMENT_ACTION")?.let { bindCharacter(it,binding) }
    }

    private fun bindCharacter(url: String,binding:ImageDetailFragmentBinding) {
        binding.photoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(binding.root)
            .load(url)
            .into(binding.photoView)
    }
}