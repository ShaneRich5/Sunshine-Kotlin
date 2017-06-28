package com.shane.sunshine

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_weather_details.view.*

/**
 * Created by Shane on 6/27/2017.
 */
class WeatherAdapter(val weatherList : List<Weather>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WeatherViewHolder(parent)

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount() = weatherList.size

    inner class WeatherViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_weather)) {
        fun bind(weather: Weather) {
            with(itemView) {
                forecast.text = weather.forecast
                low_temperature.text = weather.lowTemperature.toString()
                high_temperature.text = weather.highTemperature.toString()
                icon.loadImage(weather.icon)

            }
        }
    }
}