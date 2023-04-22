package com.example.auular

import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class SpinnerEstado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_estado)

            val estados:Array<String> = resources.getStringArray(R.array.sg_estados)

        val adapter = ArrayAdapter(this, com.mapbox.maps.R.layout.support_simple_spinner_dropdown_item, estados);

    }
}