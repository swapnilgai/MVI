package com.example.network.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.core.utils.ServerEnvironment
import com.example.network.Interceptors.HttpAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, serverEnvironment: ServerEnvironment): Retrofit = Retrofit.Builder()
        .baseUrl(serverEnvironment.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    @RequiresApi(Build.VERSION_CODES.O)
    @Provides
    @Singleton
    fun provideHttpClient(
        httpAuthInterceptorProvider: HttpAuthInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Duration.ofSeconds(10))
            .readTimeout(Duration.ofSeconds(30))
            .writeTimeout(Duration.ofSeconds(30))
            .addInterceptor(httpAuthInterceptorProvider)
            .build()
    }

    @Singleton
    @Provides
    fun provideHttpAuthInterceptor(serverEnvironment: ServerEnvironment): HttpAuthInterceptor {
        return HttpAuthInterceptor(serverEnvironment)
    }

}