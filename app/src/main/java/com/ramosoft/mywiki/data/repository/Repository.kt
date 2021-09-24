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

    fun getImageinfos() = performGetOperation(
        databaseQuery = { localDataSource.getAllImageinfos() },
        networkCall = { remoteDataSource.getImageinfos() },
        saveCallResult = { localDataSource.insertAllImage(getImageList(it.query.pages)) }
    )

    fun getImageList(map: Map<Int, ImageModel.Query.MapValue>):List<ImageModel.Query.MapValue.Imageinfo>
    {
        val items = ArrayList<ImageModel.Query.MapValue.Imageinfo>()
        map.forEach { (key, value) -> items.addAll(value.imageinfo) }
        return items
    }
}