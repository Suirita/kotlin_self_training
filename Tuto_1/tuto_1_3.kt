package com.example.a5first_android_app

fun main() {
    println(birthdayGreeting("Fahd", 20))
}

//fun birthdayGreeting() {
//    println("Happy Birthday, Fahd!")
//    println("You are now 20 years old!")
//}

// parameter
//fun birthdayGreeting(name: String): String {
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now 20 years old!"
//    return "$nameGreeting\n$ageGreeting"
//}

// multiple parameter
fun birthdayGreeting(name: String, age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}