package com.example.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.weatherapp.cards.CurrentWeatherCard
import com.example.weatherapp.cards.LocationCard

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
    }
}