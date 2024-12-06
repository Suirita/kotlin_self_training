package com.example.prototype_mini_projet_2.model

data class Task(
    val id: Int,
    val description: String,
    var isCompleted: Boolean = false
)