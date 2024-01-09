package com.example.androidexample1.ImcAppCalculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidexample1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected = false
    private var isFemaleSelected = false
    private var currentHeight: Int = 120
    private var currentWeight: Int = 60
    private var currentAge: Int = 20
    private lateinit var viewMale: CardView;
    private lateinit var viewFemale: CardView;
    private lateinit var rsHeight: RangeSlider;
    private lateinit var tvHeight: TextView;
    private lateinit var tvWeight: TextView;
    private lateinit var fabMinusWeight: FloatingActionButton;
    private lateinit var fabAddWeight: FloatingActionButton;
    private lateinit var tvAge: TextView;
    private lateinit var fabMinusAge: FloatingActionButton;
    private lateinit var fabAddAge: FloatingActionButton;
    private lateinit var btnCalculate: Button;

    companion object {
        const val imcKey = "imcResult"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        defaultValues()
        initListeners()
    }


    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        rsHeight = findViewById(R.id.rsHeight)
        tvHeight = findViewById(R.id.tvHeight)
        tvWeight = findViewById(R.id.tvWeight)
        fabMinusWeight = findViewById(R.id.fabMinusWeight)
        fabAddWeight = findViewById(R.id.fabAddWeight)
        tvAge = findViewById(R.id.tvAge)
        fabMinusAge = findViewById(R.id.fabMinusAge)
        fabAddAge = findViewById(R.id.fabAddAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun defaultValues() {
        setHeight()
        setWeight()
        setAge()

    }

    private fun setHeight() {
        tvHeight.text = "$currentHeight cm"
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()

    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            isMaleSelected = true
            isFemaleSelected = false
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            isMaleSelected = false
            isFemaleSelected = true
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            currentHeight = value.toInt()
            setHeight()
        }
        fabMinusWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        fabAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        fabMinusAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        fabAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val imc = calcularImc()
            navigateToResult(imc)
        }
    }

    private fun navigateToResult(imc: Double) {
        intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(imcKey, imc)
        startActivity(intent)
    }


    private fun calcularImc(): Double {
        val imc =
            currentWeight / ((currentHeight.toDouble() / 100) * (currentHeight.toDouble() / 100))
        return String.format("%.2f", imc).toDouble()
    }


    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundcolor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundcolor(isFemaleSelected))
    }

    private fun getBackgroundcolor(isSelected: Boolean): Int {
        val colorReference = if (isSelected) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

}