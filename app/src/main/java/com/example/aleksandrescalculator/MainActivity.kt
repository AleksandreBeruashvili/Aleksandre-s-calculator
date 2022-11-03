package com.example.aleksandrescalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var Result: TextView
    private var Operand = 0.0
    private var operation= ""


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Result = findViewById(R.id.Result)

    }


    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {
            if ((Result.text.toString() != "Error") and (Result.text.toString() != "Error")) {
                var text = Result.text.toString()
                val number = clickedView.text.toString()

                if (text == "0") {
                    text = ""
                }
                val num = text + number
                Result.text = num
            }
        }
    }

    fun  operationClick(clickedView: View) {
        if (clickedView is TextView){
            if (Result.text.toString() != "") {
                Operand = Result.text.toString().toDouble()
                operation = clickedView.text.toString()
                Result.text = ""
            }
            else {operation=clickedView.text.toString()}

        }

    }

    fun clickEquals(clickedView: View) {
        if (clickedView is TextView){
            if (Result.text.toString() != "") {
                var lastResult = 0.0
                val secondOperand = Result.text.toString().toDouble()
                when(operation){
                    "+" -> lastResult = Operand + secondOperand
                    "/" -> lastResult = Operand / secondOperand
                    "*" -> lastResult = Operand * secondOperand
                    "-" -> lastResult = Operand - secondOperand
                }
                if (lastResult.toString().slice(lastResult.toString().length - 2 until lastResult.toString().length) == ".0"){
                    Result.text = lastResult.toString().slice(0 .. lastResult.toString().length - 3)
                }
                else {Result.text = lastResult.toString() }

                operation = ""
                Operand = 0.0
            }
        }
    }

    fun clickClear(clickedView: View) {
        if (clickedView is TextView) {
            operation = ""
            Operand = 0.0
            Result.text = "0"
        }
    }

    fun clickDel(clickedView: View) {
        if (clickedView is TextView) {
            if ((Result.text.toString() != "Error") and (Result.text.toString() != "Error")) {
                if (Result.text.toString() != "0") {
                    Result.text = Result.text.toString().dropLast(1)
                }
                if (Result.text.toString() == "") {
                    Result.text = "0"
                }
            }
        }
    }

    fun clickPoint(clickedView: View) {
        if ((Result.text.toString() != "Error") and (Result.text.toString() != "Error")) {
            if (clickedView is TextView) {
                if (Result.text.toString() == "") {
                    Result.text = "0."
                } else if ("." !in Result.text.toString()) {
                    val Text = Result.text.toString() + "."
                    Result.text = Text
                }
            }
        }
    }
}