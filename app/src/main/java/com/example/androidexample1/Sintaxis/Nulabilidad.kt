package com.example.androidexample1.Sintaxis

fun main(){
    var name:String?= null
    //var name:String?= "Aylin"
    println(name?.get(5) ?: "es nulo")
}