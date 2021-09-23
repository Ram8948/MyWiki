package com.ramosoft.mywiki.data.remote

import javax.inject.Inject

class ImageinfoRemoteDataSource @Inject constructor(
    private val ImageinfoService: ImageinfoService
): BaseDataSource() {

    suspend fun getImageinfos() = getResult { ImageinfoService.getAllImageinfos() }
    suspend fun getImageinfo(id: Int) = getResult { ImageinfoService.getImageinfo(id) }
}