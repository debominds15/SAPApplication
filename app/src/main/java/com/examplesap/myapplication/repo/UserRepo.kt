package com.examplesap.myapplication.repo

import com.examplesap.myapplication.data.User
import com.examplesap.myapplication.network.ApiService
import com.examplesap.myapplication.network.RetrofitHelper

class UserRepo {
    fun getUsers(): List<User>{
        val retrofit = RetrofitHelper.getInstance().create(ApiService::class.java)
        return retrofit.getUsers()
    }
}