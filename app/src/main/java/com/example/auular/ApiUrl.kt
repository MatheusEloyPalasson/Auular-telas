package com.example.auular
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUrl {
    var BASE_URL = "http://54.162.20.136:8080"

    fun getApiUsuarios() : ApiUsuario {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuario::class.java)
    }
}