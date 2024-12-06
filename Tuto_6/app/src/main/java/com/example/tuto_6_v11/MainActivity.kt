package com.example.tuto_6_v11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuto_6_v11.ui.theme.Tuto_6_V11Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tuto_6_V11Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Hello, $name!", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun Counter() {
    var counter by remember { mutableIntStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Counter: $counter", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = { counter++ }) {
            Text("Increment")
        }
    }
}

@Composable
fun AsyncDataLoader() {
    var data by remember { mutableStateOf("Loading...") }

    LaunchedEffect(Unit) {
        data = fetchData()
    }

    Text(text = data, style = MaterialTheme.typography.headlineMedium)
}

suspend fun fetchData(): String {
    delay(2000)
    return "Data Loaded"
}

@Composable
fun DataStream() {
    val dataFlow = flow {
        for (i in 1..5) {
            emit("Item $i")
            delay(1000)
        }
    }

    val data by dataFlow.collectAsState(initial = "Starting...")

    Text(text = data, style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun NameList() {
    var names by remember { mutableStateOf(listOf<String>()) }

    LaunchedEffect(Unit) {
        names = fetchNames()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        if (names.isEmpty()) {
            Text(text = "Loading names...", style = MaterialTheme.typography.bodyLarge)
        } else {
            Text(text = "Names:", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            names.forEach { name ->
                Text(text = name, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

suspend fun fetchNames(): List<String> {
    delay(2000)
    return listOf("Alice", "Bob", "Charlie", "Diana", "Eve")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tuto_6_V11Theme {
        NameList()
    }
}
