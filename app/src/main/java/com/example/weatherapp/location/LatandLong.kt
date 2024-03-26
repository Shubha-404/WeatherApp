package com.example.weatherapp.location


data class LatandLong(
    val latitude: Double=0.0,
    val longitude: Double=0.0,
    val isLocationFetched: Boolean = false
)