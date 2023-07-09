package com.sample.fitpeo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.fitpeo.models.AlbumDataItem
import com.sample.fitpeo.repository.AlbumRepository
import com.sample.fitpeo.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val albumRepository: AlbumRepository):ViewModel(){

    val albumDataList: LiveData<List<AlbumDataItem>>
    get() = albumRepository._albumData
    init {
        viewModelScope.launch {
            albumRepository.getAlbumDataList()
            Log.d(Constants.TAG,"Album Size "+albumDataList.toString())
        }
    }
}