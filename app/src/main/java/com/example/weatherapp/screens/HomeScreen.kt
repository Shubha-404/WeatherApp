package com.example.weatherapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.cards.CurrentWeatherCard
import com.example.weatherapp.cards.LocationCard
import com.example.weatherapp.models.retrofitInstance

@Preview
@Composable
fun HomeScreen(){
    LazyColumn(
        modifier = Modifier
            .background(Color(255, 255, 255))
    ){
        item{
            LocationCard()
        }
        item{
            CurrentWeatherCard()
        }
        item {
            Button(
                onClick = {
                    Log.d("APICALL", "Button Clicked")
                    retrofitInstance().retrofitData(this){

                    }

                },
                colors = ButtonDefaults.buttonColors(Color(0,100,70), Color(255,255,255)),
                modifier = Modifier
                    .padding(all = 10.dp)
                    .height(60.dp)
                    .width(150.dp)

            ) {
                
            }
        }
    }
}