package com.example.auular;

import com.example.auular.domain.Hotel
import com.example.auular.domain.LoginTutor
import com.example.auular.domain.PetTutor
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.POST

interface ApiUsuario {
    @POST("/petTutors/autentication")
    fun getLogin(@Body loginTutor: LoginTutor) : Call<PetTutor>

    @GET("/hotels")
    fun getHotels() : Call<List<Hotel>>

    @POST("/petTutors/")
    fun postPetTutor(@Body petTutor: PetTutor) : Call<PetTutor>


}
