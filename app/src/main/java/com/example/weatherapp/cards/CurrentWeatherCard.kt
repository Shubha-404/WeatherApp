package com.example.weatherapp.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CurrentWeatherCard() {
    Card (
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .background(Color(0, 0, 0, 1))
            .padding(10.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "16°C",
                fontSize = 80.sp,
                fontWeight = FontWeight(600),
                color = Color(0,0,0),
                modifier = Modifier
                    .background(Color(0,0,0,1))
            )
            Image(
                painter = painterResource(id = R.drawable.ic_rainshower),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                )

            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ){
                Text(text = "Clear 13°C / 30°C",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0,0,0),
                    modifier = Modifier
                        .background(Color(0,0,0,1))
                )
                Spacer(modifier = Modifier.padding(all = 20.dp))
                Text(text = "Air Quality : 300 - Poor",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0,0,0),
                    modifier = Modifier
                        .background(Color(0,0,0,1))
                )
            }
        }
    }
}