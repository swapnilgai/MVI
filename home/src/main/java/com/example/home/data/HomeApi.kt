package com.example.home.data

import com.example.home.data.model.LatestNewsNetworkResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {
    @GET("1/latest")
    suspend fun getLatestNews(): Response<LatestNewsNetworkResponse>
}