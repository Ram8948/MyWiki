package com.ramosoft.mywiki.ui.images

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramosoft.mywiki.data.repository.ImageinfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageinfosViewModel @ViewModelInject constructor(
    private val repository: ImageinfoRepository
) : ViewModel() {

    val Imageinfos = repository.getImageinfos()
}
