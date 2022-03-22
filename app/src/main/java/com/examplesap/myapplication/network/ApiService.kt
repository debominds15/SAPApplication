package com.examplesap.myapplication.network

import com.examplesap.myapplication.data.User
import retrofit2.http.GET

interface ApiService {
    @GET("v1/99066355-8f5e-4c9d-b400-d5bdf26911b6")
    fun getUsers(): List<User>
}