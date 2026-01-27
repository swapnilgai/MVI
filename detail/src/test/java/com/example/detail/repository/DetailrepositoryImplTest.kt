package com.example.detail.repository

import com.example.detail.data.DetailApi
import com.example.detail.data.model.ArticleNetworkResponse
import com.example.detail.data.model.DetailNetworkResponse
import com.example.detail.data.repository.Detailrepository
import com.example.detail.data.repository.DetailrepositoryImpl
import com.example.network.extensions.handleCall
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import javax.inject.Inject
import kotlin.jvm.Throws


class DetailrepositoryImplTest {

    private lateinit var detailApi: DetailApi

    private lateinit var detailNetworkResponseExpected: DetailNetworkResponse

    private lateinit var detailrepository: Detailrepository

    @Before
    fun setUp(){
        detailApi = mockk<DetailApi>()

        detailNetworkResponseExpected = DetailNetworkResponse(
            status = "ok",
            totalResults = 1,
            results = listOf(mockk<ArticleNetworkResponse>())
        )

        detailrepository = DetailrepositoryImpl(detailApi)
    }

    @Test
    fun `check getArticleDetail returns successfully`() = runTest {

        coEvery { detailApi.getNewsDetail("test") } returns Response.success(detailNetworkResponseExpected)

        val result =  detailrepository.getArticleDetail("test")

        Assert.assertEquals(result, detailNetworkResponseExpected.results.firstOrNull())

    }
}
