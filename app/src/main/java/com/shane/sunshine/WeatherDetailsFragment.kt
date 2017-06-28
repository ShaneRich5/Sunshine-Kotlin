package com.shane.sunshine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WeatherDetailsFragment : Fragment() {

    private lateinit var weather: Weather

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            weather = arguments.getSerializable(ARG_WEATHER) as Weather
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_weather_details, container, false)
        val humidityTextView = rootView.findViewById(R.id.humidity) as TextView


        humidityTextView.text = "Humity: ${weather.humidity}"


        return rootView
    }

    companion object {
        private val ARG_WEATHER = "ARG_WEATHER"

        fun newInstance(weather: Weather): WeatherDetailsFragment {
            val fragment = WeatherDetailsFragment()
            val args = Bundle()
            args.putSerializable(ARG_WEATHER, weather)
            fragment.arguments = args
            return fragment
        }
    }
}
