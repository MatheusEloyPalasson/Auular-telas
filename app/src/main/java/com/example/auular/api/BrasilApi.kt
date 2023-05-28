package com.example.auular.api

import com.example.auular.service.Brasil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object BrasilApi {
    var BASE_URL = "https://brasilapi.com.br/api/cep/v2/"

    fun findPlace() : Brasil {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(Brasil::class.java)
    }
}