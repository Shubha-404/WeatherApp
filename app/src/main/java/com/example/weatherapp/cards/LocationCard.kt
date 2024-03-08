package com.example.weatherapp.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LocationCard() {
    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth(1f)

    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_location),
                contentDescription = "ic_location",
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .padding(all = 5.dp)
            )
//            Spacer(modifier = Modifier.padding(all = 5.dp))
            Text(
                text = "Gopiballavpur",
                style = TextStyle.Default,
                fontWeight = FontWeight(600),
                fontSize = 25.sp,
                color = Color.Black
//                modifier = Modifier
//                    .padding(all = 5.dp)
                )
        }
    }
}

