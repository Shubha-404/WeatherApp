package com.example.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.weatherapp.cards.CurrentWeatherCard
import com.example.weatherapp.cards.LocationCard
import com.example.weatherapp.models.DataModels
import com.example.weatherapp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//@Preview
@Composable
fun HomeScreen(lat:Double,lon:Double, isLocationFetched:Boolean){
        LazyColumn(
            modifier = Modifier
                .background(Color(255, 255, 255))
        ) {
            item {
                LocationCard(lat, lon,isLocationFetched)
            }
            item {
                CurrentWeatherCard()
            }
            item {
                Button(
                    onClick = {
                        Log.d("APICALL", "Button Clicked")
                        Log.d("APICALL", "Lat: $lat  Lon: $lon")
                        val call = ApiClient.apiService.getCurrentWeatherBylonlat(lat, lon);
                        call.enqueue(object : Callback<DataModels> {
                            override fun onResponse(
                                call: Call<DataModels>,
                                response: Response<DataModels>
                            ) {
                                if (response.isSuccessful) {
                                    val result = response.body()
                                    val windSpeed = result?.wind?.speed
                                    val temp = result?.main?.temp_min?.minus(273.0)
                                    val add = result?.name
                                    Log.d("APICALL", "Call Sucessful")
                                    Log.d(
                                        "APICALL",
                                        "WindSpeed: $windSpeed m/s  Temparature: ${temp} °C  Location: $add"
                                    )
                                } else {
                                    Log.d("APICALL", "Call Error")
                                    val errorBody = response.errorBody()?.string()
                                    Log.e("APICALL", "Error Body: $errorBody")
                                }
                            }

                            override fun onFailure(call: Call<DataModels>, t: Throwable) {
                                Log.d("APICALL", "Call Failure: ${t.message}")
                                t.printStackTrace()
//                            TODO("Not yet implemented")

                            }
                        })

                    },
                    colors = ButtonDefaults.buttonColors(Color(0, 100, 70), Color(255, 255, 255)),

                    modifier = Modifier
                        .padding(all = 10.dp)
                        .height(60.dp)
                        .width(150.dp)

                ) {
                    Text(text = "API Call")
                }
            }

        }

}
