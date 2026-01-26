package com.example.home.domain.usecase

import com.example.core.utils.IoDispatcher
import com.example.home.data.repository.HomeRepository
import com.example.home.domain.mapper.toDomain
import com.example.home.domain.model.LatestNews
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

interface GetInitialHomeUseCase {
    fun getInitialHome(): Flow<List<LatestNews>>
}

class GetInitialHomeUseCaseImpl @Inject constructor(@IoDispatcher val dispatcher: CoroutineContext, val homeRepository: HomeRepository): GetInitialHomeUseCase{
    override fun getInitialHome(): Flow<List<LatestNews>> = flow {
        val result = homeRepository.getLatestNews().toDomain()
        emit(result)
    }.flowOn(dispatcher)
}