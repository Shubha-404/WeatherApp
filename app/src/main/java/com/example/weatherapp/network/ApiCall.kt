package com.example.weatherapp.network

import android.annotation.SuppressLint
import android.util.Log
import com.example.weatherapp.models.DataModels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("NotConstructor")
fun ApiCall(lat: Double, lon:Double,callback: (DataModels?) -> Unit){
    val call=ApiClient.apiService.getCurrentWeatherBylonlat(lat,lon);
    call.enqueue(object: Callback<DataModels> {
        override fun onResponse(
            call: Call<DataModels>,
            response: Response<DataModels>
        ) {
            if (response.isSuccessful) {
                val result = response.body()
                Log.d("APICALL", "Call Sucessful")
                callback(result)
            } else {
                Log.d("APICALL", "Call Error")
                val errorBody = response.errorBody()?.string()
                Log.e("APICALL", "Error Body: $errorBody")
                callback(null)
            }
        }

        override fun onFailure(call: Call<DataModels>, t: Throwable) {
            Log.d("APICALL", "Call Failure: ${t.message}")
            t.printStackTrace()
            callback(null)
        }
    })
}