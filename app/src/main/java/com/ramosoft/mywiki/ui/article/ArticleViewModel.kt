package com.ramosoft.mywiki.ui.article

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.ramosoft.mywiki.data.repository.Repository

class ArticleViewModel @ViewModelInject constructor(
    repository: Repository
) : ViewModel() {

    val Imageinfos = repository.getArticles()
}
