package com.ramosoft.mywiki.data.repository

import com.ramosoft.mywiki.data.entities.ImageModel
import com.ramosoft.mywiki.data.local.ImageinfoDao
import com.ramosoft.mywiki.data.remote.RemoteDataSource
import com.ramosoft.mywiki.utils.performGetOperation
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: ImageinfoDao
) {

    fun getImageinfo(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getImageinfo(id) },
        networkCall = { remoteDataSource.getImageinfo(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getCategories() = performGetOperation(
        databaseQuery = { localDataSource.getCategories() },
        networkCall = { remoteDataSource.getCategories() },
        saveCallResult = { localDataSource.insertAllCategory(it.query.allcategories) }
    )
    fun getArticles() = performGetOperation(
        databaseQuery = { localDataSource.getArticles() },
        networkCall = { remoteDataSource.getArticles() },
        saveCallResult = { localDataSource.insertArticles(it.query.pages) }
    )
    fun getImageinfos() = performGetOperation(
        databaseQuery = { localDataSource.getAllImageinfos() },
        networkCall = { remoteDataSource.getImageinfos() },
        saveCallResult = { localDataSource.insertAllImage(it.query.allimages) }
    )

    fun getArticlesNext(string: String) = performGetOperation(
        databaseQuery = { localDataSource.getArticles() },
        networkCall = { remoteDataSource.getArticlesNext(string) },
        saveCallResult = { localDataSource.insertArticles(it.query.pages) }
    )

    fun getImageinfosNext(string: String) = performGetOperation(
        databaseQuery = { localDataSource.getAllImageinfos() },
        networkCall = { remoteDataSource.getImageinfosNext(string) },
        saveCallResult = { localDataSource.insertAllImage(it.query.allimages) }
    )
    fun getCategoriesNext(string: String) = performGetOperation(
        databaseQuery = { localDataSource.getCategories() },
        networkCall = { remoteDataSource.getCategoriesNext(string) },
        saveCallResult = { localDataSource.insertAllCategory(it.query.allcategories) }
    )
}