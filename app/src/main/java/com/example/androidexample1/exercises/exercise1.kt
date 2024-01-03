package com.example.androidexample1.exercises
/**
 * Por lo general, el teléfono te proporciona un resumen de las notificaciones.
 * En el código inicial que se proporciona en el siguiente fragmento de código, escribe un programa que imprima el mensaje de resumen según la cantidad de notificaciones que recibiste. El mensaje debe incluir lo siguiente:
 *
 * La cantidad exacta de notificaciones cuando haya menos de 100
 * 99+ como cantidad de notificaciones cuando haya 100 o más
 *
 *
 * Examples of Android Web Page
 * */
fun main() {
    val morningNotifications = 51
    val eveningNotifications = 135

    printNotificationSummary(morningNotifications)
    printNotificationSummary(eveningNotifications)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages<100) println("You have $numberOfMessages notifications.")
    else println("Your phone is blowing up! You have 99+ notifications.")
}

/***Ejercicio resuelto YEY***/