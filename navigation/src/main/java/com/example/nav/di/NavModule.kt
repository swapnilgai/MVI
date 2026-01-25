package com.example.nav.di

import com.example.nav.Navigator
import com.example.nav.navigation.NavigationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavModule{
    @Provides
    fun provideNavigator(navigator: Navigator): NavigationService {
       return navigator
    }
}

// Optional module