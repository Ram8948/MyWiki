package com.ramosoft.mywiki.di

import android.content.Context
import com.ramosoft.mywiki.data.local.AppDatabase
import com.ramosoft.mywiki.data.local.ImageinfoDao
import com.ramosoft.mywiki.data.remote.ImageinfoRemoteDataSource
import com.ramosoft.mywiki.data.remote.ImageinfoService
import com.ramosoft.mywiki.data.repository.ImageinfoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://commons.wikimedia.org/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideImageinfoService(retrofit: Retrofit): ImageinfoService = retrofit.create(ImageinfoService::class.java)

    @Singleton
    @Provides
    fun provideImageinfoRemoteDataSource(ImageinfoService: ImageinfoService) = ImageinfoRemoteDataSource(ImageinfoService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideImageinfoDao(db: AppDatabase) = db.ImageinfoDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: ImageinfoRemoteDataSource,
                          localDataSource: ImageinfoDao) =
        ImageinfoRepository(remoteDataSource, localDataSource)
}