package com.example.androidexample1.ToDoApp

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vCategoryBar: View = view.findViewById(R.id.vCategoryBar)
    fun render(taskCategory: TaskCategory) {
        when (taskCategory) {
            TaskCategory.Busness -> {
                tvCategoryName.text = "Negocios"
                vCategoryBar.setBackgroundColor(ContextCompat.getColor(vCategoryBar.context,R.color.todo_business_category))
            }

            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"
                vCategoryBar.setBackgroundColor(ContextCompat.getColor(vCategoryBar.context,R.color.todo_other_category))
            }

            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                vCategoryBar.setBackgroundColor(ContextCompat.getColor(vCategoryBar.context,R.color.todo_personal_category))
            }

            TaskCategory.Work -> {
                tvCategoryName.text = "Trabajo"
                vCategoryBar.setBackgroundColor(ContextCompat.getColor(vCategoryBar.context,R.color.todo_subtitle_text))
            }
        }

    }

}