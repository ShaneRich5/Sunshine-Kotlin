package com.shane.sunshine

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = MainActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Log.i(TAG, "Demo Data")
        Log.i(TAG, demoData().toString())

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
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
