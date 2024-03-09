package com.example.weatherapp.models

import android.util.Log
import androidx.compose.foundation.lazy.LazyItemScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class retrofitInstance {
     fun retrofitData(context: LazyItemScope, callback:(DataModels) -> Unit){
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.chucknorris.io/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)
        val call: Call<DataModels> = service.getCurrentWeatherBylonlat()  //need to pass lon & lat data
        call.enqueue(object : Callback<DataModels> {
            override fun onResponse(call: Call<DataModels>, response: Response<DataModels>) {
                if(response!!.isSuccessful){
                    val data: DataModels = response.body() as DataModels
                    callback(data)
                }
                Log.d("APICALL", "Success")
            }

            override fun onFailure(call: Call<DataModels>, t: Throwable) {
//                Toast.makeText(context,"Request Failed",Toast.LENGTH_SHORT).show()
                Log.d("APICALL", "Failed")
            }

        })
    }
}