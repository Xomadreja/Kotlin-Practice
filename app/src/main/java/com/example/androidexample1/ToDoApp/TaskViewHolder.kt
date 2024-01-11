package com.example.androidexample1.ToDoApp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R

class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val cbTask = view.findViewById<CheckBox>(R.id.cbTask)
    private val tvTask = view.findViewById<TextView>(R.id.tvTask)
    fun render(task: Task) {
        if (task.isSelecte) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        tvTask.text = task.name
        cbTask.isChecked = task.isSelecte
        val color = when (task.category){
            TaskCategory.Busness -> R.color.todo_business_category
            TaskCategory.Other -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category
            TaskCategory.Work -> R.color.todo_subtitle_text
        }
        cbTask.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(cbTask.context,color))
    }

}