package com.shane.sunshine.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Shane on 6/28/2017.
 */
interface WeatherApi {
    @GET("/data/2.5/forecast")
    fun getForecast(@Query("q") location: String): Observable<WeatherResponse>
}

class WeatherResponse

class ForecastResponse(
        val cod: String,
        val message: Double,
        val cnt: Long,
        val list: List<WeatherResponse>
)