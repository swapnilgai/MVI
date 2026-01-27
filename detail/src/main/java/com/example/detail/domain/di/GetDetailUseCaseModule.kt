package com.example.detail.domain.di

import com.example.core.utils.IoDispatcher
import com.example.detail.data.repository.Detailrepository
import com.example.detail.domain.usecase.GetDetailUseCase
import com.example.detail.domain.usecase.GetDetailUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.android.scopes.ViewScoped
import kotlin.coroutines.CoroutineContext


@Module
@InstallIn(ViewModelComponent::class)
class GetDetailUseCaseModule {

    @Provides
    @ViewModelScoped
    fun getDetailUseCaseProvider(
        @IoDispatcher dispatcher: CoroutineContext,
        detailrepository: Detailrepository
    ): GetDetailUseCase {
        return GetDetailUseCaseImpl(dispatcher, detailrepository)
    }
}