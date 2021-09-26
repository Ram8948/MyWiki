package com.ramosoft.mywiki.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.data.entities.ImageModel

@Dao
interface ImageinfoDao {

    @Query("SELECT * FROM Imageinfo")
    fun getAllImageinfos() : LiveData<List<ImageModel.Query.Allimage>>

    @Query("SELECT * FROM category_table")
    fun getCategories() : LiveData<List<CategoryModel.Query.Allcategory>>

    @Query("SELECT * FROM article_table")
    fun getArticles() : LiveData<List<ArticleModel.Query.Page>>

    @Query("SELECT * FROM Imageinfo WHERE id = :id")
    fun getImageinfo(id: Int): LiveData<ImageModel.Query.Allimage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImage(Imageinfos: List<ImageModel.Query.Allimage>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategory(Imageinfos: List<CategoryModel.Query.Allcategory>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(Imageinfos: List<ArticleModel.Query.Page>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(Imageinfo: ImageModel.Query.Allimage)


}