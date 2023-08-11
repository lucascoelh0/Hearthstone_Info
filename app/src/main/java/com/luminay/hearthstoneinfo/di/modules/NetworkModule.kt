package com.luminay.hearthstoneinfo.di.modules

import com.example.data.remote.api.CardApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.luminay.hearthstoneinfo.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun providesBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun providesConnectionTimeout() = NETWORK_TIMEOUT

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun providesOkHttpClient(
        connectionTimeout: Long,
    ): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        val requestInterceptor = Interceptor { chain ->
            val url = chain.request()
                .url
                .newBuilder()
                .addQueryParameter("locale", LOCALE)
                .build()

            val request = chain.request()
                .newBuilder()
                .addHeader("X-RapidAPI-Key", BuildConfig.API_KEY)
                .addHeader("X-RapidAPI-Host", BuildConfig.API_HOST)
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

        return OkHttpClient
            .Builder()
            .readTimeout(connectionTimeout, TimeUnit.SECONDS)
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesNetworkResponseAdapterFactory(): NetworkResponseAdapterFactory = NetworkResponseAdapterFactory()

    @Singleton
    @Provides
    fun providesRetrofit(
        baseUrl: String,
        gson: Gson,
        client: OkHttpClient,
        networkResponseAdapterFactory: NetworkResponseAdapterFactory
    ): Retrofit =
        getRetrofit(
            baseUrl,
            gson,
            client,
            networkResponseAdapterFactory,
        )

    private fun getRetrofit(
        baseUrl: String,
        gson: Gson,
        client: OkHttpClient,
        networkResponseAdapterFactory: NetworkResponseAdapterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(networkResponseAdapterFactory)
        .build()

    @Singleton
    @Provides
    fun providesCardApi(retrofit: Retrofit): CardApi = retrofit.create(CardApi::class.java)

    companion object {
        private const val BASE_URL = "https://omgvamp-hearthstone-v1.p.rapidapi.com/"
        private const val NETWORK_TIMEOUT = 60L
        private const val LOCALE = "ptBR"
    }
}
