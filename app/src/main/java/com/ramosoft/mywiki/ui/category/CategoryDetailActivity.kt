package com.ramosoft.mywiki.ui.category

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_article_detail.*
import com.ramosoft.mywiki.R
import com.ramosoft.mywiki.data.entities.CategoryModel

class CategoryDetailActivity : AppCompatActivity() {

    private var currentPage: CategoryModel.Query.Allcategory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

//        wikiManager = (applicationContext as MainApplication).wikiManager

        setSupportActionBar(toolBar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val wikiPageJson = intent.getStringExtra("page")
        currentPage = Gson().fromJson<CategoryModel.Query.Allcategory>(wikiPageJson, CategoryModel.Query.Allcategory::class.java)


        supportActionBar?.title = currentPage?.category

        article_detail_webview?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
        currentPage!!.category?.let { article_detail_webview.loadUrl("https://en.wikipedia.org/w/index.php?title="+it) }

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.article_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item!!.itemId == android.R.id.home) {
//            finish()
//        }
//        else if (item.itemId == R.id.action_favorite) {
//            try {
//                if(wikiManager!!.getIsFavorite(currentPage!!.pageid!!)) {
//                    wikiManager!!.removeFavorite(currentPage!!.pageid!!)
//                    //FancyToast.makeText(this,"Article removed from favorites", FancyToast.LENGTH_LONG, FancyToast.INFO,false).show()
//                } else {
//                    wikiManager!!.addFavorites(currentPage!!)
//                    //FancyToast.makeText(this,"Article added to favorite", FancyToast.LENGTH_LONG, FancyToast.SUCCESS,false).show()
//                }
//            } catch (ex: Exception) {
//                //FancyToast.makeText(this,"Unable to update this article.", FancyToast.LENGTH_LONG, FancyToast.ERROR,false).show()
//            }
//        }
//
//        return true
//    }

}