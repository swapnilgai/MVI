package com.example.network.Interceptors

import com.example.core.utils.ServerEnvironment
import okhttp3.Interceptor

interface HttpAuthInterceptorProvider {
    val authInterceptor : Interceptor
}

internal class DefaultHttpAuthInterceptorProvider(serverEnvironment: ServerEnvironment) : HttpAuthInterceptorProvider {
    override val authInterceptor: Interceptor = HttpAuthInterceptor(serverEnvironment)
}