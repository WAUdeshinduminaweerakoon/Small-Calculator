package com.waudeshindumina.uicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmicalculation.*

private fun Nothing?.setOnClickListener(function: () -> Unit) {

}

@Suppress("DEPRECATION")
class BMICalculation : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculation)
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

                  main_text.text = "Your BMI"
                  text_Result.text= "{bmi.toInt()}"


                if (bmi>25){

                        Toast.makeText(this@BMICalculation, R.string.StrOverWt, Toast.LENGTH_LONG).show();
                        text_msg.text= resources.getString(R.string.StUnderWt )
                        BMICalculation_name.setBackgroundColor(resources.getColor(R.color.BMIColorRed))
                }
                  else if (bmi<18) {
                    Toast.makeText(this@BMICalculation,R.string.StUnderWt,Toast.LENGTH_LONG).show();
                    text_msg.text= resources.getString(R.string.StUnderWt)
                    BMICalculation_name.setBackgroundColor(resources.getColor(R.color.BMIColorYellow))

                  }
              }else{
                  Toast.makeText(this@BMICalculation,R.string.StrHealthyWt,Toast.LENGTH_LONG).show();
                  text_msg.text= resources.getString(R.string.StrHealthyWt)}
                  BMICalculation_name.setBackgroundColor(resources.getColor(R.color.BMIColorGreen))
          }
        var button_Calculator = findViewById<Button>(R.id.button_Calculator)
            button_Calculator.setOnClickListener {
                val intent2 = Intent(this, MainActivity::class.java)
                startActivity(intent2)
            }
    }
}