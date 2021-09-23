package com.ramosoft.mywiki.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.data.entities.ImageModel

@Dao
interface ImageinfoDao {

    @Query("SELECT * FROM Imageinfo")
    fun getAllImageinfos() : LiveData<List<ImageModel.Query.MapValue.Imageinfo>>

    @Query("SELECT * FROM category_table")
    fun getCategories() : LiveData<List<CategoryModel.Query.Allcategory>>

//    @Query("SELECT * FROM Imageinfos WHERE id = :id")
//    fun getImageinfo(id: Int): LiveData<Imageinfo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllImage(Imageinfos: List<ImageModel.Query.MapValue.Imageinfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategory(Imageinfos: List<CategoryModel.Query.Allcategory>)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(Imageinfo: Imageinfo)


}