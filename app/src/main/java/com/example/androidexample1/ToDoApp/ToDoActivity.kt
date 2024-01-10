package com.example.androidexample1.ToDoApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexample1.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ToDoActivity : AppCompatActivity() {
    private val categories = listOf(
        TaskCategory.Personal,
        TaskCategory.Busness,
        TaskCategory. Work,
        TaskCategory.Other)

    private val tasks = mutableListOf(
        Task("aaaaaaaa",TaskCategory.Work),
        Task("bbbbbbbb",TaskCategory.Work),
        Task("cccccccc",TaskCategory.Personal),
        Task("dddddddd",TaskCategory.Personal),
        Task("eeeeeeee",TaskCategory.Other),
        Task("ffffffff",TaskCategory.Busness)
    )
    private lateinit var rsCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rsTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var fabNewTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initComponent()
        initUI()
        initListeners()

    }

    private fun initListeners() {
        fabNewTask.setOnClickListener { showDiolog() }
    }

    private fun showDiolog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_new_task)

        val etAddTask:EditText = dialog.findViewById(R.id.etAddTask)
        val btnCreateTask:Button = dialog.findViewById(R.id.btnCreateTask)
        val rgCategories:RadioGroup=dialog.findViewById(R.id.rgCategories)

        btnCreateTask.setOnClickListener{
            val newTaskToAdd=etAddTask.text.toString()
            if(newTaskToAdd.isNotEmpty()){
                val selectedId=rgCategories.checkedRadioButtonId
                val rgButton:RadioButton=dialog.findViewById(selectedId)
                val taskCategoryNewTask:TaskCategory = when(rgButton.text){
                    getString(R.string.todo_personal)->TaskCategory.Personal
                    getString(R.string.todo_busness)->TaskCategory.Personal
                    getString(R.string.todo_work)->TaskCategory.Personal
                    else -> {TaskCategory.Other}
                }
                tasks.add(Task(newTaskToAdd,taskCategoryNewTask))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun updateTasks() {
        taskAdapter.notifyDataSetChanged()
    }

    private fun initUI() {
        categoriesAdapter= CategoriesAdapter(categories)
        rsCategories.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rsCategories.adapter=categoriesAdapter
        taskAdapter= TaskAdapter(tasks)
        rsTasks.layoutManager=LinearLayoutManager(this)
        rsTasks.adapter=taskAdapter
    }

    private fun initComponent() {
        rsCategories=findViewById(R.id.rsCategories)
        rsTasks=findViewById(R.id.rsTasks)
        fabNewTask=findViewById(R.id.fabNewTask)
    }
}