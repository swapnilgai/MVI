package com.example.network.Interceptors

import com.example.core.utils.ServerEnvironment
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

internal class HttpAuthInterceptor(val serverEnvironment: ServerEnvironment) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
       val requestWithAuth =  addAuthKey(chain.request())
       return chain.proceed(requestWithAuth)
    }

    private fun addAuthKey(originalRequest: Request): Request {

        val urlWithApiKey = originalRequest.url.newBuilder()
            .addQueryParameter("apikey", serverEnvironment.apiKey)
            .build()

        val newRequest : Request = originalRequest.newBuilder().url(urlWithApiKey).build()

        return newRequest
    }
}