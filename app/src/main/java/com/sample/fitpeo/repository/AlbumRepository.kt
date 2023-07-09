package com.sample.fitpeo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sample.fitpeo.api.AlbumAPI
import com.sample.fitpeo.models.AlbumDataItem
import javax.inject.Inject

class AlbumRepository @Inject constructor(private val albumAPI: AlbumAPI) {

    private  val albumList = MutableLiveData<List<AlbumDataItem>>()
    val _albumData : LiveData<List<AlbumDataItem>>
    get() = albumList
    suspend fun getAlbumDataList(){
        val result = albumAPI.getAlbumData()
        if (result.isSuccessful && result.body() != null){
            albumList.postValue(result.body())
        }
    }
}