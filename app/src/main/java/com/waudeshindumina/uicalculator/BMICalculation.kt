package com.waudeshindumina.uicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BMICalculation : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculation)
        var button_Calculator = findViewById<Button>(R.id.button_Calculator)
        button_Calculator.setOnClickListener {
            val intent2 = Intent (this,MainActivity::class.java)
            startActivity(intent2)
        }
    }
}