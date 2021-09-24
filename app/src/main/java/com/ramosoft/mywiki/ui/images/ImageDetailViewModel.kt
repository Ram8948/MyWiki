package com.ramosoft.mywiki.ui.images

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ramosoft.mywiki.data.entities.ImageModel
import com.ramosoft.mywiki.data.repository.Repository
import com.ramosoft.mywiki.utils.Resource

class ImageDetailViewModel  @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _character = _id.switchMap { id ->
        repository.getImageinfo(id)
    }
    val character: LiveData<Resource<ImageModel.Query.MapValue.Imageinfo>> = _character


    fun start(id: Int) {
        _id.value = id
    }

}