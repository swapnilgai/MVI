package com.example.core.di

import com.example.core.BuildConfig
import com.example.core.utils.ServerEnvironment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ServerEnvironmentModule {

    @Provides
    fun provideServerEnvironment(): ServerEnvironment {
        return object : ServerEnvironment {
            override val baseUrl: String = BuildConfig.BASE_URL
            override val apiKey: String = BuildConfig.API_KEY
        }
    }
}