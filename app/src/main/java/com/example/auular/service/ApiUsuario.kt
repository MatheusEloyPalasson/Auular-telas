package com.example.auular.service;

import com.example.auular.domain.Hotel
import com.example.auular.domain.LoginTutor
import com.example.auular.domain.PetTutor
import okhttp3.ResponseBody

import retrofit2.Call;
import retrofit2.http.Body
import retrofit2.http.GET;
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiUsuario {
    @POST("/petTutors/autentication")
    fun getLogin(@Body loginTutor: LoginTutor): Call<PetTutor>

    @GET("/hotels")
    fun getHotels(): Call<List<Hotel>>

    @GET("/allFieldsByUuid/{hotelUuid}")
    fun getAllHotelFields(hotelUuid: String )


    @POST("/petTutors/")
    fun postPetTutor(@Body petTutor: PetTutor): Call<PetTutor>

    @GET("/images")
    fun getHotelImage(@Query("hotelSlug") hotelSlug: String): Call<ResponseBody>
}
