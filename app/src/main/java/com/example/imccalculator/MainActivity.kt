package com.example.imccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var heightTextView: TextView
    lateinit var heightSlider:Slider

    lateinit var weightTextView: TextView
    lateinit var weightButtonMinus: Button
    lateinit var weightButtonPlus: Button

    lateinit var calculateButton: Button
    lateinit var resultadoIMC: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        heightTextView =findViewById(R.id.heightTextView)
        heightSlider =findViewById(R.id.slider)

        weightTextView =findViewById(R.id.weightTextView)
        weightButtonPlus =findViewById(R.id.weightPlusButton)
        weightButtonMinus =findViewById(R.id.weightMinusButton)

        calculateButton = findViewById(R.id.calculateButton)
        resultadoIMC = findViewById(R.id.resultadoIMC)


        var height = 170.0f
        var weight = 70.0f


            heightSlider.addOnChangeListener { slider, value, fromUser ->
                height = value
                heightTextView.text = "${height.toInt()}"
            } // revisar la documentaciion para ver donde sale este fargmnto de codigo del Slider

            weightButtonPlus.setOnClickListener(){
                weight++
                weightTextView.text="${weight.toInt()}"
            }
            weightButtonMinus.setOnClickListener(){
            weight--
            weightTextView.text="${weight.toInt()}"
            }

            calculateButton.setOnClickListener {

            val resultado = weight / (height / 100).pow(2)
                resultadoIMC.text = String.format(Locale.getDefault(), "%.2f", resultado)
        }



    }
}

