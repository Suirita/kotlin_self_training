package com.example.prototype_mini_projet_3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prototype_mini_projet_3.ui.theme.Prototype_mini_projet_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prototype_mini_projet_3Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AffirmationApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AffirmationApp(modifier: Modifier = Modifier) {
    var affirmations by remember { mutableStateOf(mutableListOf(
        "Crois en toi-même et en toutes tes capacités.",
        "Chaque jour est une nouvelle opportunité.",
        "Tu es plus fort que tu ne le penses.",
        "N'abandonne jamais, les miracles prennent du temps.",
        "Le succès commence par la volonté de l'atteindre."
    )) }

    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                placeholder = { Text("Ajouter une affirmation") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(
                onClick = {
                    if (textFieldValue.text.isNotEmpty()) {
                        affirmations.add(textFieldValue.text)
                        textFieldValue = TextFieldValue("") // Clear the input field
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text("Ajouter")
            }
            AffirmationList(affirmations)
        }
    }
}

@Composable
fun AffirmationList(affirmations: List<String>) {
    val context = LocalContext.current
    var clickedCardIndex by remember { mutableStateOf(-1) }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(affirmations.size) { index ->
            AffirmationCard(
                affirmation = affirmations[index],
                isSelected = clickedCardIndex == index,
                onClick = {
                    clickedCardIndex = index
                    Toast.makeText(context, "Affirmation cliquée : ${affirmations[index]}", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
fun AffirmationCard(affirmation: String, isSelected: Boolean, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.LightGray else MaterialTheme.colorScheme.surface
        )
    ) {
        Text(
            text = affirmation,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AffirmationAppPreview() {
    Prototype_mini_projet_3Theme {
        AffirmationApp()
    }
}
