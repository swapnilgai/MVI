package com.example.home.domain.repository

import com.example.home.data.HomeApi
import com.example.home.data.model.LatestNewsNetworkResponse
import com.example.home.data.repository.HomeRepository
import com.example.home.data.repository.HomeRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class HomeRepositoryTest {

    private lateinit var homeApi: HomeApi

    private lateinit var homeRepository: HomeRepository

    private val latestNewsNetworkResponse = mockk<LatestNewsNetworkResponse>()

    @Before
    fun setUp(){
        homeApi = mockk<HomeApi>()
        homeRepository = HomeRepositoryImpl(homeApi)
    }

    @Test
    fun `getLatestNews should return LatestNewsNetworkResponse`() = runTest {

        coEvery { homeApi.getLatestNews() } returns Response.success(latestNewsNetworkResponse)

        val result = homeRepository.getLatestNews()

        Assert.assertEquals(result, latestNewsNetworkResponse)
    }
}