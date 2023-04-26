package com.example.auular.domain

import android.widget.EditText
import com.google.gson.annotations.SerializedName


data class PetTutor(
    val name: String,
    var email:String,
    var password: String,
    val documentId: String,
    var phoneNumber: String,
    var isAuthenticated:Boolean,
    var active:Boolean

)
