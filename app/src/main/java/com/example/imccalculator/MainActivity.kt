package com.example.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightEditText: EditText
    lateinit var weightEditText: EditText
    lateinit var calculateButton : Button
    lateinit var resultadoIMC : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        heightEditText = findViewById(R.id.alturaText)
        weightEditText = findViewById(R.id.pesoText)
        calculateButton = findViewById(R.id.calculateButton)
        resultadoIMC = findViewById(R.id.resultadoIMC)



        calculateButton.setOnClickListener {
            var altura= heightEditText.text.toString().toDouble()
            var peso= heightEditText.text.toString().toDouble()

//            val result = weight / (height / 100).pow(2)
            val resultado= peso/(altura/100).pow(2)
            resultadoIMC.text="$resultado"
        }
    }
}