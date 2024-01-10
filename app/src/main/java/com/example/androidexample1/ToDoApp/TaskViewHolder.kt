package com.example.androidexample1.ToDoApp

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R

class TaskViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val cbTask = view.findViewById<CheckBox>(R.id.cbTask)
    private val tvTask = view.findViewById<TextView>(R.id.tvTask)
    fun render(task: Task) {
        tvTask.text=task.name
    }

}