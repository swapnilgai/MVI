package com.example.home.data.repository

import com.example.home.data.HomeApi
import com.example.home.data.model.LatestNewsNetworkResponse
import com.example.network.extensions.handleCall

interface HomeRepository {
    suspend fun getLatestNews(): LatestNewsNetworkResponse
}

internal class HomeRepositoryImpl(val homeApi: HomeApi): HomeRepository {

    override suspend fun getLatestNews(): LatestNewsNetworkResponse {
       return handleCall {
           homeApi.getLatestNews()
       }
    }
}