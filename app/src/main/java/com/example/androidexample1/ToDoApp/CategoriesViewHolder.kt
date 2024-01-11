package com.example.androidexample1.ToDoApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vCategoryBar: View = view.findViewById(R.id.vCategoryBar)
    private val viewItemCategory: CardView = view.findViewById(R.id.viewItemCategory)
    fun render(taskCategory: TaskCategory, onCategorySelected: (Int) -> Unit) {
        itemView.setOnClickListener{onCategorySelected(layoutPosition)}
        var color = if (taskCategory.isSelected){
            R.color.todo_background_disabled
        }
        else{
            R.color.todo_background_card
        }
        viewItemCategory.setCardBackgroundColor(ContextCompat.getColor(viewItemCategory.context,color))

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