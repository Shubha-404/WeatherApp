package com.example.weatherapp.screens.HomeScreensCards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.location.LatandLong
import com.example.weatherapp.models.DataModels
import java.text.SimpleDateFormat
import java.util.Locale

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LocationCard(userLocation:LatandLong,weatherData:DataModels?) {

    Box {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color(0, 0, 0, 0))
        ) {
            Image(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "ic_location",
                modifier = Modifier
                    .fillMaxWidth(0.15f)
                    .scale(1.45f)
                    .padding(all = 2.dp)
            )

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.padding(all = 3.dp))
                if(userLocation.isLocationFetched){   //userLocation.isLocationFetched
                    if (weatherData != null) {
                        Text(
                            text = weatherData.name + "," + weatherData.sys.country,        // TO BE UPDATE FROM API
                            style = TextStyle.Default,
                            fontWeight = FontWeight(600),
                            fontSize = 25.sp,
                            color = Color.White
                        )
                    }
                    else {
                        CircularProgressIndicator(
                            color = Color(255,255,255),
                            strokeWidth = 2.dp,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(all = 4.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Text(
                            text = "Lat : ${userLocation.latitude}",
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            text = "Lon : ${userLocation.longitude}",
                            color = Color.White
                        )
                    }
                }
                else{
                    CircularProgressIndicator(
                        color = Color(255,255,255),
                        strokeWidth = 2.dp,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(all = 4.dp)
                    )
                    Text(
                        text = "Fetching Location...",
                        color = Color(255,255,255)
                    )
                }
                Spacer(modifier = Modifier.padding(all = 3.dp))
            }

//            val currentTime = System.currentTimeMillis()
//            val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
//            val formattedTime = dateFormat.format(currentTime)
//            Text(
//                text = "Time: $formattedTime",
//                color = Color.White
//            )
        }
    }
}

