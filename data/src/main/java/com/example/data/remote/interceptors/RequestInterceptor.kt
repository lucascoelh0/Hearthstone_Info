package com.example.data.remote.interceptors

import com.example.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RequestInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(LOCALE_STRING, LOCALE_VALUE)
            .build()

        val request = chain.request()
            .newBuilder()
            .addHeader(HEADER_KEY, BuildConfig.API_KEY)
            .addHeader(HEADER_HOST, BuildConfig.API_HOST)
            .url(url)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val LOCALE_STRING = "locale"
        private const val LOCALE_VALUE = "ptBR"
        private const val HEADER_KEY = "X-RapidAPI-Key"
        private const val HEADER_HOST = "X-RapidAPI-Host"
    }
}
