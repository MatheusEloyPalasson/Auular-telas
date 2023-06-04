package com.example.auular.domain;

data class HotelAddress(
    val hotelId: Int,
    val hotelUuid: String,
    val addressCode: String,
    val addressStreet: String,
    val addressNumber: String,
    val addressComplement: String,
    val addressDistrict: String,
    val addressCity: String,
    val addressState: String
)
