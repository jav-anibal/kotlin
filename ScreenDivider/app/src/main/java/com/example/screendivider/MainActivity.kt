package com.example.screendivider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.screendivider.ui.theme.ScreenDividerTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      ScreenDividerTheme {
        Scaffold(
          topBar = { TopAppBar(title = { Text("Mi Top Bar") }) },
          modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

          // Aplicamos el paddingValues a los composables internos
          Column(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          ) {
            Greeting(name = "Android")
            Spacer(modifier = Modifier.height(16.dp))
            ViewCounterGame()
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    style = MaterialTheme.typography.headlineMedium,
    modifier = modifier
  )
}

@Composable
fun ViewCounterGame(modifier: Modifier = Modifier) {
  Row(
    modifier = modifier // Aplicamos el modificador externo a la RAÍZ (el Row).
      .fillMaxSize(),
    horizontalArrangement = Arrangement.Center,

  ) {
    // 🚩 CAMBIO AQUÍ: Usamos 'Modifier' (con M mayúscula) para la cadena interna.
    Column(
      modifier = Modifier
        .weight(1f) // Esto le dice que ocupe la mitad del Row.
        .border(1.dp, Color.Red, RectangleShape),
      horizontalAlignment = Alignment.CenterHorizontally,

    ) {
      Text(
        text = "Izquierda",
        style = MaterialTheme.typography.headlineLarge
      )
    }

    Column(
      modifier = Modifier
        .weight(1f)
        .border(1.dp, Color.Blue, RectangleShape),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = "Derecha",
        style = MaterialTheme.typography.headlineLarge
      )
    }
  }
}

