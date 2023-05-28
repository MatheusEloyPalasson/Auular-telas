package com.example.auular.api
import com.example.auular.service.ApiUsuario
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUrl {
//    var BASE_URL = "http://192.168.0.11:8080"

    var BASE_URL = "http://54.162.20.136:8080"
//    var BASE_URL = "http://172.26.16.1:8080"

    fun getApiUsuarios() : ApiUsuario {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiUsuario::class.java)
    }
}