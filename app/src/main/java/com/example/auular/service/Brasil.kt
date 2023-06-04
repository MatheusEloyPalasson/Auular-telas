package com.example.auular.service

import com.example.auular.Address
import retrofit2.Call;
import retrofit2.http.*

interface Brasil {
    @GET("{cep}")
    fun buscar(@Path("cep") cep: String): Call<Address>
}