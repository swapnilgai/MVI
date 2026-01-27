package com.example.home.domain.usecase

import com.example.home.data.model.ArticleNetwork
import com.example.home.data.model.LatestNewsNetworkResponse
import com.example.home.data.repository.HomeRepository
import com.example.home.domain.mapper.toDomain
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.jvm.Throws

class GetInitialHomeUseCaseTest {

    private lateinit var homeRepository: HomeRepository
    private lateinit var getInitialHomeUseCase: GetInitialHomeUseCase

    val dispatcher = Dispatchers.Unconfined

    val latestNewsNetworkResponse : LatestNewsNetworkResponse = LatestNewsNetworkResponse(
        status = "ok",
        totalResults = 2,
        results = emptyList<ArticleNetwork>()
    )

    @Before
    fun setUp(){
        homeRepository = mockk<HomeRepository>()
        getInitialHomeUseCase = GetInitialHomeUseCaseImpl(dispatcher, homeRepository)
    }


    @Test
    fun `getInitialHome emit expected list of ListNews`() = runTest {


        coEvery { homeRepository.getLatestNews() } returns latestNewsNetworkResponse

       val result = getInitialHomeUseCase.getInitialHome().first()

        assertEquals(latestNewsNetworkResponse.toDomain(), result)

    }
}