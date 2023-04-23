package com.example.auular.domain

import com.google.gson.annotations.SerializedName

data class Hotel(
    private val hotelId:Integer,
    private var name:String,
    @field:SerializedName("email") var email:String,
    @field:SerializedName("password") var password: String,
    private val documentId:String,
    private var fidelity:Boolean,
    private var phoneNumber:String,
    private var description:String,
    private var isActive:Boolean,
    private var isAuthenticated:Boolean


    )
