package com.example.home.domain.di

import com.example.core.utils.IoDispatcher
import com.example.home.data.repository.HomeRepository
import com.example.home.domain.usecase.GetInitialHomeUseCase
import com.example.home.domain.usecase.GetInitialHomeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlin.coroutines.CoroutineContext


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetInitialHomeUseCase(@IoDispatcher dispatcher: CoroutineContext, homeRepository: HomeRepository): GetInitialHomeUseCase {
        return GetInitialHomeUseCaseImpl(dispatcher, homeRepository)
    }
}