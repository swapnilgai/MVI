package com.example.home.data.di

import com.example.home.data.HomeApi
import com.example.home.data.repository.HomeRepository
import com.example.home.data.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class HomeModule {

    @Singleton
    @Provides
    fun provideHomeApiService(retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideHomeRepository(homeApi: HomeApi): HomeRepository {
        return HomeRepositoryImpl(homeApi)
    }

}