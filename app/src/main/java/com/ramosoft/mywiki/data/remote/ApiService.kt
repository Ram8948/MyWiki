package com.ramosoft.mywiki.data.remote

import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.data.entities.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("w/api.php?action=query&prop=imageinfo&iiprop=timestamp%7Cuser%7Curl&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&utf8")
    suspend fun getAllImageinfos() : Response<ImageModel>

    @GET("Imageinfo/{id}")
    suspend fun getImageinfo(@Path("id") id: Int): Response<ImageModel.Query.MapValue.Imageinfo>

    @GET("/w/api.php?action=query&list=allcategories&acprefix=List+of&formatversion=2&format=json")
    suspend fun getCategories() : Response<CategoryModel>
}