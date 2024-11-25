package com.example.a5first_android_app

// Print messages
//fun main() {
//    println("Use the val keyword when the value doesn't change.")
//    println("Use the var keyword when the value can change.")
//    println("When you define a function, you define the parameters that can be passed to it.")
//    println("When you call a function, you pass arguments for the parameters.")
//}

// Fix compile error
//fun main() {
//    println("New chat message from a friend")
//}

// String templates
//fun main() {
//    val discountPercentage = 20
//    val item = "Google Chromecast"
//    val offer = "Sale  - Up to $discountPercentage% discount off $item! Hurry Up!"
//
//    println(offer)
//}

// String concatenation
//fun main() {
//    val firstNumber = 10
//    val secondNumber = 5
//    val thirdNumber = 8
//
//    val result = add(firstNumber, secondNumber)
//    val anotherResult = subtract(firstNumber, thirdNumber)
//
//    println("$firstNumber + $secondNumber = $result")
//    println("$firstNumber - $thirdNumber = $anotherResult")
//}
//
//fun add(firstNumber: Int, secondNumber: Int): Int {
//    return firstNumber + secondNumber
//}
//
//fun subtract(firstNumber: Int, secondNumber: Int): Int {
//    return firstNumber - secondNumber
//}

//Default parameters
//fun main() {
//    println(displayAlertMessage(emailId = "example@gmail.com"))
//}
//fun displayAlertMessage(
//    operatingSystem: String = "Unknown OS",
//    emailId: String
//): String {
//    return "There is a new sign-in request on $operatingSystem for your Google Account $emailId."
//}

//Pedometer
//fun main() {
//    val steps = 4000
//    val caloriesBurned = pedometerStepsToCalories(steps)
//    println("Walking $steps steps burns $caloriesBurned calories")
//}
//
//fun pedometerStepsToCalories(numberOfSteps: Int): Double {
//    val caloriesBurnedForEachStep = 0.04
//    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
//    return totalCaloriesBurned
//}

//Compare two numbers
//fun main() {
//    println("Have I spent more time using my phone today: ${compareTime(300, 250)}")
//    println("Have I spent more time using my phone today: ${compareTime(300, 300)}")
//    println("Have I spent more time using my phone today: ${compareTime(200, 220)}")
//}
//
//fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
//    return timeSpentToday > timeSpentYesterday
//}

//Move duplicate code into a function
//fun main() {
//    printWeatherForCity("Ankara", 27, 31, 82)
//    printWeatherForCity("Tokyo", 32, 36, 10)
//    printWeatherForCity("Cape Town", 59, 64, 2)
//    printWeatherForCity("Guatemala City", 50, 55, 7)
//}
//
//fun printWeatherForCity(cityName: String, lowTemp: Int, highTemp: Int, chanceOfRain: Int) {
//    println("City: $cityName")
//    println("Low temperature: $lowTemp, High temperature: $highTemp")
//    println("Chance of rain: $chanceOfRain%")
//    println()
//}