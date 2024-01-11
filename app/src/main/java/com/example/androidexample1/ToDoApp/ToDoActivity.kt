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
        TaskCategory.Work,
        TaskCategory.Other
    )

    private val tasks = mutableListOf(
        Task("aaaaaaaa", TaskCategory.Work),
        Task("bbbbbbbb", TaskCategory.Work),
        Task("cccccccc", TaskCategory.Personal),
        Task("dddddddd", TaskCategory.Personal),
        Task("eeeeeeee", TaskCategory.Other),
        Task("ffffffff", TaskCategory.Busness)
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

        val etAddTask: EditText = dialog.findViewById(R.id.etAddTask)
        val btnCreateTask: Button = dialog.findViewById(R.id.btnCreateTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnCreateTask.setOnClickListener {
            val newTaskToAdd = etAddTask.text.toString()
            if (newTaskToAdd.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val rgButton: RadioButton = dialog.findViewById(selectedId)
                rgButton.text
                val taskCategoryNewTask: TaskCategory = when (rgButton.text) {
                    getString(R.string.todo_personal) -> TaskCategory.Personal
                    getString(R.string.todo_busness) -> TaskCategory.Busness
                    getString(R.string.todo_work) -> TaskCategory.Work
                    else -> {
                        TaskCategory.Other
                    }
                }
                tasks.add(Task(newTaskToAdd, taskCategoryNewTask))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }


    private fun initComponent() {
        rsCategories = findViewById(R.id.rsCategories)
        rsTasks = findViewById(R.id.rsTasks)
        fabNewTask = findViewById(R.id.fabNewTask)
    }

    private fun initUI() {
        categoriesAdapter =
            CategoriesAdapter(categories) { position -> onCategorySelected(position) }
        rsCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rsCategories.adapter = categoriesAdapter
        taskAdapter = TaskAdapter(tasks) { position -> onItemSelected(position) }
        rsTasks.layoutManager = LinearLayoutManager(this)
        rsTasks.adapter = taskAdapter
    }

    private fun onCategorySelected(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelecte = !tasks[position].isSelecte
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories = categories.filter { it.isSelected }
        lateinit var  newTask:List<Task>
        if (selectedCategories.size == 0) {
            newTask = tasks
        } else {
            newTask = tasks.filter { selectedCategories.contains(it.category) }
        }
        taskAdapter.tasks = newTask
        taskAdapter.notifyDataSetChanged()
    }
}