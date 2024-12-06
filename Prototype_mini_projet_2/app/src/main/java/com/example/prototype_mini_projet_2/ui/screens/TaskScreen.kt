package com.example.prototype_mini_projet_2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prototype_mini_projet_2.model.Task
import com.example.prototype_mini_projet_2.ui.components.TaskInputField
import com.example.prototype_mini_projet_2.ui.components.TaskItem

@Composable
fun TaskScreen() {
    var tasks by rememberSaveable { mutableStateOf(listOf<Task>()) }

    Scaffold(
        topBar = {
            CustomHeader(title = "Liste de tâches")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            TaskInputField(onAddTask = { description ->
                tasks = tasks + Task(id = tasks.size + 1, description = description)
            })

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onToggleComplete = { updatedTask ->
                            tasks = tasks.map {
                                if (it.id == updatedTask.id) it.copy(isCompleted = !it.isCompleted) else it
                            }
                        }
                    )
                }
            }

            Button(
                onClick = {
                    tasks = tasks.filter { !it.isCompleted }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Supprimer les tâches terminées")
            }
        }
    }
}

@Composable
fun CustomHeader(title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
