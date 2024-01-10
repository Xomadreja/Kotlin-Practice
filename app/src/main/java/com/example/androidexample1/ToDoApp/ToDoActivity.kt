package com.example.androidexample1.ToDoApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R

class ToDoActivity : AppCompatActivity() {
    private val categories = listOf(
        TaskCategory.Personal,
        TaskCategory.Busness,
        TaskCategory. Work,
        TaskCategory.Other)
    private lateinit var rsCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initComponent()
        initUI()

    }

    private fun initUI() {
        categoriesAdapter= CategoriesAdapter(categories)
        rsCategories.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rsCategories.adapter=categoriesAdapter
    }

    private fun initComponent() {
        rsCategories=findViewById(R.id.rsCategories)
    }
}