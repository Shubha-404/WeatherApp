package com.example.weatherapp.screens.HomeScreensCards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LocationCard(userLocation:LatandLong) {
    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth(1f)

    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color(128, 237, 153))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_location),
                    contentDescription = "ic_location",
                    modifier = Modifier
                        .fillMaxWidth(0.15f)
                        .scale(1.45f)
                        .padding(all = 2.dp)
                )
//            Spacer(modifier = Modifier.padding(all = 5.dp))
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.padding(all = 3.dp))
                    if(true){   //userLocation.isLocationFetched
                        Text(
                            text = "Gopiballavpur", // TO BE UPDATE FROM API
                            style = TextStyle.Default,
                            fontWeight = FontWeight(600),
                            fontSize = 25.sp,
                            color = Color.Black
                        )

                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "Lat : ${userLocation.latitude}",
                                color = Color(0,0,0)
                            )
                            Spacer(modifier = Modifier.padding(5.dp))
                            Text(
                                text = "Lon : ${userLocation.longitude}",
                                color = Color(0,0,0)
                            )
                        }
                    }
                    else{
                        CircularProgressIndicator(
                            color = Color(0,0,0),
                            strokeWidth = 2.dp,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(all = 4.dp)
                        )
                        Text(
                            text = "Fetching Location...",
                            color = Color(0,0,0)
                        )
                    }
                    Spacer(modifier = Modifier.padding(all = 3.dp))

                }
            }

        }
    }
}

