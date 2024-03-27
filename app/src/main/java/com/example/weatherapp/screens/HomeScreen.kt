package com.example.weatherapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.location.LatandLong
import com.example.weatherapp.models.DataModels
import com.example.weatherapp.network.ApiCall
import com.example.weatherapp.screens.HomeScreensCards.CurrentWeatherCard
import com.example.weatherapp.screens.HomeScreensCards.LocationCard

//@Preview
@Composable
fun HomeScreen(userLocation: LatandLong){
    var weatherData : DataModels? by remember { mutableStateOf(null) }

    if(userLocation.isLocationFetched){   //userLocation.isLocationFetched
        ApiCall(userLocation.latitude,userLocation.longitude){
            weatherData=it
        }
//        ApiCall(24.84,96.43){
//            weatherData=it
//        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        content = {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column {
                LocationCard(userLocation,weatherData)
                LazyColumn(
                    modifier = Modifier
                        .background(Color(0, 0, 0, 0))
                ) {
//                    item {
//                        LocationCard(userLocation)
//                    }

                    // Display CurrentWeatherCard only when weatherData is available
                    weatherData?.let {
                        item {
                            CurrentWeatherCard(weatherData = it)
                        }
                    } ?: run {
                        // Display placeholder or loading indicator when weatherData is not available
                        item {
                            PlaceholderContent()
                        }
                    }
                }
            }
        }
    )

}



@Composable
fun PlaceholderContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Weather data is not available",
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.padding(horizontal = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}
