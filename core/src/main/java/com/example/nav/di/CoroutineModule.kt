package com.example.nav.di

import com.example.nav.utils.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoroutineModule{
    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineContext{
       return Dispatchers.IO
    }
}