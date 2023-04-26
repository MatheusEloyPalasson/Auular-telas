package com.example.auular

import retrofit2.Call;
import retrofit2.http.*

interface Brasil {
    @GET("{cep}")
    fun buscar(@Path("cep") cep: Number): Call<Address>
}