package com.example.androidexample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidexample1.FirstApp.FirstActivity
import com.example.androidexample1.FirstApp.ResultActivity
import com.example.androidexample1.ImcAppCalculator.ImcCalculatorActivity
import com.example.androidexample1.ToDoApp.ToDoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        btnSaludar.setOnClickListener {navigateToSaludar()  }
        val btnImcApp = findViewById<Button>(R.id.btnImcApp)
        btnImcApp.setOnClickListener {navigateToImcApp()  }
        val btnToDo = findViewById<Button>(R.id.btnToDo)
        btnToDo.setOnClickListener {navigateToDo()  }
    }
    fun navigateToDo() {
        val intent = Intent(this, ToDoActivity::class.java)
        startActivity(intent)
    }
     fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    fun navigateToSaludar(){
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }
}