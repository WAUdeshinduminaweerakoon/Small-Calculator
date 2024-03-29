package com.waudeshindumina.uicalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        button_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        button_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        button_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        button_decimal_number.setOnClickListener {
            input.text = addToInputText(".")
        }
        button_addition.setOnClickListener {
            input.text = addToInputText("+")
        }
        button_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        button_multiply.setOnClickListener {
            input.text = addToInputText("×")//alt 0215
        }
        button_division.setOnClickListener {
            input.text = addToInputText("÷")//alt 0247
        }
        button_equal_sign.setOnClickListener {
            showResult()
        }
        var button_BMI = findViewById<Button>(R.id.button_BMI)
        button_BMI.setOnClickListener {
            val intent1 = Intent (this,BMICalculation::class.java)
            startActivity(intent1)
        }
    }

    private fun addToInputText(buttonValue: String):String {
        return "${input.text}$buttonValue"
    }
    private fun getInputExpression(): String {
        var expression=input.text.replace(Regex ("÷"),"/")
        expression = expression.replace(Regex("×"),"*" )
        return expression
        }


    private fun showResult() {
        try {
            val expression=getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                //Show Error Message
                output.text="Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }else{
                //Show Result
                output.text=DecimalFormat("=    0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.purple))
            }
        } catch (e: Exception) {
            //Show Error Message
            output.text="Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.red))

        }

    }


}