package com.example.auular.domain

import com.google.gson.annotations.SerializedName

data class Login(
    @field:SerializedName("email") var email:String,
    @field:SerializedName("password") var password: String,
)

