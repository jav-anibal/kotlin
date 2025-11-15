package com.example.app_welcome_user.screens

import android.content.Intent
import android.os.Bundle
import android.text.Spanned
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_welcome_user.MainActivity

class LaucherActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LaucherScreen(
        onNameSend = { name ->
          val intent = Intent(this, MainActivity::class.java)
          intent.putExtra("nameUser", name)
          startActivity(intent)
        }
      )

    }
  }
}


@Composable
fun LaucherScreen(onNameSend: (String) -> Unit) {
  var nameState by remember { mutableStateOf(" ") }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center

  ) {
    Text(text = "Welcome to Android", style = MaterialTheme.typography.headlineMedium)

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
      value = nameState,
      onValueChange = { nameState = it },
      label = {Text("Ingrese su nombre") },
    )
    Spacer(modifier = Modifier.height(16.dp))

    Button(onClick = {onNameSend(nameState)}) {
      Text(text =  "Enviar datos")

    }


  }

}