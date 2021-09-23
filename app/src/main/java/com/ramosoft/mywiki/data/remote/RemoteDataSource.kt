package com.ramosoft.mywiki.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val ApiService: ApiService
): BaseDataSource() {

    suspend fun getImageinfos() = getResult { ApiService.getAllImageinfos() }
    suspend fun getImageinfo(id: Int) = getResult { ApiService.getImageinfo(id) }
    suspend fun getCategories() = getResult { ApiService.getCategories() }
}