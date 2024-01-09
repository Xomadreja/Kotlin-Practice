package com.example.androidexample1.ImcAppCalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.androidexample1.ImcAppCalculator.ImcCalculatorActivity.Companion.imcKey
import com.example.androidexample1.R

class ResultImcActivity : AppCompatActivity() {
    private lateinit var tvStatus: TextView;
    private lateinit var tvImc: TextView;
    private lateinit var tvDescription: TextView;
    private lateinit var btnRecalculate: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result = intent.extras?.getDouble(imcKey) ?: -1.0
        initComponents()
        initUI(result)
        initListener()
    }

    private fun initListener() {
        btnRecalculate.setOnClickListener{onBackPressed()}
    }

    private fun initUI(result: Double) {
        tvImc.text=result.toString()
        when (result){
            in 0.00..18.50->{
                tvStatus.text=getString(R.string.title_underWeight)
                tvStatus.setTextColor(ContextCompat.getColor(this,R.color.underWeight))
                tvDescription.text=getString(R.string.description_underWeight)
            }
            in 18.51..24.99->{
                tvStatus.text=getString(R.string.title_normalWeight)
                tvStatus.setTextColor(ContextCompat.getColor(this,R.color.normalWeight))
                tvDescription.text=getString(R.string.description_normalWeight)
            }
            in 25.00..29.99->{
                tvStatus.text=getString(R.string.title_overWeight)
                tvStatus.setTextColor(ContextCompat.getColor(this,R.color.overWeight))
                tvDescription.text=getString(R.string.description_overWeight)
            }
            in 30.00..99.00->{
                tvStatus.text=getString(R.string.title_obesity)
                tvStatus.setTextColor(ContextCompat.getColor(this,R.color.obesity))
                tvDescription.text=getString(R.string.description_obesity)
            }
            else->{
                tvImc.text="Error"
                tvStatus.text="Error"
                tvDescription.text="Error"
            }

        }
    }

    private fun initComponents() {
        tvStatus = findViewById(R.id.tvStatus)
        tvImc = findViewById(R.id.tvImc)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate=findViewById(R.id.btnRecalculate)
    }
}