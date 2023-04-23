package com.example.auular.domain

import com.google.gson.annotations.SerializedName


data class PetTutor(
    val petTutorId:Integer,
    var name:String,
    @field:SerializedName("email") var email:String,
    @field:SerializedName("password") var password: String,
    val documentId:String,
    var phoneNumber:String,
    var isAuthenticated:Boolean,
    var active:Boolean

)
