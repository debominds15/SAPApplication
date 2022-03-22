package com.examplesap.myapplication.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("image")
    val imageUrl: String? = ""
)