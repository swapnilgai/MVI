package com.example.detail.domain.usecase

import com.example.core.utils.IoDispatcher
import com.example.detail.data.repository.Detailrepository
import com.example.detail.domain.mapper.toArticle
import com.example.detail.domain.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

interface GetDetailUseCase {

    fun getDetails(articleId: String): Flow<Article?>

}

internal class GetDetailUseCaseImpl @Inject constructor(@IoDispatcher val dispatcher: CoroutineContext, val detailrepository: Detailrepository): GetDetailUseCase{
    override fun getDetails(articleId: String): Flow<Article?> = flow {
        val resut = detailrepository.getArticleDetail(articleId)?.toArticle()
        emit(resut)
    }.flowOn(dispatcher)
}

