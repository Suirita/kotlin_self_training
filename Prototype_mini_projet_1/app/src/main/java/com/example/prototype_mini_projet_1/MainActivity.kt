package com.example.prototype_mini_projet_1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import com.example.prototype_mini_projet_1.ui.theme.Prototype_mini_projet_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prototype_mini_projet_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarteDeVisite(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CarteDeVisite(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nom et profession
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Développeur Android",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Coordonnées
        ContactInfo(
            label = "Téléphone :",
            value = "+33 6 12 34 56 78",
            onClick = {
                val callIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:+33612345678")
                }
                context.startActivity(callIntent)
            }
        )
        ContactInfo(
            label = "Email :",
            value = "johndoe@example.com",
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:johndoe@example.com")
                }
                context.startActivity(emailIntent)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Bouton pour site web
        Button(onClick = {
            val websiteIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.johndoe.com")
            }
            context.startActivity(websiteIntent)
        }) {
            Text("Visiter mon site")
        }
    }
}

@Composable
fun ContactInfo(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label ",
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            color = Color.Blue
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CarteDeVisitePreview() {
    Prototype_mini_projet_1Theme {
        CarteDeVisite()
    }
}
