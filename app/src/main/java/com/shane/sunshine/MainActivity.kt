package com.shane.sunshine

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = WeatherAdapter(demoData()){
            val fragment = WeatherDetailsFragment.newInstance(it)
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(android.R.id.content, fragment)
            fragmentTransaction.commit()
        }

        weather_recycler_view.layoutManager = layoutManager
        weather_recycler_view.addItemDecoration(DividerItemDecoration(this))
        weather_recycler_view.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                return true
            }
            R.id.action_refresh -> {
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun demoData() : List<Weather> {
        val unixTimes = listOf(1498586400, 1498597200, 1498608000, 1498618800, 1498629600, 1498640400, 1498651200)
        val forecast = "Clear"
        val highTemperature = 17.0
        val lowTemperature = 16.0
        val icon = "https://cdn.slant.co/3da1b1be-795f-4285-8009-443de1400553/-/format/jpeg/-/progressive/yes/-/preview/480x480/"
        val humidity = 90.0
        val pressure = 1010.9
        val windSpeed = 1.06
        val windDegree = 166.0

        val weatherItems = mutableListOf<Weather>()

        unixTimes.map { unix ->
            val date = unix.toDate()
            val weather = Weather(date=date,
                    forecast=forecast,
                    highTemperature=highTemperature,
                    lowTemperature=lowTemperature,
                    icon=icon,
                    humidity=humidity,
                    pressure=pressure,
                    windSpeed=windSpeed,
                    windDegree=windDegree)
            weatherItems.add(weather)
        }

        return weatherItems
    }
}
