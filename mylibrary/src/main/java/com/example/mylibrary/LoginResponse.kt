package com.example.mylibrary

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val accessToken: String? = null,

)