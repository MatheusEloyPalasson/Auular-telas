package com.example.auular

data class Address(
    val location : Location
)
data class Location(
    val coordinates : Coordinates)

data class Coordinates(
    val longitude : Double,
    val latitude : Double
)
