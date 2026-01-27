package com.example.detail.data.di

import com.example.detail.data.DetailApi
import com.example.detail.data.repository.Detailrepository
import com.example.detail.data.repository.DetailrepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DetailModule {


    @Provides
    @Singleton
    fun provideDetailApi(retrofit: Retrofit): DetailApi {
        return retrofit.create(DetailApi::class.java)
    }
    @Provides
    @Singleton
    fun provideDetailRepository(detailApi: DetailApi): Detailrepository {
        return DetailrepositoryImpl(detailApi)
    }
}