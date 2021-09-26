//package com.ramosoft.mywiki.ui.article
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.ramosoft.mywiki.data.repository.Repository
//
//class ArticleViewModelFactory(private val string: String) : ViewModelProvider.Factory {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
//            return ArticleViewModel(Repository,string) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }