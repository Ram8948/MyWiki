package com.ramosoft.mywiki.ui.images

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.ramosoft.mywiki.data.repository.Repository

class ImageinfosViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    val Imageinfos = repository.getImageinfos()
}