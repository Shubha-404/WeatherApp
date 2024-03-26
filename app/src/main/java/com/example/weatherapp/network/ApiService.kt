package com.example.weatherapp.network

import com.example.weatherapp.models.DataModels
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getCurrentWeatherBylonlat(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = "576d3871da72c4270cafa5f2725692a5"
    ): Call<DataModels>
}

//API ID : 576d3871da72c4270cafa5f2725692a5
