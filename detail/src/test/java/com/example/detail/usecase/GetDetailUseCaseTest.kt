package com.example.detail.usecase

import com.example.core.utils.IoDispatcher
import com.example.detail.data.model.ArticleNetworkResponse
import com.example.detail.data.repository.Detailrepository
import com.example.detail.domain.mapper.toArticle
import com.example.detail.domain.model.Article
import com.example.detail.domain.usecase.GetDetailUseCase
import com.example.detail.domain.usecase.GetDetailUseCaseImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetDetailUseCaseTest {
    private lateinit var detailrepository: Detailrepository
    private lateinit var getDetailUseCase: GetDetailUseCase

    private lateinit var dispatcher: CoroutineContext

    private lateinit var articleNetworkResponse: ArticleNetworkResponse

    @Before
    fun setUp(){
        detailrepository = mockk()
        dispatcher = Dispatchers.Unconfined
        getDetailUseCase = GetDetailUseCaseImpl(dispatcher, detailrepository)
        articleNetworkResponse = mockk(relaxed = true)
    }

    @Test
    fun `test getDetails returns expected Article`() = runTest {

        coEvery { detailrepository.getArticleDetail("id") } returns articleNetworkResponse

        val result = getDetailUseCase.getDetails("id").firstOrNull()

        Assert.assertEquals(articleNetworkResponse.toArticle(), result)

    }

}
