package com.sample.fitpeo.api

import com.sample.fitpeo.models.AlbumDataItem
import com.sample.fitpeo.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface AlbumAPI {

    @GET(Constants.PHOTO_URl)
    suspend fun getAlbumData(): Response<List<AlbumDataItem>>
}