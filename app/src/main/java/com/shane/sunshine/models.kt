package com.shane.sunshine

import java.io.Serializable
import java.util.*

/**
 * Created by Shane on 6/26/2017.
 */
data class Weather(
        val highTemperature: Double,
        val lowTemperature: Double,
        val date: Date,
        val forecast: String,
        val icon: String,
        val humidity: Double,
        val pressure: Double,
        val windSpeed: Double,
        val windDegree: Double) : Serializable
