package com.example.calculator1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var etNum1 : EditText
    lateinit var etNum2 : EditText
    lateinit var btnAdd :Button
    lateinit var btnSubtract : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivide : Button
    lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        castViews()

        btnAdd.setOnClickListener{
        validate("+")
        }
        btnSubtract.setOnClickListener{
            validate("-")

        }
        btnMultiply.setOnClickListener{
            validate("*")
        }
        btnDivide.setOnClickListener{
            validate("/")

        }
    }
    fun castViews(){
        etNum1 = findViewById(R.id.etNum1)
        etNum2 = findViewById(R.id.etNum2)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnAdd = findViewById(R.id.btnAdd)
        btnDivide = findViewById(R.id.btnDivide)
        btnMultiply = findViewById(R.id.btnMultiply)
        tvResult = findViewById(R.id.tvResult)
    }
    fun validate(operation : String){
       val num1 = etNum1.text.toString()
        val num2 = etNum2.text.toString()
        var err = false
        if(num1.isBlank()){
            err = true
            etNum1.error = "Num 1 is required"
        }
        if(num2.isBlank()){
            err = true
            etNum2.error = "Num 2 is required"
        }
        if(!err){
            calculate(num1.toDouble(),num2.toDouble(),operation)
        }

    }


    fun calculate (num1:Double , num2: Double, operation:String){
//        val num1 = etNum1.text.toString().toDouble()
//        val num2 = etNum2.text.toString().toDouble()
        var result = 0.0
        when(operation){
            "+"-> {
                result = num1 + num2
            }
            "-"-> {
                result = num1 - num2
            }
            "*"-> {
                result = num1 * num2
            }
            "/"-> {
                result = num1 / num2
            }
        }
        tvResult.text = result.toString()
    }
}
