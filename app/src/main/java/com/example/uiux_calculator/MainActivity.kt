package com.example.uiux_calculator

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)


    }

    fun onDigit(view: android.view.View) {
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false

    }

    fun onCLear(view: View) {
        tvInput?.text = ""
    }

    fun onDecimalPoint(view: android.view.View) {
        if (lastNumeric && !lastDot) {
            tvInput?.append(".")
            lastNumeric = false
            lastDot = true

        }
    }

    fun onOperator(view: View) {
        tvInput?.text?.let {
            if (lastNumeric && !isOperatorAdded(it.toString())) {
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = true
            }

        }
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains('/')
                    || value.contains('*')
                    || value.contains('+')
                    || value.contains('-')
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    val splitValye = tvValue.split("-")
                    var one = splitValye[0]
                    var two = splitValye[1]

                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    tvInput?.text = (one.toDouble() - two.toDouble()).toString()

                }

            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }


}