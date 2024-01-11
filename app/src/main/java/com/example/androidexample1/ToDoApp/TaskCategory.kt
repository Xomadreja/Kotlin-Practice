package com.example.androidexample1.ToDoApp

sealed class TaskCategory(var isSelected:Boolean=false) {
    object Personal:TaskCategory()
    object Work:TaskCategory()
    object Busness:TaskCategory()
    object Other:TaskCategory()
}