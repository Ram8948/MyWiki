package com.ramosoft.mywiki.data.remote

import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val ApiService: ApiService
): BaseDataSource() {
    suspend fun getImageinfo(id: Int) = getResult { ApiService.getImageinfo(id) }
    suspend fun getImageinfos() = getResult { ApiService.getAllImageinfos()}
    suspend fun getCategories() = getResult { ApiService.getCategories() }
    suspend fun getArticles() = getResult { ApiService.getArticles()}

    suspend fun getImageinfosNext(string: String) = getResult { ApiService.getAllImageinfosNext(string)}
    suspend fun getCategoriesNext(string: String) = getResult { ApiService.getCategoriesNext(string) }
    suspend fun getArticlesNext(string: String) = getResult { ApiService.getArticlesNext(string)}
}