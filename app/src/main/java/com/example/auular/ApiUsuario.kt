package com.example.auular;

import com.example.auular.domain.Login
import com.example.auular.domain.PetTutor
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.POST
import retrofit2.http.Query;

interface ApiUsuario {
    @POST("/petTutors/autentication")
    fun getLogin(@Body login: Login) : Call<PetTutor>


}
