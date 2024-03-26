package com.example.weatherapp.location

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Looper
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import java.util.concurrent.TimeUnit

class LocationManager {
    /**
     * Manages all location related tasks for the app.
     */
    // A callback for receiving notifications from the FusedLocationProviderClient.
    lateinit var locationCallback: LocationCallback
    // The main entry point for interacting with the Fused Location Provider
    lateinit var locationProvider: FusedLocationProviderClient

    @Composable
    @SuppressLint("MissingPermission")
    fun getUserLocation(context: Context): LatandLong {

        // The Fused Location Provider provides access to location APIs.
        locationProvider = LocationServices.getFusedLocationProviderClient(context)

        var currentUserLocation by remember { mutableStateOf(LatandLong()) }

        DisposableEffect(key1 = locationProvider) {
            locationCallback = object : LocationCallback() {
                override fun onLocationResult(result: LocationResult) {

                    /**
                     * Option 1
                     * This option returns the locations computed, ordered from oldest to newest.
                     * */
                    for (location in result.locations) {
                        // Update data class with location data
                        currentUserLocation = LatandLong(location.latitude, location.longitude, true)
                        Log.d("LOCATION_TAG", "${location.latitude},${location.longitude}")
                    }

                    /**
                     * Option 2
                     * This option returns the most recent historical location currently available.
                     * Will return null if no historical location is available
                     * */
                    locationProvider.lastLocation
                        .addOnSuccessListener { location ->
                            location?.let {
                                val lat = location.latitude
                                val long = location.longitude
                                // Update data class with location data
                                currentUserLocation = LatandLong(latitude = lat, longitude = long,true)
                            }
                        }
                        .addOnFailureListener {
                            Log.e("Location_error", "${it.message}")
                        }

                }
            }
            if (hasPermissions(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            ) {
                locationUpdate()
            } else {
                val REQUEST_LOCATION_PERMISSION = 1
                askPermissions(
                    context,
                    REQUEST_LOCATION_PERMISSION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            }

            onDispose {
                stopLocationUpdate()
            }
        }
        return currentUserLocation
    }

    fun stopLocationUpdate() {
        try {
            // Removes all location updates for the given callback.
            val removeTask = locationProvider.removeLocationUpdates(locationCallback)
            removeTask.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("LOCATION_TAG", "Location Callback removed.")
                } else {
                    Log.d("LOCATION_TAG", "Failed to remove Location Callback.")
                }
            }
        } catch (se: SecurityException) {
            Log.e("LOCATION_TAG", "Failed to remove Location Callback.. $se")
        }
    }

    @SuppressLint("MissingPermission")
    fun locationUpdate() {
        locationCallback.let {
            // An encapsulation of various parameters for requesting
            // location through FusedLocationProviderClient.
            val locationRequest: LocationRequest =
                LocationRequest.create().apply {
                    interval = TimeUnit.SECONDS.toMillis(30)
                    fastestInterval = TimeUnit.SECONDS.toMillis(15)
                    maxWaitTime = TimeUnit.MINUTES.toMillis(1)
                    priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                }
            // use FusedLocationProviderClient to request location update
            locationProvider.requestLocationUpdates(
                locationRequest,
                it,
                Looper.getMainLooper()
            )
        }
    }


    private fun hasPermissions(context: Context, vararg permissions: String): Boolean {
        return permissions.all {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun askPermissions(
        context: Context,
        requestCode: Int,
        vararg permissions: String
    ) {
        ActivityCompat.requestPermissions(context as Activity, permissions, requestCode)
    }
}
