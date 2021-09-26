package com.ramosoft.mywiki.data.remote

import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.data.entities.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/w/api.php?action=query&format=json&list=allimages&formatversion=2&ailimit=15")
    suspend fun getAllImageinfos() : Response<ImageModel>

    @GET("Imageinfo/{id}")
    suspend fun getImageinfo(@Path("id") id: Int): Response<ImageModel.Query.Allimage>

    @GET("w/api.php?action=query&list=allcategories&formatversion=2&format=json")
    suspend fun getCategories() : Response<CategoryModel>

    @GET("w/api.php?action=query&format=json&formatversion=2&generator=random&grnnamespace=0&prop=pageimages|info&grnlimit=15&inprop=url&pithumbsize=200")
    suspend fun getArticles() : Response<ArticleModel>

    @GET("w/api.php?action=query&format=json&formatversion=2&generator=random&grnnamespace=0&prop=pageimages|info&grnlimit=15&inprop=url&pithumbsize=200")
    suspend fun getArticlesNext(@Query("continue") continue_txt: String) : Response<ArticleModel>

    @GET("/w/api.php?action=query&format=json&list=allimages&formatversion=2&ailimit=15")
    suspend fun getAllImageinfosNext(@Query("continue") continue_txt: String) : Response<ImageModel>

    @GET("w/api.php?action=query&list=allcategories&formatversion=2&format=json")
    suspend fun getCategoriesNext(@Query("continue") continue_txt: String) : Response<CategoryModel>
}