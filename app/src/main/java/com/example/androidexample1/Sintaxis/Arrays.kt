package com.example.androidexample1.Sintaxis
/**
 * Arrays
 * */
fun main(){
    val semana = arrayOf("lun", "mar","mier","jue","vie","sab", "dom")
    for (elemento in semana){
        println(elemento)
    }
    for (posicion in semana.indices){
        println(posicion)
    }
    for ((posicion,values) in semana.withIndex()){
        println("$posicion, $values")
    }
    semana.forEach { println(it) }
}