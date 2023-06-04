package com.example.auular.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.net.URL

data class Hotel(
    val hotelUuid : String,
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
): Parcelable {

    fun toSlug(): String {
        return removeFirstHyphen(
            this.name.lowercase().split(" ").reduce { acc, string -> "$acc-$string" })
    }

    private fun removeFirstHyphen(slug: String): String {
        return slug.replaceFirst("-", "")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        val hotelUuid : String
        var name: String
        var email: String
        var password: String
        val documentId: String
        var fidelity: Boolean
        var phoneNumber: String
        var description: String
        var isActive: Boolean
        var isAuthenticated: Boolean
        var imageByteArray: String
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hotel> {
        override fun createFromParcel(parcel: Parcel): Hotel {
           var hotelUuid: String = parcel.readString().toString();
           var name: String = parcel.readString().toString();
           var email: String = parcel.readString().toString();
           var password: String = parcel.readString().toString();
           var documentId: String = parcel.readString().toString();
           var fidelity: Boolean = parcel.readInt() != 0;
            var phoneNumber: String= parcel.readString().toString();
            var description: String = parcel.readString().toString();
            var isActive: Boolean = parcel.readInt() !=0;
            var isAuthenticated: Boolean = parcel.readInt() !=0;
            var imageByteArray: String = parcel.readString().toString();

            return Hotel(hotelUuid, name, email, password, documentId, fidelity, phoneNumber,
                description, isActive, isAuthenticated, imageByteArray);

        }

        override fun newArray(size: Int): Array<Hotel?> {
            return arrayOfNulls(size)
        }
    }
}


