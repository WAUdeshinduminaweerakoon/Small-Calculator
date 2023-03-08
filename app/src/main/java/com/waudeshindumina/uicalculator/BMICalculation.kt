package com.waudeshindumina.uicalculator

import android.annotation.SuppressLint
import kotlinx.android.parcel.Parcelize
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmicalculation.*

private fun Nothing?.setOnClickListener(function: () -> Unit) {

}

class BMICalculation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculation)

        var button_Calculator = findViewById<Button>(R.id.button_Calculator)
        button_Calculator.setOnClickListener {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }

        val btnCalculate = null
          btnCalculate.setOnClickListener {

            if (!edtWeight.text.toString().equals("") && !edtHeightFt.text.toString().equals("") && !edtHeightIn.text.toString().equals("")){
                val wt = (edtWeight.text.toString().toDouble())
                val htFeet = (edtHeightFt.text.toString().toDouble())
                val htInch = (edtHeightIn.text.toString().toDouble())

                val totalInch = (htFeet*12) + htInch;
                val totalCM = totalInch * 2.54

                val totalM = totalCM/100

                val bmi = wt/(totalM*totalM  )

                if (bmi>25){
                    Toast.makeText(this@BMICalculation,"You're OverWeight",Toast.LENGTH_LONG).show();
                }


        }else{
            Toast.makeText(this@BMICalculation,"Please fill ip all the required ",Toast.LENGTH_LONG).show();
            }
            }

    }
}