package com.example.prototype_mini_projet_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.prototype_mini_projet_2.ui.screens.TaskScreen
import com.example.prototype_mini_projet_2.ui.theme.TodoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListTheme {
                TaskScreen()
            }
        }
    }
}
