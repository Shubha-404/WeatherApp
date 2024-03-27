package com.example.weatherapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.weatherapp.location.LatandLong
import com.example.weatherapp.location.LocationManager
import com.example.weatherapp.screens.HomeScreen


class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val locationManager = LocationManager()
            val userLocation = locationManager.getUserLocation(context = this@MainActivity)

            // Now you can use the userLocation data as needed
            Log.d("MainActivity", "User Location: ${userLocation.latitude}, ${userLocation.longitude}")
            App(userLocation)
        }
    }
}



@Composable
fun App(userLocation:LatandLong) {
    HomeScreen(userLocation)
}

