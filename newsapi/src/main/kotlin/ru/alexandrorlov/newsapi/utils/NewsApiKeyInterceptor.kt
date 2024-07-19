package ru.alexandrorlov.newsapi.utils

import okhttp3.Interceptor
import okhttp3.Response

internal class NewsApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("X-Api-Key", apiKey)
                .build()
        )
}