package com.ramosoft.mywiki.data.remote

import com.ramosoft.mywiki.data.entities.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ImageinfoService {
    @GET("w/api.php?action=query&prop=imageinfo&iiprop=timestamp%7Cuser%7Curl&generator=categorymembers&gcmtype=file&gcmtitle=Category:Featured_pictures_on_Wikimedia_Commons&format=json&utf8")
    suspend fun getAllImageinfos() : Response<ImageModel>

    @GET("Imageinfo/{id}")
    suspend fun getImageinfo(@Path("id") id: Int): Response<ImageModel.Query.MapValue.Imageinfo>
}