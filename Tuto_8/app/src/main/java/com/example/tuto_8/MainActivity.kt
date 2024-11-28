package com.example.tuto_8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Data class for list items
data class ListItem(val title: String)

// Dummy data for the list
val sampleItems = listOf(
    ListItem("Task 1"),
    ListItem("Task 2"),
    ListItem("Task 3")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Ensure you're using Material3 Theme
            MaterialTheme {
                ListScreen(items = sampleItems)
            }
        }
    }
}

@Composable
fun ListScreen(items: List<ListItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(items) { item ->
            ListItemRow(item = item)
            Divider() // Separator between items
        }
    }
}

@Composable
fun ListItemRow(item: ListItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO: Add click action */ }
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(16.dp)) // Optional spacer for text padding
        // Display the text
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewListScreen() {
    MaterialTheme {
        ListScreen(items = sampleItems)
    }
}
