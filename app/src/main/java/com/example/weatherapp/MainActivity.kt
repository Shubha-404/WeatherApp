package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapp.models.retrofitInstance
import com.example.weatherapp.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            WeatherAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    App()
//                }
//            }
//            retrofitInstance().retrofitData(this){
//
//            }
            App()
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun App(){
    HomeScreen()
}


