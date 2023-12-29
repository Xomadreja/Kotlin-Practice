package com.example.androidexample1.Sintaxis

fun main() {
    //variables()
    nameAge("Patricio Estrella")
    val resta = resta(45, 34)
    if (resta > 55) {
        println(resta)
    }
    months(9)
    println(trimestre(5))
    semestre(1)
    result(true)
}

//Valores (Constantes)
fun variables() {
    // Variables Numericas
    val age: Int = 22
    val example: Long = 1234567
    val kgHarina: Float = 12.3f
    val kgAzucar: Double = 3.432424
    // Variables Alfanumericas
    val charEx: Char = 'e'
    val charEx2: Char = '1'
    val charEx3: Char = '@'
    val stringEx: String = "asdwq sdcdsc e234@@"
    // Variables Booleanas
    val bool: Boolean = true
    println(kgAzucar)
    //Valores (Constantes)
    var age2: Int = 22
    age2 = 20
    println("Hola me llamo Aylin y tengo $age2")
}

// Funcion
fun nameAge(name: String, edad: Int = 70) {
    println("Mi llamos $name y tengo $edad")
}

fun resta(n1: Int, n2: Int): Int {
    return n1 - n2
}

fun restaShort(n1: Int, n2: Int): Int = n1 - n2

//when
fun months(month:Int) {
    when (month) {
        1 -> println("ene")
        2 -> println("feb")
        3 -> println("mar")
        4 -> println("abr")
        5 -> println("may")
        6 -> println("jun")
        7 -> println("jul")
        8 -> println("ago")
        9 -> {
            println("sep")
            println("sep")
        }

        10 -> println("oct")
        11 -> println("nov")
        12 -> println("dic")
        else -> println("no es un mes valido")
    }
}
fun trimestre(tri:Int):String {
    return when (tri) {
        1,2,3 -> "first"
        4,5,6 -> "second"
        else -> "no es un mes valido"
    }
}
fun semestre(tri:Int) {
    when (tri) {
        in 1..6 -> println("first")
        in 7..12 -> println("second")
        else -> println("no es un mes valido")
    }
}
fun result(value:Any) {
    when(value){
        is Int -> println(value+value)
        is String ->println("string")
        is Boolean ->if (value) println("true")
    }
}