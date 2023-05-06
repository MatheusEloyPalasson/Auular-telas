package com.example.auular.domain

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import java.net.URL

data class Hotel(
    var name: String,
    @field:SerializedName("email") var email: String,
    @field:SerializedName("password") var password: String,
    val documentId: String,
    var fidelity: Boolean,
    var phoneNumber: String,
    var description: String,
    var isActive: Boolean,
    var isAuthenticated: Boolean,
    var imageByteArray: String
) {
    fun toSlug(): String {
        return removeFirstHyphen(
            this.name.lowercase().split(" ").reduce { acc, string -> "$acc-$string" })
    }

    private fun removeFirstHyphen(slug: String): String {
        return slug.replaceFirst("-", "")
    }
}
