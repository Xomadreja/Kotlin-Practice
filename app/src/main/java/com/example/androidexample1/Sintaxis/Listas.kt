package com.example.androidexample1.Sintaxis

fun main() {
    //listInmutable()
    listMutable()
}
//Igual a un Array
fun listInmutable() {
    val listaInm = listOf<String>("lun", "mar", "mier", "jue", "vie", "sab", "dom")
    println(listaInm)
    println(listaInm.last())
    println(listaInm.first())
    //filtrar
    val example = listaInm.filter { it.contains("a") }
    println(example)
    // it es la iteracion directamente pero si o si debe llamarse it
    listaInm.forEach { println(it) }
    // para asignarle un nombre mas intuitivo esta es otra forma esto es igual al anterior
    listaInm.forEach { dia -> println(dia) }
}

fun listMutable() {
    val listaMut = mutableListOf("lun", "mar", "mier", "jue", "vie", "sab", "dom")
    listaMut.add(0,"AylinDay")
    println(listaMut)

}