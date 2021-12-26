package com.example.uiux_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: android.view.View) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()


    }
}