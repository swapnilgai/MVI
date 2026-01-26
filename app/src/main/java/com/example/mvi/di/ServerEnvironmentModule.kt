package com.example.mvi.di

import com.example.core.utils.ServerEnvironment
import com.example.mvi.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServerEnvironmentModule {

    @Provides
    @Singleton
    fun provideServerEnvironment(): ServerEnvironment {
        return object : ServerEnvironment {
            override val baseUrl: String = BuildConfig.BASE_URL
            override val apiKey: String = BuildConfig.API_KEY
        }
    }
}