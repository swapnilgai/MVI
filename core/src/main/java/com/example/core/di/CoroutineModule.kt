package com.example.core.di

import com.example.core.utils.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule{
    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineContext {
       return Dispatchers.IO
    }
}