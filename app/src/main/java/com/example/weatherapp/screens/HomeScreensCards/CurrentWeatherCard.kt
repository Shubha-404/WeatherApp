package com.example.weatherapp.screens.HomeScreensCards

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.DataModels
import kotlin.math.ceil

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrentWeatherCard(weatherData : DataModels) {
    Column (
        modifier = Modifier
            .padding(10.dp)
            .background(Color(0, 0, 0, 0), shape = RoundedCornerShape(10.dp)) //, shape = RoundedCornerShape(10.dp)

    ) {

        Column(     //upper Part of CurrentWeather card
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(87, 204, 153), shape = RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            Spacer(modifier = Modifier.padding(all = 10.dp))
            Box(
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = ceil(weatherData.main.temp - 273.0).toInt().toString(),
                    fontSize = 120.sp,
                    fontWeight = FontWeight(400),
                    color = Color(2, 0, 60, 255),
                    modifier = Modifier
                        .background(Color(0,0,0,1))
                )
                Text(
                    text = "      °",
                    fontSize = 110.sp,
                    fontWeight = FontWeight(400),
                    color = Color(2, 0, 60, 255),
                    modifier = Modifier
                        .background(Color(0,0,0,1))
                )
            }

            Spacer(modifier = Modifier.padding(all = 10.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)

            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.45f)
                        .background(Color(56, 163, 165,0), shape = RoundedCornerShape(10.dp))  //bde0fe

                ){
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var imgurl : String by remember { mutableStateOf("") }
                        imgurl = "https://openweathermap.org/img/wn/" + weatherData.weather[0].icon + "@2x.png"
                        AsyncImage(
                            model = imgurl,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                                .scale(1.5f)
                        )
                        Column {
                            Text(text = weatherData.weather[0].main,
                                fontSize = 17.sp,
                                fontWeight = FontWeight(600),
                                color = Color(0,0,0),
                                modifier = Modifier
                                    .background(Color(0,0,0,1))
                            )
                            Text(text ="(" + weatherData.weather[0].description + ")",
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0,0,0),
                                modifier = Modifier
                                    .background(Color(0,0,0,1))
                            )
                        }

                    }
                }

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth(0.81f)
                        .background(Color(56, 163, 165,0), shape = RoundedCornerShape(10.dp))  //bde0fe
                ){
                    Row(
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = R.drawable.ic_temp), contentDescription = null)
                        Text(text = ceil(weatherData.main.temp_max - 273.0).toString() + "°C"+" / " + ceil(weatherData.main.temp_min - 273.0).toString() + "°C",
                            fontSize = 17.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0,0,0),
                            modifier = Modifier
                                .background(Color(0,0,0,1))
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.padding(10.dp))
        }


        Spacer(modifier = Modifier.padding(10.dp).background(Color(0,0,0,255)))


        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(Color(56, 163, 165), shape = RoundedCornerShape(10.dp))
                .padding(10.dp)

        ){
            var image: Painter
            var title: String
            var value: String
            var unit: String
            var color: Color = Color(0, 75, 85, 255)
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                image = painterResource(id = R.drawable.ic_humidity)
                title= "Humidity"
                value= weatherData.main.humidity.toString()
                unit= "%"
                Blob(image,title,value,unit,color)

                image = painterResource(id = R.drawable.ic_temp)
                title= "Feels like"
                value= ceil(weatherData.main.feels_like - 273).toString()
                unit= "°C"
                if(value >= 30.toString()){
                    color= Color(94, 0, 0, 205)
                }
                Blob(image,title,value,unit,color)

                image = painterResource(id = R.drawable.ic_pressure)
                title= "Air pressure"
                value= (weatherData.main.pressure).toString()
                unit= "hPa"
                Blob(image,title,value,unit,color)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth(1f)
            ) {
                image = painterResource(id = R.drawable.ic_wind)
                title= "Wind"
                value= ceil(weatherData.wind.speed * 3.6).toString()
                unit= "Km/h"
                Blob(image,title,value,unit,color)

                image = painterResource(id = R.drawable.ic_visibility)
                title= "Visibility"
                value= ceil((weatherData.visibility / 1000).toDouble()).toString()
                unit= "Km"
                Blob(image,title,value,unit,color)

                image = painterResource(id = R.drawable.ic_clouds)
                title= "Clouds"
                value= (weatherData.clouds.all).toString()
                unit= "%"
                Blob(image,title,value,unit,color)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun Blob(
    image: Painter = painterResource(id = R.drawable.ic_pressure),
    title: String = "Air Pressure",
    value: String = "755",
    unit: String = "mmHg",
    color: Color = Color(0, 75, 85, 255)
){
    Box(
        modifier = Modifier
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(color, Color.Black),
                    radius = 120f
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .height(120.dp)
            .width(110.dp)
            .padding(10.dp)
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = image ,
                contentDescription = "ic",
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .padding(1.dp)
            )
            Text(
                text = title,
                fontSize = 17.sp,
                fontWeight = FontWeight(400),
                color = Color(255, 255, 255, 205),
                modifier = Modifier
                    .background(Color(0, 0, 0, 1))
                    .padding(1.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = (value),
                    fontSize = 28.sp,
                    fontWeight = FontWeight(600),
                    color = Color(255, 255, 255, 255),
                    modifier = Modifier
                        .background(Color(0, 0, 0, 1))
                        .padding(1.dp)
                )
                Text(
                    text = (" " + unit),
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color(255, 255, 255, 255),
                    modifier = Modifier
                        .background(Color(0, 0, 0, 1))
                        .padding(1.dp)

                )
            }

        }
    }
}