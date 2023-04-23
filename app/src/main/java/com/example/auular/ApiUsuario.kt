package com.example.auular;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiUsuario {
    @GET("usuarios")
    fun getLogin(@Query("login_senha") loginSenha: String) : Call<List<PetTutor>>


}
