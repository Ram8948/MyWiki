package com.ramosoft.mywiki.data.remote

import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.data.entities.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/w/api.php?action=query&format=json&list=allimages&formatversion=2&ailimit=20")
    suspend fun getAllImageinfos() : Response<ImageModel>

    @GET("Imageinfo/{id}")
    suspend fun getImageinfo(@Path("id") id: Int): Response<ImageModel.Query.Allimage>

    @GET("w/api.php?action=query&list=allcategories&formatversion=2&format=json")
    suspend fun getCategories() : Response<CategoryModel>

    @GET("w/api.php?action=query&format=json&formatversion=2&generator=random&grnnamespace=0&prop=pageimages|info&grnlimit=20&inprop=url&pithumbsize=200")
    suspend fun getArticles() : Response<ArticleModel>
}