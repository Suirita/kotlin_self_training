package com.example.prototype_mini_projet_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import com.example.prototype_mini_projet_2.ui.theme.Prototype_mini_projet_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Prototype_mini_projet_2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    TipCalculatorApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TipCalculatorApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Amount input field
        var amountInput by remember { mutableStateOf("") }
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Montant de l'addition") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Tip percentage slider
        var tipPercentage by remember { mutableStateOf(15f) }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Pourcentage : ${tipPercentage.toInt()}%")
            Slider(
                value = tipPercentage,
                onValueChange = { tipPercentage = it },
                valueRange = 0f..30f,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Calculate tip and total amount
        val amount = amountInput.toFloatOrNull() ?: 0f
        val tipAmount = amount * tipPercentage / 100
        val totalAmount = amount + tipAmount

        // Display results
        Text("Pourboire : %.2f MAD".format(tipAmount))
        Text("Total : %.2f MAD".format(totalAmount))
    }
}

@Preview(showBackground = true)
@Composable
fun TipCalculatorAppPreview() {
    Prototype_mini_projet_2Theme {
        TipCalculatorApp()
    }
}
