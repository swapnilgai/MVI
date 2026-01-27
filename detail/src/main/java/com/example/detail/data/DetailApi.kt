package com.example.detail.data

import com.example.detail.data.model.DetailNetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailApi {

    @GET("1/latest")
    suspend fun getNewsDetail(@Query("id") id: String): Response<DetailNetworkResponse>
}
