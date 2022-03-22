package com.examplesap.myapplication.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val url = "https://mocki.io/v1"

    fun getInstance(): Retrofit {
        val logInterceptor = HttpLoggingInterceptor()
        val client = OkHttpClient.Builder().addInterceptor(logInterceptor).build()
        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}