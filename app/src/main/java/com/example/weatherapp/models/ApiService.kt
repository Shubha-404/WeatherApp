package com.example.weatherapp.models

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather?")
    fun getCurrentWeatherBylonlat(
        @Query("lon") lon:Double=88.3639,
        @Query("lat")   lat:Double=22.5726,
        @Query("appid") appid: String = "576d3871da72c4270cafa5f2725692a5"
    ) : Call<DataModels>
}