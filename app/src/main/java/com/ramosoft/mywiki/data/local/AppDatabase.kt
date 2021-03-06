package com.ramosoft.mywiki.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ramosoft.mywiki.data.entities.ArticleModel
import com.ramosoft.mywiki.data.entities.CategoryModel
import com.ramosoft.mywiki.data.entities.ImageModel

@Database(entities = [ImageModel.Query.Allimage::class,CategoryModel.Query.Allcategory::class, ArticleModel.Query.Page::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ImageinfoDao(): ImageinfoDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "Imageinfos")
                .fallbackToDestructiveMigration()
                .build()
    }
}