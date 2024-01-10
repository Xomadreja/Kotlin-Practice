package com.example.androidexample1.ToDoApp

sealed class TaskCategory {
    object Personal:TaskCategory()
    object Work:TaskCategory()
    object Busness:TaskCategory()
    object Other:TaskCategory()
}